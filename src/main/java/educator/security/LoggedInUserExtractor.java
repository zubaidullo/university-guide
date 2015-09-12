package educator.security;


import org.flywaydb.core.internal.util.logging.Log;
import org.flywaydb.core.internal.util.logging.LogFactory;

import com.google.gson.Gson;

import filters.AuthenticatedFilter;
import ninja.Context;
import ninja.params.ArgumentExtractor;


public class LoggedInUserExtractor implements ArgumentExtractor<UserDetail>
{
    private static final Log LOG = LogFactory.getLog( LoggedInUserExtractor.class );


    @Override
    public UserDetail extract( Context context )
    {
        UserDetail userDetail = null;
        String userDetailsJson = context.getSession().get( AuthenticatedFilter.USER_DETAILS );
        try
        {
            userDetail = new Gson().fromJson( userDetailsJson, UserDetail.class );
        }
        catch ( Exception ex )
        {
            LOG.warn( "Attempt to read user detail from session failed" );
        }
        return userDetail;
    }


    @Override
    public Class<UserDetail> getExtractedType()
    {
        return UserDetail.class;
    }


    @Override
    public String getFieldName()
    {
        return null;
    }
}