package application.domain;

import org.apache.commons.lang.builder.CompareToBuilder;

import java.io.Serializable;


public abstract class AbstractPersistable implements Comparable<AbstractPersistable>, Serializable {

    protected Long id;

    protected AbstractPersistable() {

    }

    public AbstractPersistable(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int compareTo(AbstractPersistable other) {
        return new CompareToBuilder().append(getClass().getName(), other.getClass().getName()).append(id, other.getId())
                .toComparison();
    }

    public String toString() {
        return "[" + getClass().getName().replaceAll(".*\\.", "") + "-" + id + "]";
    }
}
