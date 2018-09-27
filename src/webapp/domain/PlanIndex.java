package webapp.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class PlanIndex {
	private Long planId;
	private String planName;
	private Long planStatusCode;
	private String planStatus;
	private String planSubStatus;
	@Id
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
	public String getPlanSubStatus() {
		return planSubStatus;
	}
	public void setPlanSubStatus(String planSubStatus) {
		this.planSubStatus = planSubStatus;
	}
	
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	
	public Long getPlanStatusCode() {
		return planStatusCode;
	}
	public void setPlanStatusCode(Long planStatusCode) {
		this.planStatusCode = planStatusCode;
	}
	
	
	
}