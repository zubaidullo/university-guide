package educator.dao.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Zubaidullo on 12.09.2015.
 */
@Entity
@Table(name = "register_verification")
public class RegisterVerification implements Serializable
{
    @Id
    @Column( name = "verification_code" )
    private String verificationCode;

    @Column( name = "link_id" )
    private String linkId;

    @Column( name = "created_at" )
    private Date created_at;

    @Column( name = "name" )
    private String name;

    @Column( name = "phone_number" )
    private String phoneNumber;

    @Column( name = "password" )
    private String password;

    @Column( name = "email" )
    private String email;


    public RegisterVerification()
    {
        created_at = new Date();
    }


    public Date getCreated_at()
    {
        return created_at;
    }


    public void setCreated_at( final Date created_at )
    {
        this.created_at = created_at;
    }


    public String getVerificationCode()
    {
        return verificationCode;
    }


    public void setVerificationCode( final String verificationCode )
    {
        this.verificationCode = verificationCode;
    }


    public String getName()
    {
        return name;
    }


    public void setName( final String name )
    {
        this.name = name;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword( final String password )
    {
        this.password = password;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail( final String email )
    {
        this.email = email;
    }


    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    public void setPhoneNumber( final String phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }


    public String getLinkId()
    {
        return linkId;
    }


    public void setLinkId( final String linkId )
    {
        this.linkId = linkId;
    }
}
