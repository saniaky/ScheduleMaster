package application.solver.comparator;

import application.domain.model.Task;
import org.apache.commons.lang.builder.CompareToBuilder;

import java.io.Serializable;
import java.util.Comparator;


public class TaskComparator implements Comparator<Task>, Serializable {

    @Override
    public int compare(Task o1, Task o2) {
        return new CompareToBuilder().append(o1.getShift(), o2.getShift()).append(o1.getId(), o2.getId())
                .toComparison();
    }
}
