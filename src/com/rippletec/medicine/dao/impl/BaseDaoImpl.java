package com.rippletec.medicine.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.rippletec.medicine.bean.PageBean;
import com.rippletec.medicine.dao.Dao;
import com.rippletec.medicine.dao.IFindByPage;
import com.rippletec.medicine.support.PlusHibernateSupport;
import com.rippletec.medicine.utils.StringUtil;

public abstract class BaseDaoImpl<T> extends PlusHibernateSupport<T> implements IFindByPage<T>, Dao<T>{
    
    @Resource
    public void _setSessionFactory(SessionFactory sessionFactory) {
	super.setSessionFactory(sessionFactory);
    }
    
    @Override
    public List<T> findByPage(PageBean page) {
	return findByPage(StringUtil.getSelectHql(getClassName()), page.offset, page.pageSize);
    }
    
    @Override
    public List<T> findByPage(String param, Object value, PageBean page) {
	String hql = StringUtil.getSelectHql(getClassName(), param);
	return findByPage(hql, param, value, page.offset, page.pageSize);
    }

    @Override
    public List<T> findByPage(Map<String, Object> paramMap,
	    PageBean page) {
	String[] params = paramMap.keySet().toArray(new String[]{});
	Object[] values = paramMap.values().toArray();
	String hql = StringUtil.getSelectHql(getClassName(), params);
	return findByPage(hql, params, values, page.offset, page.pageSize);
    }

    @Override
    public Integer save(T model) {
	return (Integer) getHibernateTemplate().save(model);
    }

    @Override
    public void delete(Integer id) {
	getHibernateTemplate().delete(find(id));
    }

    @Override
    public void update(T model) {
	getHibernateTemplate().update(model);
    }

    @Override
    public T find(Integer id) {
	return getHibernateTemplate().get(getPersistClass(), id);
    }
    
    /**
     * 模板方法，子类实现即可具有分页查找功能
     * @return 持久化类类名
     */
    public abstract String getClassName();
    
    /**
     * 模板方法，子类实现即可具有增删查改功能
     * @return 持久化类class
     */
    public abstract Class<T> getPersistClass();
    
   

}
