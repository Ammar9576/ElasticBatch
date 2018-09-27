package webapp.job;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PreDestroy;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import com.fasterxml.jackson.databind.ObjectMapper;

import webapp.domain.Portfolio;

/**
 * 
 */
@RefreshScope
public class PortfolioWriter implements ItemWriter<Portfolio>, InitializingBean {

  
    @Override
    public void afterPropertiesSet() throws Exception {}
    
    @Autowired
    public RestHighLevelClient restClient;
    
    
    @Value("${indexname}")
    private String indexName;

    @Override
    public void write(List<? extends Portfolio> list) throws Exception {
    	ObjectMapper mapper = new ObjectMapper();
    	Set<String> portfolioIds=new HashSet<String>();
    	Set<String> planIds=new HashSet<String>();
    	try{
    	 if(list!=null && list.size()>0){
    		 BulkRequest bulkRequest = new BulkRequest();
    		
    		for(Portfolio portfolio:list){
    			portfolioIds.add(portfolio.getPortfolioLinking().getId().toString());
    			planIds.add(portfolio.getPlanId().toString());
    		}
    		if(portfolioIds!=null && portfolioIds.size()>0){

    			String portfolioQuery = String.join(" ", portfolioIds);
    			String planQuery = String.join(" ", planIds);
    			
    			JsonArray portfolioJsonArray=Json.createArrayBuilder()
    			        .add("portfolioId").build();
    			JsonArray planJsonArray=Json.createArrayBuilder()
    			        .add("planId").build();
    			JsonObject jsonObject1 =
    			        Json.createObjectBuilder()
    			                .add("script",  
    			                		Json.createObjectBuilder().add("source","ctx._source.portfolioId = '';ctx._source.pfAgencyName = '';ctx._source.pfAccountExecutiveName = '';  ctx._source.pfAdvertiserSFId = '';  ctx._source.pfTargetGroupName = ''; ctx._source.pfAgencyId ='' ;  ctx._source.pfTargetGroupId =''  ;ctx._source.pfAgencySFId = '';  ctx._source.pfRatingStreamId ='' ;  ctx._source.pfAdvertiserId = ''; ctx._source.pfAdvertiserName = '';  ctx._source.pfRatingStreamName = '';  ctx._source.pfAccountExecutiveId =''")
    			                		.add("lang", "painless"))
    			                //.add("query", Json.createObjectBuilder().add("multi_match",Json.createObjectBuilder().add("query",searchQuery).add("fields",jsonArray)))
    			                
    			               .add("query", Json.createObjectBuilder().add("constant_score",
    			                		 Json.createObjectBuilder().add("filter",
    			                				 Json.createObjectBuilder().add("bool",
    			                						 Json.createObjectBuilder().add("should",Json.createObjectBuilder().add("multi_match",Json.createObjectBuilder().add("query",portfolioQuery).add("fields",portfolioJsonArray)))
    			                						 .add("must_not",Json.createObjectBuilder().add("multi_match",Json.createObjectBuilder().add("query",planQuery).add("fields",planJsonArray)))
    			                		))))
    			               .build();
    			
    			HttpEntity entity = new NStringEntity(jsonObject1.toString(), ContentType.APPLICATION_JSON);
    			Map<String, String> params = Collections.emptyMap();
    			restClient.getLowLevelClient().performRequest("POST", indexName+"/_update_by_query?conflicts=proceed", params, entity);
    		}
    	}
    	}catch(Exception e){
    		throw new RuntimeException("Error occured while clearing existing porfolio ids :"+portfolioIds+ "-->"+e.getMessage());
    	}

    }
    
    @PreDestroy
    public void cleanup() {
        try {
            this.restClient.close();
        } catch (IOException ioe) {
        }
    }

}
