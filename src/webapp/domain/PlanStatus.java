package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the PLAN_STATUS_RPT_VW database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "nbc_cust", name = "PLAN_STATUS_CIR_VW")
public class PlanStatus extends AbstractDomainObject {

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
	@Column(name = "PLAN_STATUS")
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	

}