package experience

import (
	"github.com/alarmfox/game-repository/api"
	"github.com/alarmfox/game-repository/model"
	"gorm.io/gorm"
)

type ExperienceStorage struct {
	db *gorm.DB
}

func NewRepository(db *gorm.DB) *ExperienceStorage {
	return &ExperienceStorage{
		db: db,
	}
}

func (es *ExperienceStorage) Create(r *CreateRequest) (Experience, error) {
	var experience = model.Experience{
		PlayerID:         r.PlayerID,
		ExperiencePoints: r.ExperiencePoints,
	}

	// Validazione di CreateRequest
	if err := r.Validate(); err != nil {
		return Experience{}, err
	}

	err := es.db.Transaction(func(tx *gorm.DB) error {
		return tx.Create(&experience).Error
	})

	if err != nil {
		return Experience{}, api.MakeServiceError(err)
	}

	return *fromModel(&experience), nil
}

func (es *ExperienceStorage) Update(playerId Long, experiencePoints int) (Experience, error) {
	var experience model.Experience

	err := es.db.Transaction(func(tx *gorm.DB) error {
		if err := tx.Where("player_id = ?", playerId).First(&experience).Error; err != nil {
			if err == gorm.ErrRecordNotFound {
				// Se il record non esiste restituisco un errore
				return api.ErrNotFound
			}
			return err
		}

		// Aggiorno l'esperienza sommando i nuovi punti
		experience.ExperiencePoints += experiencePoints
		return tx.Save(&experience).Error
	})

	if err != nil {
		return Experience{}, api.MakeServiceError(err)
	}

	return *fromModel(&experience), nil
}

func (es *ExperienceStorage) GetExperience(playerID Long) (Experience, error) {
	var experience model.Experience

	// Validazione del playerID
	if playerID == "" {
		return Experience{}, api.ErrInvalidParam
	}

	// Recupera l'esperienza del giocatore dal database
	err := es.db.Where("player_id = ?", playerID).First(&experience).Error
	if err != nil {
		// Se il giocatore non esiste o c'è un errore nel recupero
		return Experience{}, api.MakeServiceError(err)
	}

	// Restituisci l'esperienza del giocatore
	return *fromModel(&experience), nil
}
