package application.solver.generator;

import application.domain.additional.Nurse;
import application.solver.generator.util.RandomUtil;


public class NurseGenerator {

    private final static Integer SKILLS_PER_NURSE_LIMIT = 3;

    private static Integer id = 0;

    public static Nurse generateNurse() {
        int skillsCount = RandomUtil.randInt(1, SKILLS_PER_NURSE_LIMIT);
        return new Nurse((id++).longValue(), SkillsGenerator.generateSkills(skillsCount));
    }

}
