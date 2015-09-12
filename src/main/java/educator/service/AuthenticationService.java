package educator.service;


import javax.security.auth.login.CredentialException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import educator.dao.UserDao;
import educator.dao.model.User;
import educator.security.SecurityUtil;
import educator.security.UserDetail;
import ninja.Context;


public class AuthenticationService
{
    @Inject
    UserDao userDao;

    private static final Logger LOG = LoggerFactory.getLogger( AuthenticationService.class );

    public User login( String email, String password) throws CredentialException
    {
        User user = userDao.findUserByEmail( email );
        if ( user == null )
        {
            throw new CredentialException( String.format( "User with email '%s' not found", email ) );
        }
        if ( user.isBlocked() )
        {
            throw new CredentialException( "Your account is blocked." );
        }

        String hashedPassword;
        try
        {
            hashedPassword = SecurityUtil.hash( password );
        }
        catch ( NullPointerException e )
        {
            LOG.debug( "No password", e );
            throw new CredentialException( "Please set a password!" );
        }
        if ( !user.getPassword().equals( hashedPassword ) )
        {
                throw new CredentialException( "Email and Password mismatch" );
        }

        userDao.save(user);
        return user;
    }

    public UserDetail getCurrentUser( Context context )
    {
        return SecurityUtil.getCurrentUser( context );
    }

}
