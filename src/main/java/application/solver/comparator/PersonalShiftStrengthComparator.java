package application.solver.comparator;

import application.domain.model.PersonalShift;
import org.apache.commons.lang.builder.CompareToBuilder;

import java.io.Serializable;
import java.util.Comparator;


public class PersonalShiftStrengthComparator implements Comparator<PersonalShift>, Serializable {

    @Override
    public int compare(PersonalShift o1, PersonalShift o2) {
        return new CompareToBuilder().append(o1.getId(), o2.getId()).toComparison();
    }
}
