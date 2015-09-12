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

    @Column( name = "code" )
    private ExamType code;

    @Column( name = "uni_id" )
    private long universityId;

    @Column( name = "is_visible" )
    private Boolean isVisible;

    @Column( name = "description" )
    private String description;

    @Column( name = "min_requirement" )
    private Country country;

    @Column( name = "city" )
    private City city;

    @Column( name = "deadline" )
    private Date deadline;

    @Column( name = "created_at" )
    private Date createdAt;

    @Column( name = "scholarship_opp" )
    private Boolean scholarshipOpp;

    public Exam()
    {
        this.createdAt = new Date();
    }



}
