package application.domain.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import org.optaplanner.persistence.xstream.impl.score.XStreamScoreConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@PlanningSolution
@XStreamAlias("Schedule")
public class Schedule implements Solution<HardSoftScore>{

    public Schedule() {
    }

    public Schedule(List<Task> tasks, List<PersonalShift> personalShifts) {
        this.tasks = tasks;
        this.personalShifts = personalShifts;
    }

    @XStreamConverter(value = XStreamScoreConverter.class, types = { HardSoftScoreDefinition.class})
    private HardSoftScore score;

    private List<Task> tasks;

    private List<PersonalShift> personalShifts;

    @PlanningEntityCollectionProperty
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @ValueRangeProvider(id = "personalShiftRange")
    public List<PersonalShift> getPersonalShifts() {
        return personalShifts;
    }

    public void setPersonalShifts(List<PersonalShift> personalShifts) {
        this.personalShifts = personalShifts;
    }

    @Override
    public HardSoftScore getScore() {
        return score;
    }

    @Override
    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    @Override
    public Collection<?> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(personalShifts);
        return facts;
    }

}
