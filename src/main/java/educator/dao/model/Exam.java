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
@Table(name = "exams")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;

    @Column( name = "type" )
    private ExamType type;

    @Column( name = "uni_id" )
    private long universityId;

    @Column( name = "description" )
    private String description;

    @Column( name = "min_requirement" )
    private Double minRequirements;

    @Column( name = "created_at" )
    private Date createdAt;

    public Exam()
    {
        this.createdAt = new Date();
    }


    public long getId()
    {
        return id;
    }


    public void setId( final long id )
    {
        this.id = id;
    }


    public ExamType getType()
    {
        return type;
    }


    public void setType( final ExamType type )
    {
        this.type = type;
    }


    public long getUniversityId()
    {
        return universityId;
    }


    public void setUniversityId( final long universityId )
    {
        this.universityId = universityId;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription( final String description )
    {
        this.description = description;
    }


    public Double getMinRequirements()
    {
        return minRequirements;
    }


    public void setMinRequirements( final Double minRequirements )
    {
        this.minRequirements = minRequirements;
    }


    public Date getCreatedAt()
    {
        return createdAt;
    }


    public void setCreatedAt( final Date createdAt )
    {
        this.createdAt = createdAt;
    }
}
