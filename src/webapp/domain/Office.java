package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the SALES_LOCATION_LOOKUP database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "SALES_LOCATION_LOOKUP")
public class Office extends AbstractDomainObject {

	public Office() {
	}


	@Override
	@Id
	@Column(name = "CODE")
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "DESCRIPTION")
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	

}