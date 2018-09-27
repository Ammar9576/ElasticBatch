package webapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import webapp.dao.PlanRepository;
import webapp.dao.StrippedPlanRepository;
import webapp.domain.Plan;
import webapp.domain.StrippedPlan;
import webapp.util.specifications.PlanStatusFilterSpecifications;
import webapp.util.specifications.StrippedPlanSpecifications;

@Service
@RefreshScope
public class StrippedPlanService extends AbstractService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StrippedPlanRepository strippedplanRepo;
	
	@Autowired
	PlanRepository planRepository;
	
    @Autowired
    public RestHighLevelClient restClient;
    
    @Value("${indexname}")
    private String indexName;
	
	public List<?> getPlanData() throws Exception {
		List<StrippedPlan> planData = new ArrayList<StrippedPlan>();
		try {
			Specifications superSpec = null;
			
			superSpec = Specifications.where(StrippedPlanSpecifications.dummyCondition());

			planData = strippedplanRepo.findAll(superSpec);
			
		} catch (Exception e) {
			System.out.println("Exception in getPlanData()--" + e);
			throw e;
		}
		return planData;
	}
	
	
	
	public  List<Plan> getCancelledOrDeletedPlanData(String date,List<String> filterParams) throws Exception {
		List<Plan> planData = new ArrayList<Plan>();
		try {
			//planData =  planStatusFilterRepository.findByPlanStatusModificationDateAfterAndPlanStatusCodeIn(date,filterParams);
			Specifications superSpec = null;
			superSpec = Specifications.where(PlanStatusFilterSpecifications.dummyCondition());
			superSpec = superSpec.and(PlanStatusFilterSpecifications.modificationDateGreaterthanAndEqual(date));
			superSpec = superSpec.and(PlanStatusFilterSpecifications.hasPlanStatus(filterParams));  

			planData = planRepository.findAll(superSpec);
		} catch (Exception e) {
			System.out.println("Exception in getCancelledOrDeletedPlanData()--" + e);
			throw e;
		}
		return planData;
	}
	
	public static StringBuilder getCommaSepString(Object[] param, int startIndex, int endIndex) {
		StringBuilder sb = new StringBuilder();
		if (param != null) {

			for (int i = startIndex; i <= endIndex - 1; i++) {
				sb.append(param[i] + ",");
			}
			if (sb.length() > 0 && ',' == sb.charAt(sb.length() - 1)) {
				sb.deleteCharAt(sb.length() - 1);
			}
		}

		return sb;
	}
	
	public static List<StringBuilder> splitValueByHundred(String sb) {
		List<StringBuilder> returnList = new ArrayList<StringBuilder>();
		String[] valArr = null;
		int i = 0;
		if (sb != null) {
			valArr = sb.split(",");
			//System.out.println(valArr.length);
			if (valArr != null) {
				if (valArr.length > 100) {
					int cnt = valArr.length / 100;
					for (i = 0; i < cnt; i++) {
						returnList.add(getCommaSepString(valArr, i * 100, 100 * (i + 1)));
					}
					if(i * 100!=valArr.length){
						returnList.add(getCommaSepString(valArr, i * 100, valArr.length));
					}
				} else {
					returnList.add(getCommaSepString(valArr, 0, valArr.length));
				}
			}
		}
		return returnList;
	}
	
	
		public boolean deleteCancelledOrDeletedPlanData(Set<String> planIds) throws Exception {
	    	ObjectMapper mapper = new ObjectMapper();
	    	try{
	       	 if(planIds!=null && planIds.size()>0){
	       		
	       		String planQuery = String.join(",", planIds);
	       		List<StringBuilder> planIdList = splitValueByHundred(planQuery);
	       		for(StringBuilder sb:planIdList)
	       		{
	       			planQuery = sb.toString();
	       			planQuery = planQuery.replaceAll(",", " ");
	       			JsonArray fieldsJsonArray = Json.createArrayBuilder()
				       									.add("planId")
				       									.build();
	       			
	       			JsonObject esQueryObject =
	       			        Json.createObjectBuilder()
	       			                .add("query",Json.createObjectBuilder()
	       			                		.add("bool",Json.createObjectBuilder()
	       			                				.add("must",Json.createObjectBuilder()
	       			                						.add("multi_match",Json.createObjectBuilder()
	       			                								.add("query",planQuery)
	       			                								.add("fields",fieldsJsonArray)
	       			                							)
	       			                					)
	       			                			)
	       			                	)
	       			               .build();
	       			
	       			
	       			HttpEntity entity = new NStringEntity(esQueryObject.toString(), ContentType.APPLICATION_JSON);
	       			Map<String, String> params = Collections.emptyMap();
	       			
	       			System.out.println("Deleting the plans"+planQuery);
	       			
	       			restClient.getLowLevelClient().performRequest("POST",indexName+"/_delete_by_query?conflicts=proceed", params, entity);
	       			
	       		}
	       		return true; 
	       	}
	       	}catch(Exception e){
	       		throw new RuntimeException("Error occured while clearing existing Plan ids for Cancelled :"+planIds+ "-->"+e.getMessage());
	       	}
			return false;
		}

}
