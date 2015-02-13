package application;

import application.domain.model.PersonalShift;
import application.domain.model.Schedule;
import application.domain.model.Task;
import application.solver.generator.ScheduleGenerator;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;


public class Runner {

    public static void main(String[] args) {
        SolverFactory solverFactory = SolverFactory.createFromXmlResource("problem.xml");
        Solver solver = solverFactory.buildSolver();
        Schedule schedule = ScheduleGenerator.generateSchedule(10, 20);
        solver.solve(schedule);
        schedule = (Schedule) solver.getBestSolution();
        for (PersonalShift shift : schedule.getPersonalShifts()) {
            System.out.println(shift);
            System.out.println(shift.getNurse() + ", will have tasks: ");
            for (Task task : schedule.getTasks()) {
                if (task.getShift().equals(shift)) {
                    System.out.println(" - " + task);
                }
            }
            System.out.println("\n===================");
        }
    }

}
