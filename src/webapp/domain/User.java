package webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "ONAIR", name = "APP_USER")
public class User extends AbstractDomainObject {

	private String				userSSOId;
	


	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDENT")
	public String getUserSSOId() {
		return userSSOId;
	}

	public void setUserSSOId(String userSSOId) {
		this.userSSOId = userSSOId;
	}

	
	@Override
	@Id
	@Column(name = "USER_ID")
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
	@Column(name = "USER_NAME")
	public String getName() {
		// TODO Auto-generated method stub
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
		this.name = name;
	}

	
}
