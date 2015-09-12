package educator.security;


public class UserDetail
{
    private long id;
    private String linkId;
    private String name = null;
    private boolean authenticated = false;
    private Boolean rememberMe;
    private double balance;


    public UserDetail()
    {
    }


    public UserDetail( long id, String name, boolean isAuthenticated )
    {
        this.id = id;
        this.name = name;
        this.authenticated = isAuthenticated;
    }


    public boolean isAuthenticated()
    {
        return authenticated;
    }


    public void setAuthenticated( boolean authenticated )
    {
        this.authenticated = authenticated;
    }


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    public long getId()
    {
        return id;
    }


    public void setId( final long id )
    {
        this.id = id;
    }


    public Boolean getRememberMe()
    {
        return rememberMe;
    }


    public void setRememberMe( final Boolean rememberMe )
    {
        this.rememberMe = rememberMe;
    }


    public String getLinkId()
    {
        return linkId;
    }


    public void setLinkId( final String linkId )
    {
        this.linkId = linkId;
    }


    public double getBalance()
    {
        return balance;
    }


    public void setBalance( final double balance )
    {
        this.balance = balance;
    }
}
