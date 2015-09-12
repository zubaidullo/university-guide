package educator.dao.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by ${Zubaidullo} on 4/6/15.
 */
@Entity
@Table(name = "universities")
@JsonIgnoreProperties(ignoreUnknown = true)
public class University implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;

    @Column( name = "name" )
    private String name;

    @Column( name = "address" )
    private String address;

    @Column( name = "is_visible" )
    private Boolean isVisible;

    @Column( name = "description" )
    private String description;

    @Column( name = "country" )
    private String country;

    @Column( name = "city" )
    private String city;

    @Column( name = "deadline" )
    private Date deadline;

    @Column( name = "created_at" )
    private Date createdAt;

    @Column( name = "image_url" )
    private String imageUrl;

    @Column( name = "logo_url" )
    private String logoUrl;

    @Column( name = "scholarship_opp" )
    private Boolean scholarshipOpp;

    public University()
    {
        this.createdAt = new Date();
        this.isVisible = true;
    }


    public long getId()
    {
        return id;
    }


    public void setId( final long id )
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName( final String name )
    {
        this.name = name;
    }


    public String getAddress()
    {
        return address;
    }


    public void setAddress( final String address )
    {
        this.address = address;
    }


    public Boolean getIsVisible()
    {
        return isVisible;
    }


    public void setIsVisible( final Boolean isVisible )
    {
        this.isVisible = isVisible;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription( final String description )
    {
        this.description = description;
    }


    public String getCountry()
    {
        return country;
    }


    public void setCountry( final String country )
    {
        this.country = country;
    }


    public String getCity()
    {
        return city;
    }


    public void setCity( final String city )
    {
        this.city = city;
    }


    public Date getDeadline()
    {
        return deadline;
    }


    public void setDeadline( final Date deadline )
    {
        this.deadline = deadline;
    }


    public Date getCreatedAt()
    {
        return createdAt;
    }


    public void setCreatedAt( final Date createdAt )
    {
        this.createdAt = createdAt;
    }


    public Boolean getScholarshipOpp()
    {
        return scholarshipOpp;
    }


    public void setScholarshipOpp( final Boolean scholarshipOpp )
    {
        this.scholarshipOpp = scholarshipOpp;
    }


    public String getImageUrl()
    {
        return imageUrl;
    }


    public void setImageUrl( final String imageUrl )
    {
        this.imageUrl = imageUrl;
    }


    public String getLogoUrl()
    {
        return logoUrl;
    }


    public void setLogoUrl( final String logoUrl )
    {
        this.logoUrl = logoUrl;
    }
}
