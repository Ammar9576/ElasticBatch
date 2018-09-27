package webapp.job;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import webapp.domain.StrippedPlan;
import webapp.domain.StrippedPlanIndexV1;

/**
 * 
 */
public class PlanIndexProcessor implements ItemProcessor<StrippedPlan, StrippedPlanIndexV1> {

    private Logger logger = getLogger(getClass());

    @Override
    public StrippedPlanIndexV1 process(StrippedPlan plan) throws Exception {

    	try{
    	StrippedPlanIndexV1 strippedPlanIndexV1 =new StrippedPlanIndexV1();
    	
    	strippedPlanIndexV1.setPlanId(plan.getId().toString());
    	strippedPlanIndexV1.setPlanName(plan.getName());
    	strippedPlanIndexV1.setAccountExecutiveId(plan.getAccountExce().getId());
    	
    	String accName=plan.getAccountExce().getName().replaceAll("(\\()(\\d+)(\\))", " ").trim();
    	String[] accNameArr=accName.split(",");
    	if(accNameArr.length==2){
    	strippedPlanIndexV1.setAccountExecutiveName(accNameArr[1]+" "+accNameArr[0]);
    	}else{
    		strippedPlanIndexV1.setAccountExecutiveName(accName);
    	}
    	
    	if(plan.getPortfolioId()!=null){
	    	strippedPlanIndexV1.setPfAccountExecutiveId(plan.getPfAccountExce().getId());
	    	
	    	String pfaccName=plan.getPfAccountExce().getName().replaceAll("(\\()(\\d+)(\\))", " ").trim();
	    	String[] pfaccNameArr=pfaccName.split(",");
	    	if(pfaccNameArr.length==2){
	    		strippedPlanIndexV1.setPfAccountExecutiveName(pfaccNameArr[1]+" "+pfaccNameArr[0]);
	    	}else{
	    		strippedPlanIndexV1.setPfAccountExecutiveName(pfaccName);
	    	}
	    	strippedPlanIndexV1.setPfAdvertiserId(plan.getPfAdvertiser().getId());
	    	strippedPlanIndexV1.setPfAdvertiserName(plan.getPfAdvertiser().getName());
	    	strippedPlanIndexV1.setPfAgencyId(plan.getPfAgency().getId());
	    	strippedPlanIndexV1.setPfAgencyName(plan.getPfAgency().getName());
	    	strippedPlanIndexV1.setPfRatingStreamId(plan.getPfRatingStream().getId());
	    	strippedPlanIndexV1.setPfRatingStreamName(plan.getPfRatingStream().getName());
	    	strippedPlanIndexV1.setPfAdvertiserSFId(plan.getPfAdvertiser().getSfName());
	    	strippedPlanIndexV1.setPfAgencySFId(plan.getPfAgency().getSfName());
	    	strippedPlanIndexV1.setPfMarketPlaceId(plan.getPfMarketPlace().getId());
	    	strippedPlanIndexV1.setPfMarketPlaceName(plan.getPfMarketPlace().getName());
    	
    	}
    	strippedPlanIndexV1.setAdvertiserId(plan.getAdvertiser().getId());
    	strippedPlanIndexV1.setAdvertiserName(plan.getAdvertiser().getName());
    	strippedPlanIndexV1.setAgencyId(plan.getAgency().getId());
    	strippedPlanIndexV1.setAgencyName(plan.getAgency().getName());
    	strippedPlanIndexV1.setBrandId(plan.getBrand().getId());
    	strippedPlanIndexV1.setBrandName(plan.getBrand().getName());
    	strippedPlanIndexV1.setChannelId(plan.getChannel().getId());
    	strippedPlanIndexV1.setChannelName(plan.getChannel().getName());
    	strippedPlanIndexV1.setCreationDate(plan.getCreationDate());
    	strippedPlanIndexV1.setDealYearId(plan.getDealYear().getId());
    	strippedPlanIndexV1.setDealYearName(plan.getDealYear().getName());
    	
    	if(plan.getDivision()!=null){
	    	strippedPlanIndexV1.setDivisionId(plan.getDivision().getId());
	    	strippedPlanIndexV1.setDivisionName(plan.getDivision().getName());
    	}
    	
    	strippedPlanIndexV1.setEndCalanderEndDate(plan.getEndQtrId().getCalanderEndDate());
    	strippedPlanIndexV1.setEndCalanderStartDate(plan.getEndQtrId().getCalanderStartDate());
    	strippedPlanIndexV1.setEndCurrQrtOrderNo(plan.getEndQtrId().getCurrQrtOrderNo());
    	strippedPlanIndexV1.setEndDate(plan.getEndDate());
    	strippedPlanIndexV1.setEndOrderNo(plan.getEndQtrId().getOrderNo());
    	strippedPlanIndexV1.setEndQuarterValue(plan.getEndQtrId().getQuarterValue());
    	strippedPlanIndexV1.setEndQuarterId(plan.getEndQtrId().getId());
    	strippedPlanIndexV1.setEndQuarterName(plan.getEndQtrId().getName());
    	if(plan.getLinkChannel()!=null){
	    	strippedPlanIndexV1.setLinkChannelId(plan.getLinkChannel().getId());
	    	strippedPlanIndexV1.setLinkChannelName(plan.getLinkChannel().getName());
    	}
    	strippedPlanIndexV1.setMarketPlaceId(plan.getMarketPlace().getId());
    	strippedPlanIndexV1.setMarketPlaceName(plan.getMarketPlace().getName());
    	strippedPlanIndexV1.setModificationDate(plan.getModificationDate());
    	strippedPlanIndexV1.setOfficeId(plan.getOffice().getId());
    	strippedPlanIndexV1.setOfficeName(plan.getOffice().getName());
    	strippedPlanIndexV1.setOriginalPlanId(plan.getOriginalPlanId());
    	strippedPlanIndexV1.setPlanApprovalStatusId(plan.getPlanApprovalStatus().getId());
    	strippedPlanIndexV1.setPlanApprovalStatusName(plan.getPlanApprovalStatus().getName());
    	strippedPlanIndexV1.setPlanClassId(plan.getPlanClass().getId());
    	strippedPlanIndexV1.setPlanClassName(plan.getPlanClass().getName());
    	
    	strippedPlanIndexV1.setPlanLinkID(plan.getPlanLinkID());
    	strippedPlanIndexV1.setPlanLinkName(plan.getPlanLinkName());
    	
    	strippedPlanIndexV1.setPlanStatusId(plan.getPlanStatus().getId());
    	strippedPlanIndexV1.setPlanStatusName(plan.getPlanStatus().getName());
    	strippedPlanIndexV1.setPlanSubStatus(plan.getPlanSubStatus());
    	strippedPlanIndexV1.setPlanVersionNumber(plan.getPlanVersionNumber());
    	strippedPlanIndexV1.setPortfolioCreationDt(plan.getPortfolioCreationDt());
    	strippedPlanIndexV1.setPortfolioModificationDt(plan.getPortfolioModificationDt());
    	strippedPlanIndexV1.setPortfolioName(plan.getPortfolioName());
    	strippedPlanIndexV1.setPortfolioId(plan.getPortfolioId());
    	strippedPlanIndexV1.setRatingStreamId(plan.getRatingStream().getId());
    	strippedPlanIndexV1.setRatingStreamName(plan.getRatingStream().getName());
    	strippedPlanIndexV1.setRevisionNo(plan.getRevisionNo());
    	strippedPlanIndexV1.setTargetGroupId(plan.getTargetGroup().getId());
    	strippedPlanIndexV1.setTargetGroupName(plan.getTargetGroup().getName());
    	strippedPlanIndexV1.setVersionNo(plan.getVersionNo());
    	
    	strippedPlanIndexV1.setStartCalanderEndDate(plan.getStartQtrId().getCalanderEndDate());
    	strippedPlanIndexV1.setStartCalanderStartDate(plan.getStartQtrId().getCalanderStartDate());
    	strippedPlanIndexV1.setStartCurrQrtOrderNo(plan.getStartQtrId().getCurrQrtOrderNo());
    	strippedPlanIndexV1.setStartDate(plan.getStartDate());
    	strippedPlanIndexV1.setStartOrderNo(plan.getStartQtrId().getOrderNo());
    	strippedPlanIndexV1.setStartQuarterValue(plan.getStartQtrId().getQuarterValue());
    	strippedPlanIndexV1.setStartQuarterId(plan.getStartQtrId().getId());
    	strippedPlanIndexV1.setStartQuarterName(plan.getStartQtrId().getName());
    	
    	if(plan.getSubDivision()!=null){
	    	strippedPlanIndexV1.setSubDivisionId(plan.getSubDivision().getId());
	    	strippedPlanIndexV1.setSubDivisionName(plan.getSubDivision().getName());
    	}
    	
    	if(plan.getPfTargetGroup()!=null){
	    	strippedPlanIndexV1.setPfTargetGroupId(plan.getPfTargetGroup().getId());
	    	strippedPlanIndexV1.setPfTargetGroupName(plan.getPfTargetGroup().getName());
    	}
    	
    	strippedPlanIndexV1.setAdvertiserSFId(plan.getAdvertiser().getSfName());
    	strippedPlanIndexV1.setAgencySFId(plan.getAgency().getSfName());

    	return strippedPlanIndexV1;
    	}catch(Exception e){
    		throw new RuntimeException("Error occured while processing the plan data to ES :"+e.getMessage());
    	}
    }

}
