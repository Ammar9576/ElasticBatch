package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the POSTING_METHODOLOGY database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "POSTING_METHODOLOGY")
public class PostingMethodology extends AbstractDomainObject {
	public PostingMethodology() {
	}

	@Override
	@Id
	@Column(name = "POSTING_METHODOLOGY_ID")
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "POSTING_METHODOLOGY_NAME")
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}