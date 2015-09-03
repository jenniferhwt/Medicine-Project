package com.rippletec.medicine.support;

import java.sql.SQLException;
import java.util.List;









import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Liuyi
 * HibernateTemplate装饰类，为HibernateTemplate提供额外的功能
 * @param <T>
 */
public class PlusHibernateSupport<T> extends HibernateDaoSupport{

 
    public List<T> findByPage(final String hql, int offset, int pageSize) {
	return findByPage(hql,new String[]{}, new Object[]{}, offset, pageSize);
    }
    
    public List<T> findByPage(final String hql,final String param,final Object value, int offset, int pageSize) {
	return findByPage(hql,new String[]{param}, new Object[]{value}, offset,pageSize);
    }
    
    
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<T> findByPage(final String hql,final String[] params,final Object[] values, final int offset, final int pageSize) {
	List<T> items = getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {

	    @Override
	    public List<T> doInHibernate(Session session)
		    throws HibernateException, SQLException {
		Query q = session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
		    q.setParameter(params[i], values[i]);
		}
		List<T> result = q.setFirstResult(offset).setMaxResults(pageSize).list();
		return result;
	    }
	    
	});
	return items;
    }

}
