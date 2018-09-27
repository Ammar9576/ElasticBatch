package webapp.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The persistent class for the PLAN database table.
 * 
 */
@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class StrippedPlanIndexV1 {
	
	private String					pfAgencySFId;
	private String					pfAdvertiserSFId;
	private Long					pfAdvertiserId;
	private String					pfAdvertiserName;
	private Long					pfAccountExecutiveId;
	private String					pfAccountExecutiveName;
	private Long					pfAgencyId;
	private String					pfAgencyName;
	private Long					pfRatingStreamId;
	private String					pfRatingStreamName;
	private Long					pfMarketPlaceId;
	private String					pfMarketPlaceName;

	private String 					planId;
	private String 					planName;
	private Long					advertiserId;
	private String					advertiserName;
	private Long					accountExecutiveId;
	private String					accountExecutiveName;
	private Long					channelId;
	private String					channelName;
	private Long					dealYearId;
	private String					dealYearName;
	private Long					marketPlaceId;
	private String					marketPlaceName;
	private Long					planApprovalStatusId;
	private String					planApprovalStatusName;
	private Long					planClassId;
	private String					planClassName;
	private Long					planStatusId;
	private String					planStatusName;
	private Long					ratingStreamId;
	private String					ratingStreamName;
	private Long					targetGroupId;
	private String					targetGroupName;
	private Long					brandId;
	private String					brandName;
	private Long					agencyId;
	private String					agencyName;
	private Long 					startQuarterId;
	private String 					startQuarterName;
	private Long					startOrderNo;
	private Long					startCurrQrtOrderNo;
	private Long					startQuarterValue;
	private Date					startCalanderEndDate;
	private Date					startCalanderStartDate;
	private Long 					endQuarterId;
	private String 					endQuarterName;
	private Long					endOrderNo;
	private Long					endCurrQrtOrderNo;
	private Long					endQuarterValue;
	private Date					endCalanderEndDate;
	private Date					endCalanderStartDate;
	private Long 					linkChannelId;//QC 8740
	private String 					linkChannelName;
	private Long				    divisionId;
	private String				    divisionName;	
	private Long				    subDivisionId;
	private String				    subDivisionName;
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
	private Long					officeId;
	private String					officeName;
	private Long 					portfolioId;
	private String 					portfolioName;
	private Timestamp               portfolioModificationDt;
	private Timestamp               portfolioCreationDt;
	
	private String					advertiserSFId;
	private String					agencySFId;
	
	private Long					pfTargetGroupId;
	private String					pfTargetGroupName;
	
	
	
	/**
	 * @return the pfMarketPlaceId
	 */
	public Long getPfMarketPlaceId() {
		return pfMarketPlaceId;
	}
	/**
	 * @param pfMarketPlaceId the pfMarketPlaceId to set
	 */
	public void setPfMarketPlaceId(Long pfMarketPlaceId) {
		this.pfMarketPlaceId = pfMarketPlaceId;
	}
	/**
	 * @return the pfMarketPlaceName
	 */
	public String getPfMarketPlaceName() {
		return pfMarketPlaceName;
	}
	/**
	 * @param pfMarketPlaceName the pfMarketPlaceName to set
	 */
	public void setPfMarketPlaceName(String pfMarketPlaceName) {
		this.pfMarketPlaceName = pfMarketPlaceName;
	}
	/**
	 * @return the planId
	 */
	public String getPlanId() {
		return planId;
	}
	/**
	 * @param planId the planId to set
	 */
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	/**
	 * @return the planName
	 */
	public String getPlanName() {
		return planName;
	}
	/**
	 * @param planName the planName to set
	 */
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	/**
	 * @return the advertiserSFId
	 */
	public String getAdvertiserSFId() {
		return advertiserSFId;
	}
	/**
	 * @param advertiserSFId the advertiserSFId to set
	 */
	public void setAdvertiserSFId(String advertiserSFId) {
		this.advertiserSFId = advertiserSFId;
	}
	/**
	 * @return the agencySFId
	 */
	public String getAgencySFId() {
		return agencySFId;
	}
	/**
	 * @param agencySFId the agencySFId to set
	 */
	public void setAgencySFId(String agencySFId) {
		this.agencySFId = agencySFId;
	}
	/**
	 * @return the pfTargetGroupId
	 */
	public Long getPfTargetGroupId() {
		return pfTargetGroupId;
	}
	/**
	 * @param pfTargetGroupId the pfTargetGroupId to set
	 */
	public void setPfTargetGroupId(Long pfTargetGroupId) {
		this.pfTargetGroupId = pfTargetGroupId;
	}
	/**
	 * @return the pfTargetGroupName
	 */
	public String getPfTargetGroupName() {
		return pfTargetGroupName;
	}
	/**
	 * @param pfTargetGroupName the pfTargetGroupName to set
	 */
	public void setPfTargetGroupName(String pfTargetGroupName) {
		this.pfTargetGroupName = pfTargetGroupName;
	}
	/**
	 * @return the advertiserId
	 */
	public Long getAdvertiserId() {
		return advertiserId;
	}
	/**
	 * @param advertiserId the advertiserId to set
	 */
	public void setAdvertiserId(Long advertiserId) {
		this.advertiserId = advertiserId;
	}
	/**
	 * @return the advertiserName
	 */
	public String getAdvertiserName() {
		return advertiserName;
	}
	/**
	 * @param advertiserName the advertiserName to set
	 */
	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}
	
	
	/**
	 * @return the accountExecutiveId
	 */
	public Long getAccountExecutiveId() {
		return accountExecutiveId;
	}
	/**
	 * @param accountExecutiveId the accountExecutiveId to set
	 */
	public void setAccountExecutiveId(Long accountExecutiveId) {
		this.accountExecutiveId = accountExecutiveId;
	}
	/**
	 * @return the accountExecutiveName
	 */
	public String getAccountExecutiveName() {
		return accountExecutiveName;
	}
	/**
	 * @param accountExecutiveName the accountExecutiveName to set
	 */
	public void setAccountExecutiveName(String accountExecutiveName) {
		this.accountExecutiveName = accountExecutiveName;
	}
	/**
	 * @return the channelId
	 */
	public Long getChannelId() {
		return channelId;
	}
	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * @param channelName the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * @return the dealYearId
	 */
	public Long getDealYearId() {
		return dealYearId;
	}
	/**
	 * @param dealYearId the dealYearId to set
	 */
	public void setDealYearId(Long dealYearId) {
		this.dealYearId = dealYearId;
	}
	/**
	 * @return the dealYearName
	 */
	public String getDealYearName() {
		return dealYearName;
	}
	/**
	 * @param dealYearName the dealYearName to set
	 */
	public void setDealYearName(String dealYearName) {
		this.dealYearName = dealYearName;
	}
	/**
	 * @return the marketPlaceId
	 */
	public Long getMarketPlaceId() {
		return marketPlaceId;
	}
	/**
	 * @param marketPlaceId the marketPlaceId to set
	 */
	public void setMarketPlaceId(Long marketPlaceId) {
		this.marketPlaceId = marketPlaceId;
	}
	/**
	 * @return the marketPlaceName
	 */
	public String getMarketPlaceName() {
		return marketPlaceName;
	}
	/**
	 * @param marketPlaceName the marketPlaceName to set
	 */
	public void setMarketPlaceName(String marketPlaceName) {
		this.marketPlaceName = marketPlaceName;
	}
	/**
	 * @return the planApprovalStatusId
	 */
	public Long getPlanApprovalStatusId() {
		return planApprovalStatusId;
	}
	/**
	 * @param planApprovalStatusId the planApprovalStatusId to set
	 */
	public void setPlanApprovalStatusId(Long planApprovalStatusId) {
		this.planApprovalStatusId = planApprovalStatusId;
	}
	/**
	 * @return the planApprovalStatusName
	 */
	public String getPlanApprovalStatusName() {
		return planApprovalStatusName;
	}
	/**
	 * @param planApprovalStatusName the planApprovalStatusName to set
	 */
	public void setPlanApprovalStatusName(String planApprovalStatusName) {
		this.planApprovalStatusName = planApprovalStatusName;
	}
	/**
	 * @return the planClassId
	 */
	public Long getPlanClassId() {
		return planClassId;
	}
	/**
	 * @param planClassId the planClassId to set
	 */
	public void setPlanClassId(Long planClassId) {
		this.planClassId = planClassId;
	}
	/**
	 * @return the planClassName
	 */
	public String getPlanClassName() {
		return planClassName;
	}
	/**
	 * @param planClassName the planClassName to set
	 */
	public void setPlanClassName(String planClassName) {
		this.planClassName = planClassName;
	}
	/**
	 * @return the planStatusId
	 */
	public Long getPlanStatusId() {
		return planStatusId;
	}
	/**
	 * @param planStatusId the planStatusId to set
	 */
	public void setPlanStatusId(Long planStatusId) {
		this.planStatusId = planStatusId;
	}
	/**
	 * @return the planStatusName
	 */
	public String getPlanStatusName() {
		return planStatusName;
	}
	/**
	 * @param planStatusName the planStatusName to set
	 */
	public void setPlanStatusName(String planStatusName) {
		this.planStatusName = planStatusName;
	}
	/**
	 * @return the ratingStreamId
	 */
	public Long getRatingStreamId() {
		return ratingStreamId;
	}
	/**
	 * @param ratingStreamId the ratingStreamId to set
	 */
	public void setRatingStreamId(Long ratingStreamId) {
		this.ratingStreamId = ratingStreamId;
	}
	/**
	 * @return the ratingStreamName
	 */
	public String getRatingStreamName() {
		return ratingStreamName;
	}
	/**
	 * @param ratingStreamName the ratingStreamName to set
	 */
	public void setRatingStreamName(String ratingStreamName) {
		this.ratingStreamName = ratingStreamName;
	}
	/**
	 * @return the targetGroupId
	 */
	public Long getTargetGroupId() {
		return targetGroupId;
	}
	/**
	 * @param targetGroupId the targetGroupId to set
	 */
	public void setTargetGroupId(Long targetGroupId) {
		this.targetGroupId = targetGroupId;
	}
	/**
	 * @return the targetGroupName
	 */
	public String getTargetGroupName() {
		return targetGroupName;
	}
	/**
	 * @param targetGroupName the targetGroupName to set
	 */
	public void setTargetGroupName(String targetGroupName) {
		this.targetGroupName = targetGroupName;
	}
	/**
	 * @return the brandId
	 */
	public Long getBrandId() {
		return brandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * @return the agencyId
	 */
	public Long getAgencyId() {
		return agencyId;
	}
	/**
	 * @param agencyId the agencyId to set
	 */
	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
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
	 * @return the startOrderNo
	 */
	public Long getStartOrderNo() {
		return startOrderNo;
	}
	/**
	 * @param startOrderNo the startOrderNo to set
	 */
	public void setStartOrderNo(Long startOrderNo) {
		this.startOrderNo = startOrderNo;
	}
	/**
	 * @return the startCurrQrtOrderNo
	 */
	public Long getStartCurrQrtOrderNo() {
		return startCurrQrtOrderNo;
	}
	/**
	 * @param startCurrQrtOrderNo the startCurrQrtOrderNo to set
	 */
	public void setStartCurrQrtOrderNo(Long startCurrQrtOrderNo) {
		this.startCurrQrtOrderNo = startCurrQrtOrderNo;
	}
	/**
	 * @return the startQuarterValue
	 */
	public Long getStartQuarterValue() {
		return startQuarterValue;
	}
	/**
	 * @param startQuarterValue the startQuarterValue to set
	 */
	public void setStartQuarterValue(Long startQuarterValue) {
		this.startQuarterValue = startQuarterValue;
	}
	/**
	 * @return the startCalanderEndDate
	 */
	public Date getStartCalanderEndDate() {
		return startCalanderEndDate;
	}
	/**
	 * @param startCalanderEndDate the startCalanderEndDate to set
	 */
	public void setStartCalanderEndDate(Date startCalanderEndDate) {
		this.startCalanderEndDate = startCalanderEndDate;
	}
	/**
	 * @return the startCalanderStartDate
	 */
	public Date getStartCalanderStartDate() {
		return startCalanderStartDate;
	}
	/**
	 * @param startCalanderStartDate the startCalanderStartDate to set
	 */
	public void setStartCalanderStartDate(Date startCalanderStartDate) {
		this.startCalanderStartDate = startCalanderStartDate;
	}
	/**
	 * @return the endOrderNo
	 */
	public Long getEndOrderNo() {
		return endOrderNo;
	}
	/**
	 * @param endOrderNo the endOrderNo to set
	 */
	public void setEndOrderNo(Long endOrderNo) {
		this.endOrderNo = endOrderNo;
	}
	/**
	 * @return the endCurrQrtOrderNo
	 */
	public Long getEndCurrQrtOrderNo() {
		return endCurrQrtOrderNo;
	}
	/**
	 * @param endCurrQrtOrderNo the endCurrQrtOrderNo to set
	 */
	public void setEndCurrQrtOrderNo(Long endCurrQrtOrderNo) {
		this.endCurrQrtOrderNo = endCurrQrtOrderNo;
	}
	/**
	 * @return the endQuarterValue
	 */
	public Long getEndQuarterValue() {
		return endQuarterValue;
	}
	/**
	 * @param endQuarterValue the endQuarterValue to set
	 */
	public void setEndQuarterValue(Long endQuarterValue) {
		this.endQuarterValue = endQuarterValue;
	}
	/**
	 * @return the endCalanderEndDate
	 */
	public Date getEndCalanderEndDate() {
		return endCalanderEndDate;
	}
	/**
	 * @param endCalanderEndDate the endCalanderEndDate to set
	 */
	public void setEndCalanderEndDate(Date endCalanderEndDate) {
		this.endCalanderEndDate = endCalanderEndDate;
	}
	/**
	 * @return the endCalanderStartDate
	 */
	public Date getEndCalanderStartDate() {
		return endCalanderStartDate;
	}
	/**
	 * @param endCalanderStartDate the endCalanderStartDate to set
	 */
	public void setEndCalanderStartDate(Date endCalanderStartDate) {
		this.endCalanderStartDate = endCalanderStartDate;
	}
	/**
	 * @return the linkChannelId
	 */
	public Long getLinkChannelId() {
		return linkChannelId;
	}
	/**
	 * @param linkChannelId the linkChannelId to set
	 */
	public void setLinkChannelId(Long linkChannelId) {
		this.linkChannelId = linkChannelId;
	}
	/**
	 * @return the linkChannelName
	 */
	public String getLinkChannelName() {
		return linkChannelName;
	}
	/**
	 * @param linkChannelName the linkChannelName to set
	 */
	public void setLinkChannelName(String linkChannelName) {
		this.linkChannelName = linkChannelName;
	}
	/**
	 * @return the divisionId
	 */
	public Long getDivisionId() {
		return divisionId;
	}
	/**
	 * @param divisionId the divisionId to set
	 */
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	/**
	 * @return the divisionName
	 */
	public String getDivisionName() {
		return divisionName;
	}
	/**
	 * @param divisionName the divisionName to set
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	/**
	 * @return the subDivisionId
	 */
	public Long getSubDivisionId() {
		return subDivisionId;
	}
	/**
	 * @param subDivisionId the subDivisionId to set
	 */
	public void setSubDivisionId(Long subDivisionId) {
		this.subDivisionId = subDivisionId;
	}
	/**
	 * @return the subDivisionName
	 */
	public String getSubDivisionName() {
		return subDivisionName;
	}
	/**
	 * @param subDivisionName the subDivisionName to set
	 */
	public void setSubDivisionName(String subDivisionName) {
		this.subDivisionName = subDivisionName;
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
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}
	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}
	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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
	 * @return the startQuarterId
	 */
	public Long getStartQuarterId() {
		return startQuarterId;
	}
	/**
	 * @param startQuarterId the startQuarterId to set
	 */
	public void setStartQuarterId(Long startQuarterId) {
		this.startQuarterId = startQuarterId;
	}
	/**
	 * @return the startQuarterName
	 */
	public String getStartQuarterName() {
		return startQuarterName;
	}
	/**
	 * @param startQuarterName the startQuarterName to set
	 */
	public void setStartQuarterName(String startQuarterName) {
		this.startQuarterName = startQuarterName;
	}
	/**
	 * @return the endQuarterId
	 */
	public Long getEndQuarterId() {
		return endQuarterId;
	}
	/**
	 * @param endQuarterId the endQuarterId to set
	 */
	public void setEndQuarterId(Long endQuarterId) {
		this.endQuarterId = endQuarterId;
	}
	/**
	 * @return the endQuarterName
	 */
	public String getEndQuarterName() {
		return endQuarterName;
	}
	/**
	 * @param endQuarterName the endQuarterName to set
	 */
	public void setEndQuarterName(String endQuarterName) {
		this.endQuarterName = endQuarterName;
	}
	/**
	 * @return the pfAgencySFId
	 */
	public String getPfAgencySFId() {
		return pfAgencySFId;
	}
	/**
	 * @param pfAgencySFId the pfAgencySFId to set
	 */
	public void setPfAgencySFId(String pfAgencySFId) {
		this.pfAgencySFId = pfAgencySFId;
	}
	/**
	 * @return the pfAdvertiserSFId
	 */
	public String getPfAdvertiserSFId() {
		return pfAdvertiserSFId;
	}
	/**
	 * @param pfAdvertiserSFId the pfAdvertiserSFId to set
	 */
	public void setPfAdvertiserSFId(String pfAdvertiserSFId) {
		this.pfAdvertiserSFId = pfAdvertiserSFId;
	}
	/**
	 * @return the pfAdvertiserId
	 */
	public Long getPfAdvertiserId() {
		return pfAdvertiserId;
	}
	/**
	 * @param pfAdvertiserId the pfAdvertiserId to set
	 */
	public void setPfAdvertiserId(Long pfAdvertiserId) {
		this.pfAdvertiserId = pfAdvertiserId;
	}
	/**
	 * @return the pfAdvertiserName
	 */
	public String getPfAdvertiserName() {
		return pfAdvertiserName;
	}
	/**
	 * @param pfAdvertiserName the pfAdvertiserName to set
	 */
	public void setPfAdvertiserName(String pfAdvertiserName) {
		this.pfAdvertiserName = pfAdvertiserName;
	}
	/**
	 * @return the pfAccountExecutiveId
	 */
	public Long getPfAccountExecutiveId() {
		return pfAccountExecutiveId;
	}
	/**
	 * @param pfAccountExecutiveId the pfAccountExecutiveId to set
	 */
	public void setPfAccountExecutiveId(Long pfAccountExecutiveId) {
		this.pfAccountExecutiveId = pfAccountExecutiveId;
	}
	/**
	 * @return the pfAccountExecutiveName
	 */
	public String getPfAccountExecutiveName() {
		return pfAccountExecutiveName;
	}
	/**
	 * @param pfAccountExecutiveName the pfAccountExecutiveName to set
	 */
	public void setPfAccountExecutiveName(String pfAccountExecutiveName) {
		this.pfAccountExecutiveName = pfAccountExecutiveName;
	}
	/**
	 * @return the pfAgencyId
	 */
	public Long getPfAgencyId() {
		return pfAgencyId;
	}
	/**
	 * @param pfAgencyId the pfAgencyId to set
	 */
	public void setPfAgencyId(Long pfAgencyId) {
		this.pfAgencyId = pfAgencyId;
	}
	/**
	 * @return the pfAgencyName
	 */
	public String getPfAgencyName() {
		return pfAgencyName;
	}
	/**
	 * @param pfAgencyName the pfAgencyName to set
	 */
	public void setPfAgencyName(String pfAgencyName) {
		this.pfAgencyName = pfAgencyName;
	}
	/**
	 * @return the pfRatingStreamId
	 */
	public Long getPfRatingStreamId() {
		return pfRatingStreamId;
	}
	/**
	 * @param pfRatingStreamId the pfRatingStreamId to set
	 */
	public void setPfRatingStreamId(Long pfRatingStreamId) {
		this.pfRatingStreamId = pfRatingStreamId;
	}
	/**
	 * @return the pfRatingStreamName
	 */
	public String getPfRatingStreamName() {
		return pfRatingStreamName;
	}
	/**
	 * @param pfRatingStreamName the pfRatingStreamName to set
	 */
	public void setPfRatingStreamName(String pfRatingStreamName) {
		this.pfRatingStreamName = pfRatingStreamName;
	}
	
	 

}