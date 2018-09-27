package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the CHANNELS_LOOKUP_VW database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CHANNEL", schema = "onair")
public class Channel extends AbstractDomainObject {
	
	public Channel() {
	}	
	
	@Override
	@Id
	@Column(name = "CHANNEL_ID")
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "CHANNEL_NAME")
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	
}