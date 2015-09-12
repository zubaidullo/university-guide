package filters;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import educator.security.UserDetail;
import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;
import ninja.Results;
import ninja.session.Session;


public class AuthenticatedFilter implements Filter
{
    public static final String USER_DETAILS = "userDetails";

    private static final Logger LOGGER = LoggerFactory.getLogger( AuthenticatedFilter.class );

    @Inject
    private ObjectMapper mapper;


    @Override
    public Result filter( FilterChain filterChain, Context context )
    {
        Session session = context.getSession();

        if ( session != null && session.get( USER_DETAILS ) != null )
        {
            String json = session.get( USER_DETAILS );
            try
            {
                UserDetail ud = mapper.readValue( json, UserDetail.class );
                context.setAttribute( USER_DETAILS, ud );
                return filterChain.next( context );
            }
            catch ( IOException ex )
            {
                LOGGER.warn( "Invalid user details in session", ex );
            }
        }
        return Results.redirect( "/" );
    }
}

