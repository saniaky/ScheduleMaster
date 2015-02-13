package application.domain.additional;

import application.domain.AbstractPersistable;

import java.util.List;


public class Nurse extends AbstractPersistable {

    public Nurse() {
    }

    public Nurse(Long id, List<Skill> skills) {
        super(id);
        this.skills = skills;
    }

    private List<Skill> skills;

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
