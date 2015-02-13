package application.domain.model;

import application.domain.AbstractPersistable;
import application.domain.additional.Skill;
import application.solver.comparator.PersonalShiftStrengthComparator;
import application.solver.comparator.TaskComparator;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;


@PlanningEntity(difficultyComparatorClass = TaskComparator.class)
@XStreamAlias("Task")
public class Task extends AbstractPersistable {

    private PersonalShift shift;
    private List<Skill> requirements;

    public Task() {
    }

    public Task(Long id, List<Skill> requirements) {
        super(id);
        this.requirements = requirements;
    }

    @PlanningVariable(valueRangeProviderRefs = {"personalShiftRange"}, strengthComparatorClass =
            PersonalShiftStrengthComparator.class)
    public PersonalShift getShift() {
        return shift;
    }

    public void setShift(PersonalShift shift) {
        this.shift = shift;
    }

    public List<Skill> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Skill> requirements) {
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id + ", " +
                "requirements=" + requirements +
                '}';
    }
}
