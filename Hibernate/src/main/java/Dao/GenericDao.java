package Dao;

import java.util.List;

public interface GenericDao<E> {
	public List<E> findAll();
	
	public E create(E t);
	
	public E find(Object id);
	
	public E update(E t);
	
	public void delete(Object id);
	
	public long count();
}
