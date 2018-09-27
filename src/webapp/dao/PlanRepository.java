package webapp.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import webapp.domain.Plan;

@Repository
public interface PlanRepository  extends JpaRepository<Plan, Serializable>, JpaSpecificationExecutor{
	
}