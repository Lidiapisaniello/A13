package matchStatistics

import (
	"github.com/alarmfox/game-repository/api"
	"net/http"
)

type Service interface {
	Create(request *CreateRequest) (MatchStatistics, error)
	UpdateHasWon(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper, hasWon bool) (MatchStatistics, error)
	GetMatchStatistics(playerId Long, gameMode StringWrapper, classUT StringWrapper, robotType StringWrapper, difficulty StringWrapper) (MatchStatistics, error)
	UpdateAchievements(matchID Long, newAchievements []string) (GameModeAchievements, error)
	GetAchievements(matchID Long) (GameModeAchievements, error)
	GetMatchStatisticsWithAchievements(playerID Long) ([]WithAchievements, error)
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

func (rc *Controller) GetMatchStatistics(w http.ResponseWriter, r *http.Request) error {
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

	winMatch, err := rc.service.GetMatchStatistics(playerId, gameMode, classUT, robotType, difficulty)
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
	matchId, err := api.FromUrlParams[Long](r, "matchId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	request, err := api.FromJsonBody[UpdateAchievementsRequest](r.Body)
	if err != nil {
		return err
	}

	winMatch, err := rc.service.UpdateAchievements(matchId, request.Achievements)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}

func (rc *Controller) GetAchievement(w http.ResponseWriter, r *http.Request) error {
	matchId, err := api.FromUrlParams[Long](r, "matchId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	winMatch, err := rc.service.GetAchievements(matchId)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}

func (rc *Controller) GetAchievementByPlayerID(w http.ResponseWriter, r *http.Request) error {
	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		return api.MakeHttpError(err)
	}

	winMatch, err := rc.service.GetMatchStatisticsWithAchievements(playerId)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, winMatch)
}
