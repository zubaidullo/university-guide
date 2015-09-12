package educator.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.collections.CollectionUtils;

import educator.dao.model.University;


/**
 * Created by Zubaidullo on 12.09.2015.
 */
public class UniversityDao extends AbstractDao<University> implements Dao<University>
{
    @Override
    protected void setPersistenceClass()
    {
        clazz = University.class;
    }


    @Override
    protected Serializable getId( final University entity )
    {
        return null;
    }


    public University findUniversityByCountry(String country)
    {
        Criteria criteria = getCriteria();
        criteria.add( Restrictions.eq( "country", country ) );
        List<University> found = criteria.list();
        return CollectionUtils.isEmpty( found ) ? null : found.get( 0 );
    }

    public University findUserByCity(String city)
    {
        Criteria criteria = getCriteria();
        criteria.add( Restrictions.eq( "city", city ) );
        List<University> found = criteria.list();
        return CollectionUtils.isEmpty( found ) ? null : found.get( 0 );
    }

}
