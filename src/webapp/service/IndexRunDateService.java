package webapp.service;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import webapp.dao.IndexRunDateRepository;
import webapp.domain.IndexRunDate;
import webapp.util.specifications.IndexRunDateSpecifications;

@Service
public class IndexRunDateService extends AbstractService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IndexRunDateRepository indexRunDateRepository;
	
	
	public List<IndexRunDate> getData(String indexName, String machineName) throws Exception {
		List<IndexRunDate> indexRunDate=null;
		try {
			Specifications superSpec = null;
			superSpec = Specifications.where(IndexRunDateSpecifications.dummyCondition());
			superSpec = superSpec.and(IndexRunDateSpecifications.hasIndexName(indexName));
			superSpec = superSpec.and(IndexRunDateSpecifications.hasMachineName(machineName));
			indexRunDate = indexRunDateRepository.findAll(superSpec);
			
		} catch (Exception e) {
			System.out.println("Exception in getPlanData()--" + e);
			throw e;
		}
		return indexRunDate;
	}
	
	public void saveData(IndexRunDate indexRunDate/*String machineName, String indexName,Timestamp runDate*/) throws Exception {
		try {
			//indexRunDateRepository.updateIndexRunDate(machineName, indexName,runDate);
			indexRunDateRepository.save(indexRunDate);
		} catch (Exception e) {
			System.out.println("Exception in getPlanData()--" + e);
			throw e;
		}
	}

}
