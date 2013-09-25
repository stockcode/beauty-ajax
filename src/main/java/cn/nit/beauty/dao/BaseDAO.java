package cn.nit.beauty.dao;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;

/**
 * <p>
 * We have this base class for our GenericDAOs so that we don't have to override
 * and autowire the sessionFactory property for each one. That is the only
 * reason for having this class.
 * 
 * <p>
 * The @Autowired annotation tells Spring to inject the sessionFactory bean into
 * this setter method.
 * 
 * @author gengke
 */
public class BaseDAO<T> extends GenericDAOImpl<T, String> implements GenericDAO<T, String> {
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void truncate() {		
	}
	
	public List<T> findByExample(T entity) {
		return search(new Search().addFilter(getFilterFromExample(entity)));
	}
	
	public List<T> findByProperty(String propertyName, Object propertyValue) {
		return search(new Search().addFilterEqual(propertyName, propertyValue));
	}
	
	public T findByName(String name) {
		List<T> list = search(new Search().addFilterEqual("name", name));
		return list.size() == 0 ? null : list.get(0);
	}
}
