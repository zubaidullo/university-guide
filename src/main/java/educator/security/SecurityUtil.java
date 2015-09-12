package educator.security;


import java.math.BigInteger;
import java.security.SecureRandom;

import org.flywaydb.core.internal.util.logging.Log;
import org.flywaydb.core.internal.util.logging.LogFactory;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;

import filters.AuthenticatedFilter;
import ninja.Context;


public class SecurityUtil
{
    private static final Log LOG = LogFactory.getLog( SecurityUtil.class );
    public static final SecureRandom RANDOM = new SecureRandom();

    public static UserDetail getCurrentUser( Context context )
    {
        UserDetail userDetail = null;

        try
        {
            String userDetailsJson = context.getSession().get( AuthenticatedFilter.USER_DETAILS );
            userDetail = new Gson().fromJson( userDetailsJson, UserDetail.class );
        }
        catch ( Exception e )
        {
            LOG.error( "Attempt to read user detail from session failed: ", e );
        }

        return userDetail;
    }

    public static String hash( final String value )
    {
        return DigestUtils.sha256Hex( value );
    }

    public static String generateRandomCode( int length )
    {
        String code;
        do
        {
            code = new BigInteger( length * 5, RANDOM ).toString( 32 ).toLowerCase();
        }
        while ( code.contains( "0" ) || code.contains( "O" ) || code.length() != length );
        return code;
    }
}
