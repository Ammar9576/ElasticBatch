package webapp.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "ONAIR", name = "PLAN")  
public class Plan {
	
	private String planId;
	private String planStatusCode;
	private Timestamp   modificationDate;
	
	@Id
	@Column(name = "PLAN_ID")
	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	@Column(name = "PLAN_STATUS_CODE")
	public String getPlanStatusCode() {
		return planStatusCode;
	}

	public void setPlanStatusCode(String planStatusCode) {
		this.planStatusCode = planStatusCode;
	}

	/**
	 * @return the modificationDate
	 */
	@Column(name = "MODIFICATION_DT")
	public Timestamp getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
	

}
