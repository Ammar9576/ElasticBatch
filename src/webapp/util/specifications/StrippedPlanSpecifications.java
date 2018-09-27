package webapp.util.specifications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import webapp.domain.StrippedPlan;

public class StrippedPlanSpecifications {
	
	
	public static Specification<StrippedPlan> dummyCondition() {
		return new Specification<StrippedPlan>() {
			@Override
			public Predicate toPredicate(Root<StrippedPlan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.orderBy(cb.asc(root.get("id")));
				return query.getRestriction();
			}
		};
	}
	
	/*public static Specification<StrippedPlan> modificationDateGreaterthanAndEqual(String from) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		java.util.Date fromDate=format.parse(from);
		return new Specification<StrippedPlan>() {
			@Override
			public Predicate toPredicate(Root<StrippedPlan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.greaterThanOrEqualTo(root.get("modificationDate"), fromDate));
				return query.getRestriction();
			}
		};
	}
	
	public static Specification<StrippedPlan> creationDateGreaterthanAndEqual(String from) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		java.util.Date fromDate=format.parse(from);
		return new Specification<StrippedPlan>() {
			@Override
			public Predicate toPredicate(Root<StrippedPlan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.greaterThanOrEqualTo(root.get("creationDate"), fromDate));
				return query.getRestriction();
			}
		};
	}*/
	
	public static Specification<StrippedPlan> portfolioDateGreaterthanAndEqual(String date) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		//java.util.Date indexDate=format.parse(date);
		Date  indexDate=new Date(format.parse(date).getTime() - 2 * 48 * 3600 * 1000);
		return new Specification<StrippedPlan>() {
			@Override
			public Predicate toPredicate(Root<StrippedPlan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.greaterThanOrEqualTo(root.get("portfolioModificationDt"), indexDate));
				return query.getRestriction();
			}
		};
	}
	
	public static Specification<StrippedPlan> origmodificationDateGreaterthanAndEqual(String from) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		java.util.Date fromDate=format.parse(from);
		return new Specification<StrippedPlan>() {
			@Override
			public Predicate toPredicate(Root<StrippedPlan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.greaterThanOrEqualTo(root.get("origModificationDate"), fromDate));
				return query.getRestriction();
			}
		};
	}
	
	
	


}