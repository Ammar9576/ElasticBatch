package webapp.util.specifications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import webapp.domain.Plan;

public class PlanStatusFilterSpecifications {
	
	
	
	
	public static Specification<Plan> dummyCondition() {
		return new Specification<Plan>() {
			@Override
			public Predicate toPredicate(Root<Plan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.orderBy(cb.asc(root.get("planId")));
				return query.getRestriction();
			}
		};
	}
		
	/*public static Specification<PlanStatusFilter> planStatusModificationDateGreaterthanAndEqual(String date) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		Date  indexDate=new Date(format.parse(date).getTime() - 2 * 48 * 3600 * 1000);
		return new Specification<PlanStatusFilter>() {
			@Override
			public Predicate toPredicate(Root<PlanStatusFilter> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.greaterThanOrEqualTo(root.get("modificationDate"), date));
				return query.getRestriction();
			}
		};
	}*/
	
	public static Specification<Plan> modificationDateGreaterthanAndEqual(String from) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		java.util.Date fromDate=format.parse(from);
		return new Specification<Plan>() {
			@Override
			public Predicate toPredicate(Root<Plan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.greaterThanOrEqualTo(root.get("modificationDate"), fromDate));
				return query.getRestriction();
			}
		};
	}
	
	
	public static Specification<Plan> hasPlanStatus(List<String> filterParams) {
		return new Specification<Plan>() {

			@Override
			public Predicate toPredicate(Root<Plan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("planStatusCode").in(filterParams));
				return query.getRestriction();
			}
		};
	}

}