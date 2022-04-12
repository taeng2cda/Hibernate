package Dao;


import Entity.Category;

import java.util.List;

public class CategoryDao extends JpaDao<Category> implements GenericDao<Category> {

	@Override
	public List<Category> findAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public Category find(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}

}
