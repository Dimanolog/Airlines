package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

public class AbstractFilter implements Serializable {

    private SingularAttribute sortProperty;
    private boolean sortOrder; 
    
    private int offset;
    private int limit;

    public SingularAttribute getSortProperty() {
        return sortProperty;
    }

    public void setSortProperty(SingularAttribute sortProperty) {
        this.sortProperty = sortProperty;
    }

    public boolean isSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(boolean sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = (int) limit;
    }

}
