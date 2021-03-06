package application.domain.model;

import application.domain.AbstractPersistable;
import application.domain.additional.Nurse;
import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("PersonalShift")
public class PersonalShift extends AbstractPersistable {

    private Nurse nurse;

    public PersonalShift() {
    }

    public PersonalShift(Long id, Nurse nurse) {
        super(id);
        this.nurse = nurse;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
}
