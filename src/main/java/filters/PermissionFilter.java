package filters;


import com.google.inject.Inject;

import educator.dao.UserDao;
import educator.dao.model.User;
import educator.dao.model.roles.Permission;
import educator.security.SecurityUtil;
import educator.security.UserDetail;
import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;
import ninja.Results;


public class PermissionFilter implements Filter
{
    /**
     * Filter first checks a class annotation, then checks a method annotation
     * @param filterChain
     * @param context
     * @return
     */
    @Inject
    UserDao userDao;


    @Override
    public Result filter( final FilterChain filterChain, final Context context )
    {
        boolean blocked = false;

        UserDetail userDetail = SecurityUtil.getCurrentUser( context );

        if ( userDetail == null )
        {
            blocked = true;
        }

        if ( !blocked && null != context.getRoute().getControllerClass().getAnnotation( PermissionPolicy.class ) )
        {
            blocked = filterWithClassAnnotation( context, userDetail );
        }

        if ( !blocked && null != context.getRoute().getControllerMethod().getAnnotation( PermissionPolicy.class ) )
        {
            blocked = filterWithMethodAnnotation( context, userDetail );
        }

        if ( blocked )
        {
            return Results.forbidden();
        }
        return filterChain.next( context );
    }

    private boolean filterWithClassAnnotation( Context context, UserDetail userDetail )
    {
        for ( Permission permission : context.getRoute().getControllerClass()
                                             .getAnnotation( PermissionPolicy.class ).value() )
        {
            if ( !isPermitted( userDetail, permission ) )
            {
                return true;
            }
        }

        return false;
    }

    private boolean filterWithMethodAnnotation( Context context, UserDetail userDetail )
    {
        for ( Permission permission : context.getRoute().getControllerMethod()
                                             .getAnnotation( PermissionPolicy.class ).value() )
        {

            if ( !isPermitted( userDetail, permission ) )
            {
                return true;
            }
        }

        return false;
    }

    private boolean isPermitted( UserDetail userDetail, Permission permission )
    {
        User user = userDao.find( userDetail.getId() );
        if ( user.getRole().isPermitted( permission ) )
        {
            return true;
        }

        for ( Permission userPermission : user.getRole().getPermissions() )
        {
            if ( userPermission == permission )
            {
                return true;
            }
        }

        return false;
    }
}
