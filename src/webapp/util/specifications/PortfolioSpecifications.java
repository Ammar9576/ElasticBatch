package webapp.util.specifications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import webapp.domain.Portfolio;
import webapp.domain.PortfolioLinking;

public class PortfolioSpecifications {
	
	
	public static Specification<Portfolio> dummyCondition() {
		return new Specification<Portfolio>() {
			@Override
			public Predicate toPredicate(Root<Portfolio> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.orderBy(cb.asc(root.get("id")));
				return query.getRestriction();
			}
		};
	}
		
	public static Specification<Portfolio> portfolioDateGreaterthanAndEqual(String date) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		Date  indexDate=new Date(format.parse(date).getTime() - 2 * 48 * 3600 * 1000);
		return new Specification<Portfolio>() {
			@Override
			public Predicate toPredicate(Root<Portfolio> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.greaterThanOrEqualTo(root.<PortfolioLinking>get("portfolioLinking").get("modificationDate"), indexDate));
				return query.getRestriction();
			}
		};
	}
	
	
	


}