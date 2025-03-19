package experience

import (
	"errors"
	"github.com/alarmfox/game-repository/model"
	"strconv"
)

type Experience struct {
	PlayerID         int64 `json:"player_id"`
	ExperiencePoints int   `json:"experience_points"`
}

type CreateRequest struct {
	PlayerID         int64 `json:"player_id"`
	ExperiencePoints int   `json:"experience_points"`
}

type UpdateRequest struct {
	ExperiencePoints int `json:"experience_points"`
}

func fromModel(r *model.Experience) *Experience {
	return &Experience{
		PlayerID:         r.PlayerID,
		ExperiencePoints: r.ExperiencePoints,
	}
}

func (CreateRequest) Validate() error {
	return nil
}

func (Experience) Validate() error {
	return nil
}

func (UpdateRequest) Validate() error {
	return nil
}

type Long string

func (Long) Parse(s string) (Long, error) {
	if _, err := strconv.ParseInt(s, 10, 64); err != nil {
		return "", err
	}
	return Long(s), nil
}

func (s Long) AsString() (int64, error) {
	return strconv.ParseInt(string(s), 10, 64)
}

func (s Long) Validate() error {
	_, err := strconv.ParseInt(string(s), 10, 64)
	if err != nil {
		return errors.New("invalid Long value")
	}
	return nil
}
