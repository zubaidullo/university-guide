package educator.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.collections.CollectionUtils;

import educator.dao.model.User;


/**
 * Created by Zubaidullo on 12.09.2015.
 */
public class UserDao extends AbstractDao<User> implements Dao<User>
{
    @Override
    protected void setPersistenceClass()
    {
        clazz = User.class;
    }


    @Override
    protected Serializable getId( final User entity )
    {
        return null;
    }


    public User findUserByEmail(String email)
    {
        Criteria criteria = getCriteria();
        criteria.add( Restrictions.eq( "email", email ) );
        List<User> foundUsers = criteria.list();
        return CollectionUtils.isEmpty( foundUsers ) ? null : foundUsers.get( 0 );
    }


}
