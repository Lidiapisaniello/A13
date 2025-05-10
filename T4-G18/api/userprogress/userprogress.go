package userprogress

import (
	"errors"
	"strconv"
)

type GameRecord struct {
	ID         int64  `json:"game_record_id"`
	GameMode   string `json:"game_mode"`
	ClassUT    string `json:"class_ut"`
	RobotType  string `json:"robot_type"`
	Difficulty string `json:"difficulty"`
}

type UserGameProgress struct {
	ID           int64 `json:"user_game_progress_id"`
	GameRecordID int64 `json:"game_record_id"`
	PlayerID     int64 `json:"player_id"`
	HasWon       bool  `json:"has_won"`
}

type AchievementProgress struct {
	ID                 int64  `json:"achievement_progress_id"`
	UserGameProgressID int64  `json:"user_game_progress_id"`
	Achievement        string `json:"achievement"`
}

type GlobalAchievementProgress struct {
	ID                int64  `json:"global_achievement_progress_id"`
	PlayerID          int64  `json:"player_id"`
	GlobalAchievement string `json:"global_achievement"`
}

type GlobalAchievementProgressResponse struct {
	PlayerID           int64    `json:"player_id"`
	GlobalAchievements []string `json:"global_achievements"`
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

type UserGameProgressResponse struct {
	ID           int64    `json:"user_game_progress_id"`
	PlayerID     int64    `json:"player_id"`
	GameMode     string   `json:"game_mode"`
	ClassUT      string   `json:"class_ut"`
	RobotType    string   `json:"robot_type"`
	Difficulty   string   `json:"difficulty"`
	HasWon       bool     `json:"has_won"`
	Achievements []string `json:"achievements"`
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

func (GlobalAchievementProgressResponse) Validate() error {
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
