package webapp.job;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PreDestroy;

import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import com.fasterxml.jackson.databind.ObjectMapper;

import webapp.domain.StrippedPlanIndexV1;

/**
 * 
 */
@RefreshScope
public class IndexWriter implements ItemWriter<StrippedPlanIndexV1>, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {}
    
    @Autowired
    public RestHighLevelClient restClient;
    
    @Value("${indexname}")
    private String indexName;

    @Override
    public void write(List<? extends StrippedPlanIndexV1> list) throws Exception {
    	ObjectMapper mapper = new ObjectMapper();
    	try{
    	if(list!=null && list.size()>0){
    		
    		BulkRequest bulkRequest = new BulkRequest();
    		for(StrippedPlanIndexV1 strippedPlan:list){
    			
    			String jsonInString = mapper.writeValueAsString(strippedPlan);
    			
    			Map<String, Object> map = new HashMap<String, Object>();
    			
    			bulkRequest.add(new IndexRequest(indexName, indexName, strippedPlan.getPlanId().toString()).source(jsonInString, XContentType.JSON));
    		}
	        if(bulkRequest!=null){ 
	        	BulkResponse bulkResponse = restClient.bulk(bulkRequest);

                if (bulkResponse.hasFailures()) {
                    throw new RuntimeException(bulkResponse.buildFailureMessage());
                }
                for (BulkItemResponse baa : bulkResponse) {
                    if (baa.getResponse().getShardInfo().getFailed() > 0) {
                        throw new RuntimeException("Shard level failure");
                    }
                }
	        }
    	}
    	}catch(Exception e){
    		throw new RuntimeException("Error occured while writing to ES :"+e.getMessage());
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
