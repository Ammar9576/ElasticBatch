package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the HOUSE_NO_LOOKUP_VW database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "CHANNEL_DIVISION")
public class Division extends AbstractDomainObject {
	
	
	public Division() {
	}
	
	
	@Override
	@Id
	@Column(name = "CHANNEL_DIVISION_ID")
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "CHANNEL_DIVISION_NAME")
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}
	
}