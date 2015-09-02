package com.rippletec.medicine.support;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rippletec.medicine.bean.PageBean;
import com.rippletec.medicine.model.BaseModel;

/**
 * @author Liuyi
 * HibernateTemplate装饰类，为HibernateTemplate提供额外的功能
 */
public class PlusHibernateSupport extends HibernateDaoSupport implements IFindByPage{

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public List<BaseModel> findByPage(final String hql, final PageBean page) {
	List<BaseModel> items = getHibernateTemplate().executeFind(new HibernateCallback<List<BaseModel>>() {

	    @Override
	    public List<BaseModel> doInHibernate(Session session)
		    throws HibernateException, SQLException {
		List<BaseModel> result = session.createQuery(hql).setFirstResult(page.offset).setMaxResults(page.pageSize).list();
		return result;
	    }
	});
	return items;
    }
    

}
