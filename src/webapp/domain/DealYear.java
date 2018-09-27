package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the DEAL_YEAR database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "DEAL_YEAR")
public class DealYear extends AbstractDomainObject {

	

	@Override
	@Id
	@Column(name = "DEAL_YEAR_ID")
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "DEAL_YEAR_NAME")
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}