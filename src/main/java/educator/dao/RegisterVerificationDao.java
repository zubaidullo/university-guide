package educator.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.apache.commons.collections.CollectionUtils;
import educator.dao.model.RegisterVerification;


/**
 * Created by Zubaidullo on 12.09.2015.
 */
public class RegisterVerificationDao extends AbstractDao<RegisterVerification> implements Dao<RegisterVerification> {
    @Override
    protected void setPersistenceClass() {
        clazz = RegisterVerification.class;
    }

    @Override
    protected Serializable getId( final RegisterVerification entity )
    {
        return null;
    }

    public RegisterVerification findByLinkId(String linkId)
    {
        Criteria criteria = getCriteria();
        criteria.add( Restrictions.eq( "linkId", linkId ) );
        List<RegisterVerification> found = criteria.list();
        return CollectionUtils.isEmpty( found ) ? null : found.get( 0 );
    }
}
