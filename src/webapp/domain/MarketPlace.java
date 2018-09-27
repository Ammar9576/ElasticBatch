package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the MARKETPLACE_CVW database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "MARKETPLACE_CVW")
public class MarketPlace extends AbstractDomainObject {

	

	public MarketPlace() {
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