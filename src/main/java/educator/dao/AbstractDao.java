package educator.dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;


@Transactional
public abstract class AbstractDao<T extends Serializable> implements Dao<T>
{
    @Inject
    private Provider<EntityManager> entityManagerProvider;


    protected Class<T> clazz;


    public AbstractDao()
    {
        setPersistenceClass();
    }


    protected abstract void setPersistenceClass();

    protected abstract Serializable getId( T entity );


    protected boolean isValidId( Serializable id )
    {
        if ( id == null )
        {
            return false;
        }
        if ( id instanceof Number && ( ( Number ) id ).equals( 0 ) )
        {
            return false;
        }
        if ( id instanceof String && "".equals( id ) )
        {
            return false;
        }
        return true;
    }


    protected EntityManager getEntityManager()
    {
        return entityManagerProvider.get();
    }


    @Override
    public void persist( T entity )
    {
        getEntityManager().persist( entity );
    }


    protected Session getSession()
    {
        return getEntityManager().unwrap( Session.class );
    }


    protected Criteria getCriteria()
    {
        return getSession().createCriteria( clazz );
    }


    private T persistOrMerge( T entity )
    {
        EntityManager em = getEntityManager();

        if ( entity == null )
        {
            return null;
        }

        if ( em.contains( entity ) )
        {
            return entity;
        }

        Serializable id = getId( entity );

        if ( !isValidId( id ) )
        {
            persist( entity );
            return entity;
        }

        T prev = em.find( ( Class<T> ) entity.getClass(), id );
        if ( prev == null )
        {
            persist( entity );
            return entity;
        }
        else
        {
            return merge( entity );
        }
    }


    @Override
    public T merge( T entity )
    {
        return getEntityManager().merge( entity );
    }


    @Override
    public T save( T entity )
    {
        return persistOrMerge( entity );
    }


    @Override
    public void delete( T entity )
    {
        EntityManager em = getEntityManager();
        em.remove( em.contains( entity ) ? entity : em.merge( entity ) );
    }


    public void deleteById( Object id )
    {
        delete( find( id ) );
    }


    @Override
    public void refresh( T entity )
    {
        getEntityManager().refresh( entity );
    }


    public void detach( T entity )
    {
        getEntityManager().detach( entity );
    }


    @Override
    public T find( Object id )
    {
        return getEntityManager().find( clazz, id );
    }


    @Override
    public List<T> findAll()
    {
        EntityManager em = getEntityManager();
        List<T> list = em.createQuery( " from " + clazz.getName() ).getResultList();
        return list != null ? list : new ArrayList<T>();
    }
}
