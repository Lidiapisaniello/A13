package robot

import (
	"fmt"
	"math/rand"

	"github.com/alarmfox/game-repository/api"
	"github.com/alarmfox/game-repository/model"
	"gorm.io/gorm"
	"gorm.io/gorm/clause"
)

type RobotStorage struct {
	db *gorm.DB
}

func NewRobotStorage(db *gorm.DB) *RobotStorage {
	return &RobotStorage{
		db: db,
	}
}

func (rs *RobotStorage) CreateBulk(r *CreateRequest) (int, error) {
	robots := make([]model.Robot, len(r.Robots))

	for i, robot := range r.Robots {
		robots[i] = model.Robot{
			TestClassId:               robot.TestClassId,
			Difficulty:                robot.Difficulty,
			Type:                      robot.Type,
			Coverage:                  robot.Coverage,
			JacocoLineCovered:         robot.JacocoLineCovered,
			JacocoBranchCovered:       robot.JacocoBranchCovered,
			JacocoInstructionCovered:  robot.JacocoInstructionCovered,
			JacocoLineMissed:          robot.JacocoLineMissed,
			JacocoBranchMissed:        robot.JacocoBranchMissed,
			JacocoInstructionMissed:   robot.JacocoInstructionMissed,
			EvoSuiteLine:              robot.EvoSuiteLine,
			EvoSuiteBranch:            robot.EvoSuiteBranch,
			EvoSuiteException:         robot.EvoSuiteException,
			EvoSuiteWeakMutation:      robot.EvoSuiteWeakMutation,
			EvoSuiteOutput:            robot.EvoSuiteOutput,
			EvoSuiteMethod:            robot.EvoSuiteMethod,
			EvoSuiteMethodNoException: robot.EvoSuiteMethodNoException,
			EvoSuiteCBranch:           robot.EvoSuiteCBranch,
		}
	}

	err := rs.db.
		Clauses(clause.OnConflict{
			UpdateAll: true,
		}).
		CreateInBatches(&robots, 100).
		Error

	return len(robots), api.MakeServiceError(err)
}

func (gs *RobotStorage) FindByFilter(testClassId string, difficulty string, robotType string) (Robot, error) {
	var (
		robot model.Robot
		ids   []int64
	)

	err := gs.db.Transaction(func(tx *gorm.DB) error {
		query := tx.Model(&model.Robot{}).
			Where(&model.Robot{
				TestClassId: testClassId,
				Difficulty:  difficulty,
				Type:        robotType,
			}).
			Where("type = ?", robotType)

		// Recupera solo gli ID
		if err := query.Select("id").Find(&ids).Error; err != nil {
			return err
		}

		if len(ids) == 0 {
			return gorm.ErrRecordNotFound
		}
		var id int64
		pos := rand.Intn(len(ids))
		id = ids[pos]

		return tx.First(&robot, id).Error
	})

	//fmt.Printf("Robot extracted: %+v\n", robot)

	return *fromModel(&robot), api.MakeServiceError(err)
}

func (gs *RobotStorage) GetAllAvailableRobots() ([]AvailableRobot, error) {
	var robots []AvailableRobot

	err := gs.db.Model(&model.Robot{}).
		Select("test_class_id, type AS robot_type, difficulty").
		Find(&robots).Error

	if err != nil {
		return nil, api.MakeServiceError(err)
	}

	if len(robots) == 0 {
		return nil, gorm.ErrRecordNotFound
	}

	//fmt.Println("Robots extracted:", robots)

	return robots, nil
}

func (gs *RobotStorage) GetEvoSuiteCoverageBy(testClassId string, difficulty string, robotType string) (EvoSuiteCoverage, error) {
	var evoSuiteCoverage EvoSuiteCoverage
	fmt.Println("GetEvoSuiteCoverageBy")

	err := gs.db.Model(&model.Robot{}).
		Select(`
			evo_suite_line, 
			evo_suite_branch, 
			evo_suite_exception, 
			evo_suite_weak_mutation, 
			evo_suite_output, 
			evo_suite_method, 
			evo_suite_method_no_exception, 
			evo_suite_c_branch
		`).
		Where("test_class_id = ? AND difficulty = ? AND type = ?", testClassId, difficulty, robotType).
		First(&evoSuiteCoverage).Error

	fmt.Println("Coverage extracted:", evoSuiteCoverage)
	fmt.Println("Error:", err)

	if err != nil {
		return EvoSuiteCoverage{}, api.MakeServiceError(err)
	}

	fmt.Printf("Coverage extracted: %v\n", evoSuiteCoverage)

	return evoSuiteCoverage, nil
}

func (rs *RobotStorage) DeleteByTestClass(testClassId string) error {

	db := rs.db.Where(&model.Robot{TestClassId: testClassId}).
		Delete(&[]model.Robot{})
	if db.Error != nil {
		return db.Error
	} else if db.RowsAffected < 1 {
		return api.ErrNotFound
	}

	return nil
}
