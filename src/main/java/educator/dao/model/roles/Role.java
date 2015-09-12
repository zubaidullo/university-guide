package educator.dao.model.roles;


import java.util.List;

import com.google.common.collect.Lists;


public enum Role
{
    ADMIN ( Permission.ADMIN_PERMISSION, Permission.USER_PERMISSION, Permission.MANAGER_PERMISSION ),
    USER ( Permission.USER_PERMISSION ),
    MANAGER ( Permission.USER_PERMISSION, Permission.MANAGER_PERMISSION );


    private List<Permission> permissions;
    private Role( final Permission ... permissions )
    {
        this.permissions = Lists.newArrayList( permissions );
    }


    public boolean isPermitted( Permission permission )
    {
        return permissions.contains( permission );
    }


    public List<Permission> getPermissions() {
        return permissions;
    }
}
