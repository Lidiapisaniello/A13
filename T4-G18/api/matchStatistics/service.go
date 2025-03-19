package matchStatistics

import (
	"errors"
	"github.com/alarmfox/game-repository/api"
	"github.com/alarmfox/game-repository/model"
	"gorm.io/gorm"
	"log"
)

type MatchStatisticsStorage struct {
	db *gorm.DB
}

func NewRepository(db *gorm.DB) *MatchStatisticsStorage {
	return &MatchStatisticsStorage{db: db}
}

func (ms *MatchStatisticsStorage) Create(r *CreateRequest) (MatchStatistics, error) {
	match := model.MatchStatistics{
		PlayerID:   r.PlayerID,
		GameMode:   r.GameMode,
		ClassUT:    r.ClassUT,
		RobotType:  r.RobotType,
		Difficulty: r.Difficulty,
		HasWon:     false,
	}

	err := ms.db.Create(&match).Error
	if err != nil {
		return MatchStatistics{}, api.MakeServiceError(err)
	}

	return *fromModel(&match), nil
}

func (ms *MatchStatisticsStorage) GetMatchStatistics(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper) (MatchStatistics, error) {
	var match model.MatchStatistics

	err := ms.db.Where("player_id = ? AND game_mode = ? AND class_ut = ? AND robot_type = ? AND difficulty = ?",
		playerId, gameMode, classUT, robotType, difficulty).
		First(&match).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		return MatchStatistics{ID: -1}, nil
	} else if err != nil {
		return MatchStatistics{}, api.MakeServiceError(err)
	}

	result := *fromModel(&match)
	return result, nil
}

func (ms *MatchStatisticsStorage) UpdateHasWon(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper, hasWon bool) (MatchStatistics, error) {
	var match model.MatchStatistics

	err := ms.db.Model(&match).
		Where("player_id = ? AND game_mode = ? AND class_ut = ? AND robot_type = ? AND difficulty = ?",
			playerId, gameMode, classUT, robotType, difficulty).
		Update("has_won", hasWon).Error

	if err != nil {
		return MatchStatistics{}, api.MakeServiceError(err)
	}

	// Recupero il record aggiornato
	err = ms.db.Where("player_id = ? AND game_mode = ? AND class_ut = ? AND robot_type = ? AND difficulty = ?",
		playerId, gameMode, classUT, robotType, difficulty).
		First(&match).Error

	if err != nil {
		return MatchStatistics{}, api.MakeServiceError(err)
	}

	return *fromModel(&match), nil
}

func (ms *MatchStatisticsStorage) UpdateAchievements(matchID Long, newAchievements []string) (GameModeAchievements, error) {
	var achievements []model.GameModeAchievements

	log.Printf("[INFO] Inizio aggiornamento achievements per MatchID: %d", matchID)

	err := ms.db.Transaction(func(tx *gorm.DB) error {
		for _, ach := range newAchievements {
			var existing model.GameModeAchievements
			if err := tx.Where("match_id = ? AND achievement = ?", matchID, ach).First(&existing).Error; err != nil {
				if errors.Is(err, gorm.ErrRecordNotFound) {
					// Creazione nuovo achievement
					newAchievement := model.GameModeAchievements{
						MatchID:     matchID.AsInt64(),
						Achievement: ach,
					}
					if err := tx.Create(&newAchievement).Error; err != nil {
						log.Printf("[ERROR] Errore durante l'inserimento di %s: %v", ach, err)
						return err
					}
					log.Printf("[INFO] Achievement aggiunto: %s per MatchID %d", ach, matchID)
					achievements = append(achievements, newAchievement)
				} else {
					return err
				}
			} else {
				log.Printf("[INFO] Achievement già presente: %s per MatchID %d", ach, matchID)
				achievements = append(achievements, existing)
			}
		}
		return nil
	})

	if err != nil {
		log.Printf("[ERROR] Fallito aggiornamento achievements per MatchID %d: %v", matchID, err)
		return GameModeAchievements{}, api.MakeServiceError(err)
	}

	log.Printf("[SUCCESS] Achievements aggiornati per MatchID %d", matchID)

	return fromModelAchievements(achievements), nil
}

func (ms *MatchStatisticsStorage) GetAchievements(matchID Long) (GameModeAchievements, error) {
	var achievements []model.GameModeAchievements

	err := ms.db.Where("match_id = ?", matchID).Find(&achievements).Error
	if err != nil {
		return GameModeAchievements{}, api.MakeServiceError(err)
	}

	return fromModelAchievements(achievements), nil
}

func (ms *MatchStatisticsStorage) GetMatchStatisticsWithAchievements(playerID Long) ([]WithAchievements, error) {
	var matchStats []MatchStatistics

	err := ms.db.Where("player_id = ?", playerID).Find(&matchStats).Error
	if err != nil {
		return nil, api.MakeServiceError(err)
	}

	var result []WithAchievements

	for _, match := range matchStats {
		var achievements []model.GameModeAchievements
		err := ms.db.Where("match_id = ?", match.ID).Find(&achievements).Error
		if err != nil {
			return nil, api.MakeServiceError(err)
		}

		// Converti gli achievements in un array di stringhe
		modelAchievements := fromModelAchievements(achievements)

		result = append(result, WithAchievements{
			ID:           match.ID,
			PlayerID:     match.PlayerID,
			GameMode:     match.GameMode,
			ClassUT:      match.ClassUT,
			RobotType:    match.RobotType,
			Difficulty:   match.Difficulty,
			HasWon:       match.HasWon,
			Achievements: modelAchievements.Achievement,
		})
	}

	return result, nil
}
