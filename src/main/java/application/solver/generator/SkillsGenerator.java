package application.solver.generator;

import application.domain.additional.Skill;
import application.solver.generator.util.RandomUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SkillsGenerator {

    public static List<Skill> generateSkills(Integer skillsCount) {
        List<Skill> skills = new ArrayList<Skill>();
        Set<Integer> alreadyUsedSkillNumber = new HashSet<Integer>();
        while (skills.size() < skillsCount) {
            Integer newSkillIndex = RandomUtil.randInt(0, Skill.values().length - 1);
            if(!alreadyUsedSkillNumber.contains(newSkillIndex)) {
                skills.add(Skill.values()[newSkillIndex]);
                alreadyUsedSkillNumber.add(newSkillIndex);
            }
        }
        return skills;
    }

}