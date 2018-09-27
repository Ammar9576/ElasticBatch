package webapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

/**
 * The persistent class for the CALENDAR_PER_QUARTERS_VW database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "calendar_period")
public class Quarters extends AbstractDomainObject {

	private Long	orderNo;
	private Long	currQrtOrderNo;
	
	private Long	quarterValue;
	
	private Date	calanderEndDate;
	private Date	calanderStartDate;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	public Date getCalanderEndDate() {
		return this.calanderEndDate;
	}

	public void setCalanderEndDate(Date calanderEndDate) {
		this.calanderEndDate = calanderEndDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	public Date getCalanderStartDate() {
		return this.calanderStartDate;
	}

	public void setCalanderStartDate(Date calanderStartDate) {
		this.calanderStartDate = calanderStartDate;
	}

	
	private Long calendarId;
	

	/**
	 * @return the quarterValue
	 */
	@Transient
	public Long getQuarterValue() {
		return quarterValue;
	}

	/**
	 * @param quarterValue the quarterValue to set
	 */
	public void setQuarterValue(Long quarterValue) {
		this.quarterValue = quarterValue;
	}

	/**
	 * @return the currQrtOrderNo
	 */
	@Formula("(select period.order_No from onair.calendar_period period where period.start_date <= TO_DATE(SYSDATE,'DD-MON-YY')  and period.end_date >= TO_DATE(SYSDATE,'DD-MON-YY')  and period.order_No!=-1 and period.calendar_id=-2)")
	public Long getCurrQrtOrderNo() {
		return currQrtOrderNo;
	}
 
	/**
	 * @param currQrtOrderNo the currQrtOrderNo to set
	 */
	public void setCurrQrtOrderNo(Long currQrtOrderNo) {
		this.currQrtOrderNo = currQrtOrderNo;
	}

	public Quarters() {
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.AbstractDomainObject#getId()
	 */
	@Override
	@Id
	@Column(name = "CALENDAR_PERIOD_ID")
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

	@Column(name = "ORDER_NO")
	public Long getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

    @Column(name = "CALENDAR_ID")
    public Long getCalendarId() {
        return this.calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

}