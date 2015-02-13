package application.solver.score;

import application.domain.additional.Skill;
import application.domain.model.PersonalShift;
import application.domain.model.Schedule;
import application.domain.model.Task;
import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;


public class ScheduleEasyScoreCalculator implements EasyScoreCalculator<Schedule> {

    private final static Integer DIFFERENCE_SKILL_PENALTY = 10;
    private final static Integer TOO_MUCH_TASKS_PENALTY = 50;
    private final static Integer TASKS_PER_SHIFT_LIMIT = 2;

    @Override
    public Score calculateScore(Schedule solution) {
        int hardScore = 0;
        int softScore = 0;

        for (PersonalShift shift : solution.getPersonalShifts()) {
            for (Task task : solution.getTasks()) {
                if (task.getShift() != null && task.getShift().compareTo(shift) == 0) {
                    hardScore -= getDifferentSkillsCount(shift, task) * DIFFERENCE_SKILL_PENALTY;
                }
            }
            Integer tasksCount = getShiftTasksCount(solution, shift);
            if (tasksCount > TASKS_PER_SHIFT_LIMIT) {
                hardScore -= (tasksCount - TASKS_PER_SHIFT_LIMIT) * TOO_MUCH_TASKS_PENALTY;
            }
        }
        return HardSoftScore.valueOf(hardScore, softScore);
    }

    private Integer getDifferentSkillsCount(PersonalShift shift, Task task) {
        int difference = 0;
        for (Skill skill : task.getRequirements()) {
            if (!shift.getNurse().getSkills().contains(skill)) {
                difference++;
            }
        }
        return difference;
    }

    private Integer getShiftTasksCount(Schedule schedule, PersonalShift shift) {
        int count = 0;
        for (Task task : schedule.getTasks()) {
            if (task.getShift() != null && task.getShift().compareTo(shift) == 0) {
                count++;
            }
        }
        return count;
    }
}
