package educator.dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import educator.dao.model.Exam;
import educator.dao.model.ExamType;


/**
 * Created by Zubaidullo on 12.09.2015.
 */
public class ExamDao extends AbstractDao<Exam> implements Dao<Exam>
{
    @Override
    protected void setPersistenceClass()
    {
        clazz = Exam.class;
    }


    @Override
    protected Serializable getId( final Exam entity )
    {
        return null;
    }


    public List<Exam> findByUniversity(long universityId)
    {
        Criteria criteria = getCriteria();
        criteria.add( Restrictions.eq( "universityId", universityId ) );
        List<Exam> list = criteria.list();
        return list != null ? list : new ArrayList<Exam>();
    }

    public List<Exam> findScoreAndType(ExamType type, Double score)
    {
        Criteria criteria = getCriteria();
        criteria.add( Restrictions.eq( "type", type ) );
        criteria.add( Restrictions.lt( "minRequirements", score ) );
        List<Exam> list = criteria.list();
        return list != null ? list : new ArrayList<Exam>();
    }

}
