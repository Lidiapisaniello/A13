package userprogress

import (
	"errors"
	"github.com/alarmfox/game-repository/api"
	"gorm.io/gorm"
	"log"
)

type GameRecordStorage struct {
	db *gorm.DB
}

func NewRepository(db *gorm.DB) *GameRecordStorage {
	return &GameRecordStorage{db: db}
}

func (ms *GameRecordStorage) Create(r *CreateRequest) (UserGameProgressResponse, error) {
	var gameRecord GameRecord
	log.Println("[Create] Searching for existing GameRecord with parameters:", r.GameMode, r.ClassUT, r.RobotType, r.Difficulty)

	err := ms.db.Where("game_mode = ? AND class_ut = ? AND robot_type = ? AND difficulty = ?",
		r.GameMode, r.ClassUT, r.RobotType, r.Difficulty).First(&gameRecord).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		log.Println("[Create] GameRecord not found, creating new one")
		gameRecord = GameRecord{
			GameMode:   r.GameMode,
			ClassUT:    r.ClassUT,
			RobotType:  r.RobotType,
			Difficulty: r.Difficulty,
		}
		if err := ms.db.Create(&gameRecord).Error; err != nil {
			log.Println("[Create] Error creating GameRecord:", err)
			return UserGameProgressResponse{}, api.MakeServiceError(err)
		}
	} else if err != nil {
		log.Println("[Create] Error retrieving GameRecord:", err)
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	log.Println("[Create] Found or created GameRecord ID:", gameRecord.ID)

	var userGameProgress UserGameProgress
	log.Println("[Create] Searching for existing UserGameProgress with PlayerID:", r.PlayerID, "and GameRecordID:", gameRecord.ID)

	err = ms.db.Where("game_record_id = ? AND player_id = ?", gameRecord.ID, r.PlayerID).First(&userGameProgress).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		log.Println("[Create] UserGameProgress not found, creating new one")
		userGameProgress = UserGameProgress{
			GameRecordID: gameRecord.ID,
			PlayerID:     r.PlayerID,
			HasWon:       false,
		}
		if err := ms.db.Create(&userGameProgress).Error; err != nil {
			log.Println("[Create] Error creating UserGameProgress:", err)
			return UserGameProgressResponse{}, api.MakeServiceError(err)
		}
	} else if err != nil {
		log.Println("[Create] Error retrieving UserGameProgress:", err)
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	log.Println("[Create] Found or created UserGameProgress ID:", userGameProgress.ID)

	achievements, err := ms.GetAchievements(userGameProgress.ID)
	if err != nil {
		log.Println("[Create] Error retrieving achievements:", err)
		return UserGameProgressResponse{}, err
	}

	log.Println("[Create] Retrieved Achievements:", achievements)

	return UserGameProgressResponse{
		ID:           userGameProgress.ID,
		PlayerID:     userGameProgress.PlayerID,
		GameMode:     gameRecord.GameMode,
		ClassUT:      gameRecord.ClassUT,
		RobotType:    gameRecord.RobotType,
		Difficulty:   gameRecord.Difficulty,
		HasWon:       userGameProgress.HasWon,
		Achievements: achievements,
	}, nil
}

func (ms *GameRecordStorage) GetUserGameProgress(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper) (UserGameProgressResponse, error) {
	var gameRecord GameRecord
	var userGameProgress UserGameProgress

	log.Println("[GetUserGameProgress] Searching for GameRecord with parameters:", gameMode, classUT, robotType, difficulty)

	err := ms.db.Where("game_mode = ? AND class_ut = ? AND robot_type = ? AND difficulty = ?",
		gameMode, classUT, robotType, difficulty).First(&gameRecord).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		log.Println("[GetUserGameProgress] GameRecord not found")
		return UserGameProgressResponse{}, api.MakeServiceError(errors.New("GameRecord not found"))
	} else if err != nil {
		log.Println("[GetUserGameProgress] Error retrieving GameRecord:", err)
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	log.Println("[GetUserGameProgress] Found GameRecord ID:", gameRecord.ID)

	err = ms.db.Where("player_id = ? AND game_record_id = ?", playerId, gameRecord.ID).
		First(&userGameProgress).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		log.Println("[GetUserGameProgress] UserGameProgress not found")
		return UserGameProgressResponse{}, api.MakeServiceError(errors.New("UserGameProgress not found"))
	} else if err != nil {
		log.Println("[GetUserGameProgress] Error retrieving UserGameProgress:", err)
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	log.Println("[GetUserGameProgress] Found UserGameProgress ID:", userGameProgress.ID)

	achievements, err := ms.GetAchievements(userGameProgress.ID)
	if err != nil {
		log.Println("[GetUserGameProgress] Error retrieving achievements:", err)
		return UserGameProgressResponse{}, err
	}

	log.Println("[GetUserGameProgress] Retrieved Achievements:", achievements)

	return UserGameProgressResponse{
		ID:           userGameProgress.ID,
		PlayerID:     userGameProgress.PlayerID,
		GameMode:     gameRecord.GameMode,
		ClassUT:      gameRecord.ClassUT,
		RobotType:    gameRecord.RobotType,
		Difficulty:   gameRecord.Difficulty,
		HasWon:       userGameProgress.HasWon,
		Achievements: achievements,
	}, nil
}

func (ms *GameRecordStorage) UpdateHasWon(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper, hasWon bool) (UserGameProgressResponse, error) {
	var userGameProgress UserGameProgress
	var gameRecord GameRecord

	// Trovo il GameRecord corrispondente
	err := ms.db.Where("game_mode = ? AND class_ut = ? AND robot_type = ? AND difficulty = ?",
		gameMode, classUT, robotType, difficulty).First(&gameRecord).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		return UserGameProgressResponse{}, api.MakeServiceError(errors.New("GameRecord not found"))
	} else if err != nil {
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	// Trovo il progresso del giocatore basato sul GameRecord
	err = ms.db.Where("player_id = ? AND game_record_id = ?", playerId, gameRecord.ID).
		First(&userGameProgress).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		return UserGameProgressResponse{}, api.MakeServiceError(errors.New("UserGameProgress not found"))
	} else if err != nil {
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	// Aggiorno il campo HasWon
	userGameProgress.HasWon = hasWon
	if err := ms.db.Save(&userGameProgress).Error; err != nil {
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	// Recupero gli achievement associati
	achievements, err := ms.GetAchievements(userGameProgress.ID)
	if err != nil {
		return UserGameProgressResponse{}, err
	}

	return UserGameProgressResponse{
		ID:           userGameProgress.ID,
		PlayerID:     userGameProgress.PlayerID,
		GameMode:     gameRecord.GameMode,
		ClassUT:      gameRecord.ClassUT,
		RobotType:    gameRecord.RobotType,
		Difficulty:   gameRecord.Difficulty,
		HasWon:       userGameProgress.HasWon,
		Achievements: achievements,
	}, nil
}

func (ms *GameRecordStorage) UpdateAchievements(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper, newAchievements []string) (UserGameProgressResponse, error) {
	var userGameProgress UserGameProgress
	var gameRecord GameRecord

	log.Printf("Updating achievements for player %d in gameMode %s, classUT %s, robotType %s, difficulty %s", playerId, gameMode, classUT, robotType, difficulty)

	// Trovo il GameRecord corrispondente
	err := ms.db.Where("game_mode = ? AND class_ut = ? AND robot_type = ? AND difficulty = ?",
		gameMode, classUT, robotType, difficulty).First(&gameRecord).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		log.Println("GameRecord not found")
		return UserGameProgressResponse{}, api.MakeServiceError(errors.New("GameRecord not found"))
	} else if err != nil {
		log.Printf("Error retrieving GameRecord: %v", err)
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	// Trovo il progresso del giocatore basato sul GameRecord
	err = ms.db.Where("player_id = ? AND game_record_id = ?", playerId, gameRecord.ID).
		First(&userGameProgress).Error

	if errors.Is(err, gorm.ErrRecordNotFound) {
		log.Println("UserGameProgress not found")
		return UserGameProgressResponse{}, api.MakeServiceError(errors.New("UserGameProgress not found"))
	} else if err != nil {
		log.Printf("Error retrieving UserGameProgress: %v", err)
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	// Creo una mappa per verificare gli achievement già presenti
	var existingAchievements []AchievementProgress
	if err := ms.db.Where("user_game_progress_id = ?", userGameProgress.ID).Find(&existingAchievements).Error; err != nil {
		log.Printf("Error retrieving existing achievements: %v", err)
		return UserGameProgressResponse{}, api.MakeServiceError(err)
	}

	// Creo una mappa per evitare di aggiungere gli achievement già esistenti
	existingMap := make(map[string]bool)
	for _, a := range existingAchievements {
		existingMap[a.Achievement] = true
	}

	// Aggiungo solo gli achievement mancanti
	for _, achievement := range newAchievements {
		if existingMap[achievement] {
			log.Printf("Skipping existing achievement: %s", achievement)
			continue
		}

		newAchievement := AchievementProgress{
			UserGameProgressID: userGameProgress.ID,
			Achievement:        achievement,
		}

		log.Printf("Inserting achievement: %s", achievement)
		if err := ms.db.Create(&newAchievement).Error; err != nil {
			log.Printf("Error inserting achievement %s: %v", achievement, err)
			return UserGameProgressResponse{}, api.MakeServiceError(err)
		}

		log.Printf("Achievement %s added successfully", achievement)
	}

	// Recupero gli achievement aggiornati
	achievements, err := ms.GetAchievements(userGameProgress.ID)
	if err != nil {
		return UserGameProgressResponse{}, err
	}

	return UserGameProgressResponse{
		ID:           userGameProgress.ID,
		PlayerID:     userGameProgress.PlayerID,
		GameMode:     gameRecord.GameMode,
		ClassUT:      gameRecord.ClassUT,
		RobotType:    gameRecord.RobotType,
		Difficulty:   gameRecord.Difficulty,
		HasWon:       userGameProgress.HasWon,
		Achievements: achievements,
	}, nil
}

func (ms *GameRecordStorage) UpdateGlobalAchievements(playerId Long, newAchievements []string) (GlobalAchievementProgressResponse, error) {
	log.Printf("Updating global achievements for player %d", playerId)

	// Recupera gli achievement globali esistenti per il giocatore
	var existing []GlobalAchievementProgress
	if err := ms.db.Where("player_id = ?", playerId).Find(&existing).Error; err != nil {
		log.Printf("Error retrieving GlobalAchievementProgress: %v", err)
		return GlobalAchievementProgressResponse{}, api.MakeServiceError(err)
	}

	// Crea mappa degli achievement esistenti per evitare duplicati
	existingMap := make(map[string]bool)
	for _, entry := range existing {
		existingMap[entry.GlobalAchievement] = true
	}

	// Aggiunge solo quelli mancanti
	for _, achievement := range newAchievements {
		if existingMap[achievement] {
			log.Printf("Skipping existing achievement: %s", achievement)
			continue
		}

		newEntry := GlobalAchievementProgress{
			PlayerID:          playerId.AsInt64(),
			GlobalAchievement: achievement,
		}

		if err := ms.db.Create(&newEntry).Error; err != nil {
			log.Printf("Error inserting global achievement %s: %v", achievement, err)
			return GlobalAchievementProgressResponse{}, api.MakeServiceError(err)
		}
		log.Printf("Added new global achievement: %s", achievement)
	}

	// Ricarica la lista aggiornata
	var updated []GlobalAchievementProgress
	if err := ms.db.Where("player_id = ?", playerId).Find(&updated).Error; err != nil {
		log.Printf("Error retrieving updated GlobalAchievementProgress: %v", err)
		return GlobalAchievementProgressResponse{}, api.MakeServiceError(err)
	}

	// Estrae la lista di achievement come []string
	achievements := make([]string, 0, len(updated))
	for _, entry := range updated {
		achievements = append(achievements, entry.GlobalAchievement)
	}

	return GlobalAchievementProgressResponse{
		PlayerID:           playerId.AsInt64(),
		GlobalAchievements: achievements,
	}, nil
}

func (ms *GameRecordStorage) GetAllUserGameProgresses(playerId Long) ([]UserGameProgressResponse, error) {
	var userGameProgressList []UserGameProgress

	log.Printf("Retrieving game progress for player %d", playerId)

	// Recupero tutti i progressi di gioco dell'utente
	err := ms.db.Where("player_id = ?", playerId).Find(&userGameProgressList).Error
	if err != nil {
		log.Printf("Error retrieving UserGameProgress: %v", err)
		return nil, api.MakeServiceError(err)
	}

	var responses []UserGameProgressResponse

	// Itero su ciascun progresso per costruire la risposta
	for _, userGameProgress := range userGameProgressList {
		var gameRecord GameRecord
		if err := ms.db.Where("id = ?", userGameProgress.GameRecordID).First(&gameRecord).Error; err != nil {
			log.Printf("Error retrieving GameRecord for userGameProgress ID %d: %v", userGameProgress.ID, err)
			return nil, api.MakeServiceError(err)
		}

		achievements, err := ms.GetAchievements(userGameProgress.ID)
		if err != nil {
			return nil, err
		}

		responses = append(responses, UserGameProgressResponse{
			ID:           userGameProgress.ID,
			PlayerID:     userGameProgress.PlayerID,
			GameMode:     gameRecord.GameMode,
			ClassUT:      gameRecord.ClassUT,
			RobotType:    gameRecord.RobotType,
			Difficulty:   gameRecord.Difficulty,
			HasWon:       userGameProgress.HasWon,
			Achievements: achievements,
		})
	}

	return responses, nil
}

func (ms *GameRecordStorage) GetAllGlobalAchievementsByPlayerID(playerId Long) (GlobalAchievementProgressResponse, error) {
	log.Printf("Fetching global achievements for player %d", playerId)

	// Recupero gli achievement aggiornati
	achievements, err := ms.GetGlobalAchievements(playerId.AsInt64())
	if err != nil {
		return GlobalAchievementProgressResponse{}, err
	}

	return GlobalAchievementProgressResponse{
		PlayerID:           playerId.AsInt64(),
		GlobalAchievements: achievements,
	}, nil
}

// GetAchievements Funzione di supporto che recupera gli achievement associati a un UserGameProgress
func (ms *GameRecordStorage) GetAchievements(progressID int64) ([]string, error) {
	var achievements []string
	var achievementRecords []AchievementProgress

	log.Printf("Retrieving achievements for progress ID: %d", progressID)

	err := ms.db.Where("user_game_progress_id = ?", progressID).Find(&achievementRecords).Error
	if err != nil {
		log.Printf("Error retrieving achievements: %v", err)
		return nil, api.MakeServiceError(err)
	}

	if len(achievementRecords) == 0 {
		log.Printf("No achievements found for progress ID: %d", progressID)
	} else {
		log.Println("All achievement progress records:")
		for _, record := range achievementRecords {
			log.Printf("UserGameProgressID: %d, Achievement: %s", record.UserGameProgressID, record.Achievement)
		}
	}

	for _, record := range achievementRecords {
		achievements = append(achievements, record.Achievement)
	}

	log.Printf("Final achievements list: %v", achievements)
	return achievements, nil
}

// GetGlobalAchievements Funzione di supporto che recupera i global achievement associati a un PlayerID
func (ms *GameRecordStorage) GetGlobalAchievements(playerID int64) ([]string, error) {
	var achievements []string
	var achievementRecords []GlobalAchievementProgress

	log.Printf("Retrieving global achievements for player ID: %d", playerID)

	err := ms.db.Where("player_id = ?", playerID).Find(&achievementRecords).Error
	if err != nil {
		log.Printf("Error retrieving global achievements: %v", err)
		return nil, api.MakeServiceError(err)
	}

	if len(achievementRecords) == 0 {
		log.Printf("No global achievements found for player ID: %d", playerID)
	} else {
		log.Println("All global achievement progress records:")
		for _, record := range achievementRecords {
			log.Printf("PlayerID: %d, Global Achievement: %s", record.PlayerID, record.GlobalAchievement)
		}
	}

	for _, record := range achievementRecords {
		achievements = append(achievements, record.GlobalAchievement)
	}

	log.Printf("Final Global achievements list: %v", achievements)
	return achievements, nil
}
