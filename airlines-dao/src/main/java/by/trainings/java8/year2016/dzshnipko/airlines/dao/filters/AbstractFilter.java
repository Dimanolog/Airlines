package by.trainings.java8.year2016.dzshnipko.airlines.dao.filters;

import java.io.Serializable;
import javax.persistence.metamodel.SingularAttribute;


public class AbstractFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	private SingularAttribute<?,?> sortProperty;
    private boolean sortOrder; 
    
    private Integer offset;
    private Integer limit;

    public SingularAttribute getSortProperty() {
        return sortProperty;
    }

    public void setSortProperty(SingularAttribute sortProperty) {
        this.sortProperty = sortProperty;
    }

	public boolean isSortOrder() {
		return sortOrder;
	}

	public Integer getOffset() {
		return offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setSortOrder(boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
    
    

}
