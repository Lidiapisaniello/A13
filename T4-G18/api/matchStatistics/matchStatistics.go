package matchStatistics

import (
	"errors"
	"github.com/alarmfox/game-repository/model"
	"strconv"
)

type MatchStatistics struct {
	ID         int64  `json:"match_id"`
	PlayerID   int64  `json:"player_id"`
	GameMode   string `json:"game_mode"`
	ClassUT    string `json:"class_ut"`
	RobotType  string `json:"robot_type"`
	Difficulty string `json:"difficulty"`
	HasWon     bool   `json:"has_won"`
}

type GameModeAchievements struct {
	MatchID     int64    `json:"match_id"`
	Achievement []string `json:"achievements"`
}

type CreateRequest struct {
	PlayerID   int64  `json:"player_id"`
	GameMode   string `json:"game_mode"`
	ClassUT    string `json:"class_ut"`
	RobotType  string `json:"robot_type"`
	Difficulty string `json:"difficulty"`
}

type UpdateRequest struct {
	HasWon bool `json:"has_won"`
}

type UpdateAchievementsRequest struct {
	Achievements []string `json:"achievements"`
}

type GameModeAchievement struct {
	MatchID     int64  `json:"match_id"`
	Achievement string `json:"achievement"`
}

type WithAchievements struct {
	ID           int64    `json:"match_id"`
	PlayerID     int64    `json:"player_id"`
	GameMode     string   `json:"game_mode"`
	ClassUT      string   `json:"class_ut"`
	RobotType    string   `json:"robot_type"`
	Difficulty   string   `json:"difficulty"`
	HasWon       bool     `json:"has_won"`
	Achievements []string `json:"achievements"`
}

// Mappatura dal modello DB alla struttura JSON
func fromModel(r *model.MatchStatistics) *MatchStatistics {
	return &MatchStatistics{
		ID:         r.ID,
		PlayerID:   r.PlayerID,
		GameMode:   r.GameMode,
		ClassUT:    r.ClassUT,
		RobotType:  r.RobotType,
		Difficulty: r.Difficulty,
		HasWon:     r.HasWon,
	}
}

func fromModelAchievements(achievements []model.GameModeAchievements) GameModeAchievements {
	var achievementList []string
	var matchID int64

	if len(achievements) > 0 {
		matchID = achievements[0].MatchID
		for _, ach := range achievements {
			achievementList = append(achievementList, ach.Achievement)
		}
	}

	return GameModeAchievements{
		MatchID:     matchID,
		Achievement: achievementList,
	}
}

// Validazioni
func (CreateRequest) Validate() error {
	return nil
}

func (UpdateRequest) Validate() error {
	return nil
}

func (UpdateAchievementsRequest) Validate() error {
	return nil
}

// Classi Wrapper

type StringWrapper string

func (StringWrapper) Parse(s string) (StringWrapper, error) {
	return StringWrapper(s), nil
}

func (s StringWrapper) AsString() string {
	return string(s)
}

func (StringWrapper) Validate() error {
	return nil
}

type Long int64

func (Long) Parse(s string) (Long, error) {
	value, err := strconv.ParseInt(s, 10, 64)
	if err != nil {
		return 0, err
	}
	return Long(value), nil
}

func (s Long) AsInt64() int64 {
	return int64(s)
}

func (s Long) Validate() error {
	if s < 0 {
		return errors.New("invalid Long value: must be non-negative")
	}
	return nil
}
