package webapp.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The persistent class for the PLAN database table.
 * 
 */
@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class StrippedPlanIndex {

	private String id;
	private String name;
	private Advertiser				advertiser;
	private User					accountExce;
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
	private Brand					brand;
	private OnairDetachedReference	guaranteedCodeObj;
	private Set<Agency>				agencies;
	private Quarters				startQtrId;
	private Quarters				endQtrId;
	private Channel 				linkChannel;//QC 8740
	
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
	
	private SalesTeam				salesTeam;
	
	private Office					office;
	
	private Long portfolioId;
	
	private String portfolioName;
	
	private Timestamp               portfolioModificationDt;
	
	private Timestamp               portfolioCreationDt;
	
	private String               agencyName;
	
	private Set<Agency>				agenciesNew;
	
	//private Long					level = 0L; //DEFAULT
	//private Boolean					subtree = Boolean.FALSE; //DEFAULT
	
	
	
	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}

	

	/**
	 * @return the agencyName
	 */
	public String getAgencyName() {
		return agencyName;
	}



	/**
	 * @param agencyName the agencyName to set
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}



	/**
	 * @return the agenciesNew
	 */
	public Set<Agency> getAgenciesNew() {
		return agenciesNew;
	}



	/**
	 * @param agenciesNew the agenciesNew to set
	 */
	public void setAgenciesNew(Set<Agency> agenciesNew) {
		this.agenciesNew = agenciesNew;
	}



	/**
	 * @return the portfolioId
	 */
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
	 * @return the portfolioModificationDt
	 */
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
	 * @param office the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * @return the salesTeam
	 */
	public SalesTeam getSalesTeam() {
		return salesTeam;
	}

	/**
	 * @param salesTeam the salesTeam to set
	 */
	public void setSalesTeam(SalesTeam salesTeam) {
		this.salesTeam = salesTeam;
	}

	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	/**
	 * @return the dealYear
	 */
	public DealYear getDealYear() {
		return dealYear;
	}

	/**
	 * @param dealYear the dealYear to set
	 */
	public void setDealYear(DealYear dealYear) {
		this.dealYear = dealYear;
	}

	/**
	 * @return the hhPostBuy
	 */
	public PostingMethodology getHhPostBuy() {
		return hhPostBuy;
	}

	/**
	 * @param hhPostBuy the hhPostBuy to set
	 */
	public void setHhPostBuy(PostingMethodology hhPostBuy) {
		this.hhPostBuy = hhPostBuy;
	}

	/**
	 * @return the demoPostBuy
	 */
	public PostingMethodology getDemoPostBuy() {
		return demoPostBuy;
	}

	/**
	 * @param demoPostBuy the demoPostBuy to set
	 */
	public void setDemoPostBuy(PostingMethodology demoPostBuy) {
		this.demoPostBuy = demoPostBuy;
	}

	/**
	 * @return the marketPlace
	 */
	public MarketPlace getMarketPlace() {
		return marketPlace;
	}

	/**
	 * @param marketPlace the marketPlace to set
	 */
	public void setMarketPlace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}

	/**
	 * @return the planApprovalStatus
	 */
	public PlanApprovalStatus getPlanApprovalStatus() {
		return planApprovalStatus;
	}

	/**
	 * @param planApprovalStatus the planApprovalStatus to set
	 */
	public void setPlanApprovalStatus(PlanApprovalStatus planApprovalStatus) {
		this.planApprovalStatus = planApprovalStatus;
	}

	/**
	 * @return the planClass
	 */
	public PlanClass getPlanClass() {
		return planClass;
	}

	/**
	 * @param planClass the planClass to set
	 */
	public void setPlanClass(PlanClass planClass) {
		this.planClass = planClass;
	}

	/**
	 * @return the planStatus
	 */
	public PlanStatus getPlanStatus() {
		return planStatus;
	}

	/**
	 * @param planStatus the planStatus to set
	 */
	public void setPlanStatus(PlanStatus planStatus) {
		this.planStatus = planStatus;
	}

	/**
	 * @return the ratingStream
	 */
	public RatingStream getRatingStream() {
		return ratingStream;
	}

	/**
	 * @param ratingStream the ratingStream to set
	 */
	public void setRatingStream(RatingStream ratingStream) {
		this.ratingStream = ratingStream;
	}

	/**
	 * @return the targetGroup
	 */
	public TargetGroup getTargetGroup() {
		return targetGroup;
	}

	/**
	 * @param targetGroup the targetGroup to set
	 */
	public void setTargetGroup(TargetGroup targetGroup) {
		this.targetGroup = targetGroup;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the guaranteedCodeObj
	 */
	public OnairDetachedReference getGuaranteedCodeObj() {
		return guaranteedCodeObj;
	}

	/**
	 * @param guaranteedCodeObj the guaranteedCodeObj to set
	 */
	public void setGuaranteedCodeObj(OnairDetachedReference guaranteedCodeObj) {
		this.guaranteedCodeObj = guaranteedCodeObj;
	}

	/**
	 * @return the agencies
	 */
	public Set<Agency> getAgencies() {
		return agencies;
	}

	/**
	 * @param agencies the agencies to set
	 */
	public void setAgencies(Set<Agency> agencies) {
		this.agencies = agencies;
	}

	/**
	 * @return the startQtrId
	 */
	public Quarters getStartQtrId() {
		return startQtrId;
	}

	/**
	 * @param startQtrId the startQtrId to set
	 */
	public void setStartQtrId(Quarters startQtrId) {
		this.startQtrId = startQtrId;
	}

	/**
	 * @return the endQtrId
	 */
	public Quarters getEndQtrId() {
		return endQtrId;
	}

	/**
	 * @param endQtrId the endQtrId to set
	 */
	public void setEndQtrId(Quarters endQtrId) {
		this.endQtrId = endQtrId;
	}

	/**
	 * @return the linkChannel
	 */
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
	 * @return the division
	 */
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
	public SubDivision getSubDivision() {
		return subDivision;
	}

	/**
	 * @param subDivision the subDivision to set
	 */
	public void setSubDivision(SubDivision subDivision) {
		this.subDivision = subDivision;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the modificationDate
	 */
	public Timestamp getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * @return the creationDate
	 */
	public Timestamp getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the planLinkID
	 */
	public Long getPlanLinkID() {
		return planLinkID;
	}

	/**
	 * @param planLinkID the planLinkID to set
	 */
	public void setPlanLinkID(Long planLinkID) {
		this.planLinkID = planLinkID;
	}

	/**
	 * @return the planLinkName
	 */
	public String getPlanLinkName() {
		return planLinkName;
	}

	/**
	 * @param planLinkName the planLinkName to set
	 */
	public void setPlanLinkName(String planLinkName) {
		this.planLinkName = planLinkName;
	}

	/**
	 * @return the planVersionNumber
	 */
	public String getPlanVersionNumber() {
		return planVersionNumber;
	}

	/**
	 * @param planVersionNumber the planVersionNumber to set
	 */
	public void setPlanVersionNumber(String planVersionNumber) {
		this.planVersionNumber = planVersionNumber;
	}

	/**
	 * @return the planSubStatus
	 */
	public String getPlanSubStatus() {
		return planSubStatus;
	}

	/**
	 * @param planSubStatus the planSubStatus to set
	 */
	public void setPlanSubStatus(String planSubStatus) {
		this.planSubStatus = planSubStatus;
	}

	/**
	 * @return the originalPlanId
	 */
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
	 * @return the calendarId
	 */
	public Long getCalendarId() {
		return calendarId;
	}

	/**
	 * @param calendarId the calendarId to set
	 */
	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}

	/**
	 * @return the advertiser
	 */
	public Advertiser getAdvertiser() {
		return advertiser;
	}

	/**
	 * @param advertiser the advertiser to set
	 */
	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

	/**
	 * @return the accountExce
	 */
	public User getAccountExce() {
		return accountExce;
	}

	/**
	 * @param accountExce the accountExce to set
	 */
	public void setAccountExce(User accountExce) {
		this.accountExce = accountExce;
	}

	public StrippedPlanIndex() {
	}
	
	@Id
    public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	 

}