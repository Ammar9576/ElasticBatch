package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the AGENCY database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AGENCY_EVW", schema = "nbc_cust")
public class Agency extends AbstractDomainObject {

private String sfName;
	
	

	/**
	 * @return the sfName
	 */
	@Column(name = "SF_AGENCY_ID")
	public String getSfName() {
		return sfName;
	}

	/**
	 * @param sfName the sfName to set
	 */
	public void setSfName(String sfName) {
		this.sfName = sfName;
	}

	public Agency() {
	}

	
	@Override
	@Id
	@Column(name = "AGENCY_ID")
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "AGENCY_NAME")
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}