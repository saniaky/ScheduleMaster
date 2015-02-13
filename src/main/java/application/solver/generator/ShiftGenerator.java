package application.solver.generator;

import application.domain.additional.Nurse;
import application.domain.model.PersonalShift;

import java.util.ArrayList;
import java.util.List;


public class ShiftGenerator {

    private final static int SHIFTS_PER_NURSE = 3;

    private static Integer id = 0;

    public static List<PersonalShift> generateShifts(int nursesCount) {
        List<PersonalShift> shifts = new ArrayList<PersonalShift>();
        for (int i = 0; i < nursesCount; i++) {
            Nurse nurse = NurseGenerator.generateNurse();
            for (int j = 0; j < SHIFTS_PER_NURSE; j++) {
                shifts.add(new PersonalShift((id++).longValue(), nurse));
            }
        }
        return shifts;
    }

}
