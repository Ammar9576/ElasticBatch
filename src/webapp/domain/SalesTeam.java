package webapp.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The persistent class for the SALES_TEAM database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "SALES_TEAM")
public class SalesTeam extends AbstractDomainObject implements Serializable {


	private Office						office;
	
	//@Field(type = FieldType.Nested)
	private  Set<Channel>		channels;
	//@Field(type = FieldType.Nested)
	private  Set<PlanClass>	planClasses;

	
	public SalesTeam() {
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.AbstractDomainObject#getId()
	 */
	@Override
	@Id
	@Column(name = "SALES_TEAM_ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.AbstractDomainObject#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.AbstractDomainObject#getName()
	 */
	@Override
	@Column(name = "SALES_TEAM_NAME")
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.AbstractDomainObject#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	/**
	 * @param office
	 *            the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * @return the office
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCATION_CODE", insertable = false, updatable = false, nullable = false)
	public Office getOffice() {
		return office;
	}

	/**
	 * @param channels
	 *            the channels to set
	 */
	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}

	/**
	 * @return the channels
	 */
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(schema = "onair", name = "SALES_TEAM_CHANNELS", joinColumns = { @JoinColumn(name = "SALES_TEAM_ID") }, inverseJoinColumns = { @JoinColumn(name = "CHANNEL_ID") })
	public Set<Channel> getChannels() {
		return channels;
	}

	/**
	 * @param planClasses
	 *            the planClasses to set
	 */
	public void setPlanClasses(Set<PlanClass> planClasses) {
		this.planClasses = planClasses;
	}

	/**
	 * @return the planClasses
	 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(schema = "onair", name = "sales_team_deal_class",
			joinColumns = { @JoinColumn(name = "SALES_TEAM_ID") },
			inverseJoinColumns = { @JoinColumn(name = "DEAL_CLASS_CODE") })
	public Set<PlanClass> getPlanClasses() {
		return planClasses;
	}

	/**
	 * @param salesTeamMembers
	 *            the salesTeamMembers to set
	 */
	/*
	 * public void setSalesTeamMembers(Set<SalesTeamMember> salesTeamMembers) {
	 * this.salesTeamMembers = salesTeamMembers; }
	 */

	
}