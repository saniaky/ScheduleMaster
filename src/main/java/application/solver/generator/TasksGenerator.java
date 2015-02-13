package application.solver.generator;

import application.domain.model.Task;
import application.solver.generator.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;


public class TasksGenerator {

    private final static int SKILLS_PER_TASK_LIMIT = 2;

    private static Integer id = 0;

    public static List<Task> generateTasks(int tasksCount) {
        List<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i < tasksCount; i++) {
            int skillsCount = RandomUtil.randInt(1, SKILLS_PER_TASK_LIMIT);
            tasks.add(new Task((id++).longValue(), SkillsGenerator.generateSkills(skillsCount)));
        }
        return tasks;
    }

}
