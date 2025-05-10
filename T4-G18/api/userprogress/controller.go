package userprogress

import (
	"github.com/alarmfox/game-repository/api"
	"net/http"
)

type Service interface {
	Create(r *CreateRequest) (UserGameProgressResponse, error)
	GetUserGameProgress(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper) (UserGameProgressResponse, error)
	UpdateHasWon(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper, hasWon bool) (UserGameProgressResponse, error)
	UpdateAchievements(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper, newAchievements []string) (UserGameProgressResponse, error)
	UpdateGlobalAchievements(playerId Long, newAchievements []string) (GlobalAchievementProgressResponse, error)
	GetAllUserGameProgresses(playerId Long) ([]UserGameProgressResponse, error)
	GetAllGlobalAchievementsByPlayerID(playerId Long) (GlobalAchievementProgressResponse, error)
}

type Controller struct {
	service Service
}

func NewController(rs Service) *Controller {
	return &Controller{
		service: rs,
	}
}

func (rc *Controller) Create(w http.ResponseWriter, r *http.Request) error {

	request, err := api.FromJsonBody[CreateRequest](r.Body)
	if err != nil {
		return err
	}
	winMatch, err := rc.service.Create(&request)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusCreated, winMatch)
}

func (rc *Controller) GetUserGameProgress(w http.ResponseWriter, r *http.Request) error {
	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	gameMode, err := api.FromUrlParams[StringWrapper](r, "gameMode")
	if err != nil {
		return api.MakeHttpError(err)
	}

	classUT, err := api.FromUrlParams[StringWrapper](r, "classUT")
	if err != nil {
		return api.MakeHttpError(err)
	}

	robotType, err := api.FromUrlParams[StringWrapper](r, "robotType")
	if err != nil {
		return api.MakeHttpError(err)
	}

	difficulty, err := api.FromUrlParams[StringWrapper](r, "difficulty")
	if err != nil {
		return api.MakeHttpError(err)
	}

	winMatch, err := rc.service.GetUserGameProgress(playerId, gameMode, classUT, robotType, difficulty)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}

func (rc *Controller) UpdateHasWon(w http.ResponseWriter, r *http.Request) error {
	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	gameMode, err := api.FromUrlParams[StringWrapper](r, "gameMode")
	if err != nil {
		return api.MakeHttpError(err)
	}

	classUT, err := api.FromUrlParams[StringWrapper](r, "classUT")
	if err != nil {
		return api.MakeHttpError(err)
	}

	robotType, err := api.FromUrlParams[StringWrapper](r, "robotType")
	if err != nil {
		return api.MakeHttpError(err)
	}

	difficulty, err := api.FromUrlParams[StringWrapper](r, "difficulty")
	if err != nil {
		return api.MakeHttpError(err)
	}

	request, err := api.FromJsonBody[UpdateRequest](r.Body)
	if err != nil {
		return err
	}

	winMatch, err := rc.service.UpdateHasWon(playerId, gameMode, classUT, robotType, difficulty, request.HasWon)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}

func (rc *Controller) UpdateAchievements(w http.ResponseWriter, r *http.Request) error {
	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	gameMode, err := api.FromUrlParams[StringWrapper](r, "gameMode")
	if err != nil {
		return api.MakeHttpError(err)
	}

	classUT, err := api.FromUrlParams[StringWrapper](r, "classUT")
	if err != nil {
		return api.MakeHttpError(err)
	}

	robotType, err := api.FromUrlParams[StringWrapper](r, "robotType")
	if err != nil {
		return api.MakeHttpError(err)
	}

	difficulty, err := api.FromUrlParams[StringWrapper](r, "difficulty")
	if err != nil {
		return api.MakeHttpError(err)
	}

	request, err := api.FromJsonBody[UpdateAchievementsRequest](r.Body)
	if err != nil {
		return err
	}

	winMatch, err := rc.service.UpdateAchievements(playerId, gameMode, classUT, robotType, difficulty, request.Achievements)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}

func (rc *Controller) UpdateGlobalAchievements(w http.ResponseWriter, r *http.Request) error {
	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	request, err := api.FromJsonBody[UpdateAchievementsRequest](r.Body)
	if err != nil {
		return err
	}

	winMatch, err := rc.service.UpdateGlobalAchievements(playerId, request.Achievements)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}

func (rc *Controller) GetAllUserGameProgresses(w http.ResponseWriter, r *http.Request) error {
	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	winMatch, err := rc.service.GetAllUserGameProgresses(playerId)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}

func (rc *Controller) GetAllGlobalAchievementsByPlayerID(w http.ResponseWriter, r *http.Request) error {
	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	winMatch, err := rc.service.GetAllGlobalAchievementsByPlayerID(playerId)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}
