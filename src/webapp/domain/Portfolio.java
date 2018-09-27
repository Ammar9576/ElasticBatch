package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Created with IntelliJ IDEA.
 * User: ball
 * Date: 1/21/14
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */

@SuppressWarnings("serial")
@Entity
@Table(schema = "ONAIR", name = "PORTFOLIO_LINKING_PLAN")
public class Portfolio {



    private Long id;

    private Long planId;

    private PortfolioLinking portfolioLinking;


    public Portfolio()
    {
        super();

    }
    
    @Id
    @Column(name = "PORTFOLIO_LINKING_PLAN_ID")
    public Long getId() {
        return this.id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }
    

    @Column(name="PLAN_ID")
    public Long getPlanId()
    {
        return this.planId;
    }

    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

	/**
	 * @return the portfolioLinking
	 */
    @ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "PORTFOLIO_LINKING_ID")
	public PortfolioLinking getPortfolioLinking() {
		return portfolioLinking;
	}

	/**
	 * @param portfolioLinking the portfolioLinking to set
	 */
	public void setPortfolioLinking(PortfolioLinking portfolioLinking) {
		this.portfolioLinking = portfolioLinking;
	}
    
    



}
