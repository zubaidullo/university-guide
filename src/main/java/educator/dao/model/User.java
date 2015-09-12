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

import educator.dao.model.roles.Role;


/**
 * Created by ${Zubaidullo} on 4/6/15.
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;

    @Column( name = "email" )
    private String email;

    @Column( name = "name" )
    private String name;

    @Column( name = "surname" )
    private String surname;

    @Column( name = "school" )
    private String school;

    @Column( name = "password" )
    private String password;

    @Column( name = "motivation_u_id" )
    private long motivUni;

    @Column( name = "balance" )
    private Double balance;

    @Column( name = "blocked" )
    private Boolean blocked;

    @Column( name = "phone_number" )
    private String phoneNumber;

    @Column( name = "role" )
    private Role role;

    @Column( name = "country" )
    private Country country;

    @Column( name = "city" )
    private City city;

    @Column( name = "sex" )
    private Gender sex;

    @Column( name = "birth" )
    private Date birth;

    @Column( name = "created_at" )
    private Date createdAt;


    public User()
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


    public String getName()
    {
        return name;
    }


    public void setName( final String name )
    {
        this.name = name;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail( final String email )
    {
        this.email = email;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword( final String password )
    {
        this.password = password;
    }


    public long getMotivUni()
    {
        return motivUni;
    }


    public void setMotivUni( final long motivUni )
    {
        this.motivUni = motivUni;
    }


    public Double getBalance()
    {
        return balance;
    }


    public void setBalance( final Double balance )
    {
        this.balance = balance;
    }


    public Boolean isBlocked()
    {
        return blocked;
    }


    public void setBlocked( final Boolean blocked )
    {
        this.blocked = blocked;
    }


    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    public void setPhoneNumber( final String phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }


    public Role getRole()
    {
        return role;
    }


    public void setRole( final Role role )
    {
        this.role = role;
    }


    public Country getCountry()
    {
        return country;
    }


    public void setCountry( final Country country )
    {
        this.country = country;
    }


    public City getCity()
    {
        return city;
    }


    public void setCity( final City city )
    {
        this.city = city;
    }


    public Gender getSex()
    {
        return sex;
    }


    public void setSex( final Gender sex )
    {
        this.sex = sex;
    }


    public Date getBirth()
    {
        return birth;
    }


    public void setBirth( final Date birth )
    {
        this.birth = birth;
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
