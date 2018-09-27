package webapp.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "ONAIR", name = "PORTFOLIO_LINKING")

public class PortfolioLinking{

    private Long id;
    private String name;
    private Timestamp                    modificationDate;

    public PortfolioLinking()
    {
        super();
    }
    
    @Id
    @Column(name = "PORTFOLIO_LINKING_ID")
    public Long getId() {
        return this.id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name = "PORTFOLIO_LINKING_NAME")
    public String getName() {
        return this.name;
    }

    
    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "MODIFICATION_DT")
    public Timestamp getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }


}
