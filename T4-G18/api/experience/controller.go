package experience

import (
	"github.com/alarmfox/game-repository/api"
	"log"
	"net/http"
)

type Service interface {
	Create(request *CreateRequest) (Experience, error)
	Update(playerId Long, experiencePoints int) (Experience, error)
	GetExperience(playerID Long) (Experience, error)
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
	experience, err := rc.service.Create(&request)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusCreated, experience)
}

func (rc *Controller) Update(w http.ResponseWriter, r *http.Request) error {
	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		return err
	}

	request, err := api.FromJsonBody[UpdateRequest](r.Body)
	if err != nil {
		return err
	}

	experience, err := rc.service.Update(playerId, request.ExperiencePoints)
	if err != nil {
		return api.MakeHttpError(err)
	}

	return api.WriteJson(w, http.StatusOK, experience)
}

func (rc *Controller) GetExperience(w http.ResponseWriter, r *http.Request) error {
	log.Println("[INFO] Handling GetExperience request")

	playerId, err := api.FromUrlParams[Long](r, "playerId")
	if err != nil {
		log.Printf("[ERROR] Failed to parse playerId: %v\n", err)
		return api.MakeHttpError(err)
	}
	log.Printf("[INFO] Extracted playerId: %d\n", playerId)

	experience, err := rc.service.GetExperience(playerId)
	if err != nil {
		log.Printf("[ERROR] Failed to get experience for playerId %d: %v\n", playerId, err)
		return api.MakeHttpError(err)
	}
	log.Printf("[INFO] Retrieved experience: %+v\n", experience)

	return api.WriteJson(w, http.StatusOK, experience)
}
