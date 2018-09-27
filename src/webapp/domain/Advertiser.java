package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the ADVERTISER database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ADVERTISER_EVW", schema = "nbc_cust")
public class Advertiser {

	private Long id;
	private String name;
	
	private String sfName;
	
	

	/**
	 * @return the sfName
	 */
	@Column(name = "SF_ADVERTISER_ID")
	public String getSfName() {
		return sfName;
	}

	/**
	 * @param sfName the sfName to set
	 */
	public void setSfName(String sfName) {
		this.sfName = sfName;
	}

	public Advertiser() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADVERTISER_ID", unique = true, nullable = false, precision = 9)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	@Column(name = "ADVERTISER_NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}