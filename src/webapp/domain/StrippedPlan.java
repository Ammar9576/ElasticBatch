package webapp.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The persistent class for the PLAN database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "NBC_CUST", name = "PLAN_ELASTIC_INDEX")  
public class StrippedPlan extends AbstractDomainObject {
	
	private Advertiser				pfAdvertiser;
	private Agency					pfAgency;
	private RatingStream			pfRatingStream;
	private User					pfAccountExce;
	private MarketPlace				pfMarketPlace;
	
	

	/**
	 * @return the pfMarketPlace
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "PF_MARKETPLACE_ID")
	public MarketPlace getPfMarketPlace() {
		return pfMarketPlace;
	}

	/**
	 * @param pfMarketPlace the pfMarketPlace to set
	 */
	public void setPfMarketPlace(MarketPlace pfMarketPlace) {
		this.pfMarketPlace = pfMarketPlace;
	}

	/**
	 * @return the pfAdvertiser
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "PF_ADVERTISER_ID")
	public Advertiser getPfAdvertiser() {
		return pfAdvertiser;
	}

	/**
	 * @param pfAdvertiser the pfAdvertiser to set
	 */
	public void setPfAdvertiser(Advertiser pfAdvertiser) {
		this.pfAdvertiser = pfAdvertiser;
	}

	private Advertiser				advertiser;
	private Channel					channel;
	private DealYear				dealYear;
	private PostingMethodology		hhPostBuy;
	private PostingMethodology		demoPostBuy;
	private MarketPlace				marketPlace;
	private PlanApprovalStatus		planApprovalStatus;
	private PlanClass				planClass;
	private PlanStatus				planStatus;
	private RatingStream			ratingStream;
	private TargetGroup				targetGroup;
	private TargetGroup				pfTargetGroup;
	private Brand					brand;
	private OnairDetachedReference	guaranteedCodeObj;
	private Agency				agency;
	private Quarters				startQtrId;
	private Quarters				endQtrId;
	private Channel 				linkChannel;
	private User					accountExce;
	private Division				division;
	private SubDivision				subDivision;
	private Date					startDate;
	private Date					endDate;
	private Timestamp               modificationDate;
	private Timestamp               creationDate;
	private Long					planLinkID;
	private String					planLinkName;
	private String					planVersionNumber;
	private String					planSubStatus;
	private Long					originalPlanId;
	private Long					versionNo;
	private Long					revisionNo;
	private Long 					calendarId;
	
	private Office					office;
	
	private SalesTeam				salesTeam;
	
	private Long portfolioId;
	
	private String portfolioName;
	
	private Timestamp               portfolioModificationDt;
	
	private Timestamp               portfolioCreationDt;
	
	private Timestamp               origModificationDate;
	
	/*private String					levelSubtree;
	
	//support for plan tree
	private Long					level = 0L; //DEFAULT
	private Boolean					subtree = Boolean.FALSE; //DEFAULT
    */	
	

	

	/**
	 * @return the origModificationDate
	 */
	@Column(name = "OP_MODIFICATION_DT")
	public Timestamp getOrigModificationDate() {
		return origModificationDate;
	}
	
	/**
	 * @return the agency
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "AGENCY_ID")
	public Agency getAgency() {
		return agency;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	/**
	 * @return the portfolioId
	 */
	@Column(name = "PORTFOLIO_ID")
	public Long getPortfolioId() {
		return portfolioId;
	}


	/**
	 * @param portfolioId the portfolioId to set
	 */
	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}


	/**
	 * @return the portfolioName
	 */
	@Column(name = "PORTFOLIO_NAME")
	public String getPortfolioName() {
		return portfolioName;
	}


	/**
	 * @param portfolioName the portfolioName to set
	 */
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}



	/**
	 * @param origModificationDate the origModificationDate to set
	 */
	public void setOrigModificationDate(Timestamp origModificationDate) {
		this.origModificationDate = origModificationDate;
	}



	/**
	 * @return the levelSubtree
	 */
	/*@Column(name = "SUBTREE")
	public String getLevelSubtree() {
		return levelSubtree;
	}*/



	/**
	 * @param levelSubtree the levelSubtree to set
	 */
	/*public void setLevelSubtree(String levelSubtree) {
		this.levelSubtree = levelSubtree;
		if(this.levelSubtree!=null){
			Long level= new Long(this.levelSubtree.split("~")[0]);
			Long subtree= new Long(this.levelSubtree.split("~")[1]);
			if(subtree>0){
				setSubtree(true);
			}else{
				setSubtree(false);
			}
			setLevel(level);
		}
	}*/



	/**
	 * @return the level
	 */
	/*@Transient
	public Long getLevel() {
		return level;
	}*/



	/**
	 * @param level the level to set
	 */
	/*public void setLevel(Long level) {
		this.level = level;
	}*/



	/**
	 * @return the subtree
	 */
	/*@Transient
	public Boolean getSubtree() {
		return subtree;
	}*/



	/**
	 * @param subtree the subtree to set
	 */
	/*public void setSubtree(Boolean subtree) {
		this.subtree = subtree;
	}*/
	
	
	
	/**
	 * @return the portfolioModificationDt
	 */
	@Column(name = "PORTFOLIO_MODIFICATION_DT")
	public Timestamp getPortfolioModificationDt() {
		return portfolioModificationDt;
	}

	

	/**
	 * @param portfolioModificationDt the portfolioModificationDt to set
	 */
	public void setPortfolioModificationDt(Timestamp portfolioModificationDt) {
		this.portfolioModificationDt = portfolioModificationDt;
	}

	/**
	 * @return the portfolioCreationDt
	 */
	@Column(name = "PORTFOLIO_CREATION_DT")
	public Timestamp getPortfolioCreationDt() {
		return portfolioCreationDt;
	}

	/**
	 * @param portfolioCreationDt the portfolioCreationDt to set
	 */
	public void setPortfolioCreationDt(Timestamp portfolioCreationDt) {
		this.portfolioCreationDt = portfolioCreationDt;
	}

	/**
	 * @param office
	 *            the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "SALES_TEAM_ID")
	public SalesTeam getSalesTeam() {
		return this.salesTeam;
	}

	public void setSalesTeam(SalesTeam salesTeam) {
		this.salesTeam = salesTeam;
	}

	/**
	 * @return the office
	 */
	@Transient
	public Office getOffice() {
		Office office = null;
		if (salesTeam != null)
			office = salesTeam.getOffice();
		return office;
	}
	
	public StrippedPlan() {
	}
	
	/**
	 * @return the linkChannel
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "LINK_CHANNEL_ID")
	public Channel getLinkChannel() {
		return linkChannel;
	}




	/**
	 * @param linkChannel the linkChannel to set
	 */
	public void setLinkChannel(Channel linkChannel) {
		this.linkChannel = linkChannel;
	}

	/**
	 * @return the planLinkID
	 */
	@Column(name = "stewardship_plan_link_id")
	public Long getPlanLinkID() {
		return planLinkID;
	}

	/**
	 * @param planLinkID
	 *            the planLinkID to set
	 */
	public void setPlanLinkID(Long planLinkID) {
		this.planLinkID = planLinkID;
	}

	/**
	 * @return the planLinkName
	 */
	@Column(name = "stewardship_plan_link_name")
	public String getPlanLinkName() {
		return planLinkName;
	}

	/**
	 * @param planLinkName
	 *            the planLinkName to set
	 */
	public void setPlanLinkName(String planLinkName) {
		this.planLinkName = planLinkName;
	}

	/**
	 * @return the accountExce
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "account_exec_id")
	public User getAccountExce() {
		return accountExce;
	}

	
	/**
	 * @param accountExce
	 *            the accountExce to set
	 */
	public void setAccountExce(User accountExce) {
		this.accountExce = accountExce;
	}

	
	/**
	 * @return the planVersionNumber
	 */
    @Column(name = "plan_version_number")
	public String getPlanVersionNumber() {
		return planVersionNumber;
	}

	/**
	 * @param planVersionNumber
	 *            the planVersionNumber to set
	 */
	public void setPlanVersionNumber(String planVersionNumber) {
		this.planVersionNumber = planVersionNumber;
	}

	/**
	 * @return the planHistoryAE
	 */
	

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "ADVERTISER_ID")
	public Advertiser getAdvertiser() {
		return this.advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "CHANNEL_ID")
	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "DEAL_YEAR_ID")
	public DealYear getDealYear() {
		return this.dealYear;
	}

	public void setDealYear(DealYear dealYear) {
		this.dealYear = dealYear;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "DEMO_POST_BUY_ID")
	public PostingMethodology getDemoPostBuy() {
		return this.demoPostBuy;
	}

	public void setDemoPostBuy(PostingMethodology demoPostBuy) {
		this.demoPostBuy = demoPostBuy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "GUARANTEED_CODE")
	public OnairDetachedReference getGuaranteedCodeObj() {
		return this.guaranteedCodeObj;
	}

	public void setGuaranteedCodeObj(OnairDetachedReference guaranteedCodeObj) {
		this.guaranteedCodeObj = guaranteedCodeObj;
	}

	/*
	 * public String getGuaranteedCode() { return this.guaranteedCode; }
	 * 
	 * public void setGuaranteedCode(String guaranteedCode) {
	 * this.guaranteedCode = guaranteedCode; }
	 */

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "HH_POST_BUY_ID")
	public PostingMethodology getHhPostBuy() {
		return this.hhPostBuy;
	}

	public void setHhPostBuy(PostingMethodology hhPostBuy) {
		this.hhPostBuy = hhPostBuy;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "MARKETPLACE_CODE")
	public MarketPlace getMarketPlace() {
		return this.marketPlace;
	}

	public void setMarketPlace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}
	
	

	/**
	 * @return the division
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "CHANNEL_DIVISION_ID")
	public Division getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(Division division) {
		this.division = division;
	}

	/**
	 * @return the subDivision
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "SUB_DIVISION_ID")
	public SubDivision getSubDivision() {
		return subDivision;
	}

	/**
	 * @param subDivision the subDivision to set
	 */
	public void setSubDivision(SubDivision subDivision) {
		this.subDivision = subDivision;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "PLAN_APPROVAL_STATUS_CODE")
	public PlanApprovalStatus getPlanApprovalStatus() {
		return this.planApprovalStatus;
	}

	public void setPlanApprovalStatus(PlanApprovalStatus planApprovalStatus) {
		this.planApprovalStatus = planApprovalStatus;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "PLAN_CLASS_CODE")
	public PlanClass getPlanClass() {
		return this.planClass;
	}

	public void setPlanClass(PlanClass planClass) {
		this.planClass = planClass;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "PLAN_STATUS_CODE")
	public PlanStatus getPlanStatus() {
		return this.planStatus;
	}

	public void setPlanStatus(PlanStatus planStatus) {
		this.planStatus = planStatus;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "RATING_STREAM_CODE")
	public RatingStream getRatingStream() {
		return this.ratingStream;
	}

	public void setRatingStream(RatingStream ratingStream) {
		this.ratingStream = ratingStream;
	}

	

	/**
	 * @return the pfTargetGroup
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "PF_TARGET_GROUP_ID")
	public TargetGroup getPfTargetGroup() {
		return pfTargetGroup;
	}

	/**
	 * @param pfTargetGroup the pfTargetGroup to set
	 */
	public void setPfTargetGroup(TargetGroup pfTargetGroup) {
		this.pfTargetGroup = pfTargetGroup;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "TARGET_GROUP_ID")
	public TargetGroup getTargetGroup() {
		return this.targetGroup;
	}

	public void setTargetGroup(TargetGroup targetGroup) {
		this.targetGroup = targetGroup;
	}

	
	@Override
	@Id
    @Column(name = "PLAN_ID")
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "PLAN_NAME")
    public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	

	/**
	 * @param brand
	 *            the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the brand
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "BRAND_ID")
	public Brand getBrand() {
		return brand;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "MODIFICATION_DT")
    public Timestamp getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }


    @Column(name = "CREATION_DT")
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

	/**
	 * @return the originalPlanId
	 */
	@Column(name="original_plan_id")
	public Long getOriginalPlanId() {
		return originalPlanId;
	}

	/**
	 * @param originalPlanId the originalPlanId to set
	 */
	public void setOriginalPlanId(Long originalPlanId) {
		this.originalPlanId = originalPlanId;
	}

	

	/**
	 * @return the versionNo
	 */
	@Column(name="VER_NO")
	public Long getVersionNo() {
		return versionNo;
	}

	/**
	 * @param versionNo the versionNo to set
	 */
	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * @return the revisionNo
	 */
	@Column(name="REV_NO")
	public Long getRevisionNo() {
		return revisionNo;
	}

	/**
	 * @param revisionNo the revisionNo to set
	 */
	public void setRevisionNo(Long revisionNo) {
		this.revisionNo = revisionNo;
	}

	/**
	 * @return the planSubStatus
	 */
	//@Column(name="PLAN_SUB_STATUS_ID")
	@Column(name = "PLAN_SUB_STATUS_ID")
    public String getPlanSubStatus() {
		return planSubStatus;
	}

	/**
	 * @param planSubStatus the planSubStatus to set
	 */
	public void setPlanSubStatus(String planSubStatus) {
		this.planSubStatus = planSubStatus;
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "START_QTR_ID")
	public Quarters getStartQtrId() {
		return this.startQtrId;
	}

	public void setStartQtrId(Quarters startQtrId) {
		this.startQtrId = startQtrId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "END_QTR_ID")
	public Quarters getEndQtrId() {
		return this.endQtrId;
	}

	public void setEndQtrId(Quarters endQtrId) {
		this.endQtrId = endQtrId;
	}
	
	@Column(name = "CALENDAR_ID")
    public Long getCalendarId() {
        return this.calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }
    
    

	/**
	 * @return the pfAgency
	 */
    @ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "PFAGENCYID")
	public Agency getPfAgency() {
		return pfAgency;
	}

	/**
	 * @param pfAgency the pfAgency to set
	 */
	public void setPfAgency(Agency pfAgency) {
		this.pfAgency = pfAgency;
	}

	/**
	 * @return the pfRatingStream
	 */
	
	 @ManyToOne(fetch = FetchType.EAGER)
		@Fetch(FetchMode.SELECT)
		@JoinColumn(name = "PFRATINGSTREAMID")
	public RatingStream getPfRatingStream() {
		return pfRatingStream;
	}

	/**
	 * @param pfRatingStream the pfRatingStream to set
	 */
	public void setPfRatingStream(RatingStream pfRatingStream) {
		this.pfRatingStream = pfRatingStream;
	}

	/**
	 * @return the pfAccountExce
	 */

	 @ManyToOne(fetch = FetchType.EAGER)
		@Fetch(FetchMode.SELECT)
		@JoinColumn(name = "PFACCOUNTEXECUTIVEID")
	public User getPfAccountExce() {
		return pfAccountExce;
	}

	/**
	 * @param pfAccountExce the pfAccountExce to set
	 */
	public void setPfAccountExce(User pfAccountExce) {
		this.pfAccountExce = pfAccountExce;
	}

}