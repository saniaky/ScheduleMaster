package application.solver.generator;

import application.domain.model.Schedule;


public class ScheduleGenerator {

    public static Schedule generateSchedule(int nursesCount, int tasksCount) {
        return new Schedule(TasksGenerator.generateTasks(tasksCount), ShiftGenerator.generateShifts(nursesCount));
    }

}
