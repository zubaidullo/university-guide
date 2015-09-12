package educator.dao;


import java.io.Serializable;
import java.util.List;


public interface Dao<T extends Serializable>
{

    public T save( T entity );

    public void persist( T entity );

    public T merge( T entity );

    public void refresh( T entity );

    public void delete( T entity );

    public T find( Object id );

    public List<T> findAll();
}
