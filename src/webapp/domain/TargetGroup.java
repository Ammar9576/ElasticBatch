package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the TARGET_GROUP database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "TARGET_GROUP")
public class TargetGroup extends AbstractDomainObject {

	

	@Override
	@Id
	@Column(name = "TARGET_GROUP_ID")
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "TARGET_GROUP_NAME")
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}