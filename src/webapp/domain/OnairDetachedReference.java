/**
 * 
 */
package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 501566335
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "onair", name = "codesc")
public class OnairDetachedReference extends AbstractDomainObject {

	
	@Override
	@Id
	@Column(name = "CODE")
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.AbstractDomainObject#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.AbstractDomainObject#getName()
	 */
	@Override
	@Column(name = "DESCRIPTION",updatable=false, insertable=false)
	public String getName() {
		// TODO Auto-generated method stub
		
		if("Guaranteed".equals(this.name)){
			return "Y";
		}else if("Not Guaranteed".equals(this.name)){
			return "N";
		}
		return this.name;
		
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.AbstractDomainObject#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name =name;
		
	}

}
