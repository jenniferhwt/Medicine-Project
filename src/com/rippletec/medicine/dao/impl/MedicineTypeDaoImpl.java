package com.rippletec.medicine.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.MedicineTypeDao;
import com.rippletec.medicine.model.BaseModel;
import com.rippletec.medicine.model.MedicineType;
import com.rippletec.medicine.support.PlusHibernateSupport;

@Repository(MedicineTypeDao.NAME)
public class MedicineTypeDaoImpl extends PlusHibernateSupport implements MedicineTypeDao {
    
    @Resource
    public void _setSessionFactory(SessionFactory sessionFactory) {
	super.setSessionFactory(sessionFactory);
    }

    @Override
    public Integer save(BaseModel model) {
	return (Integer) getHibernateTemplate().save(model);
    }

    @Override
    public void delete(Integer id) {
	getHibernateTemplate().delete(find(id));
    }

    @Override
    public void update(BaseModel model) {
	getHibernateTemplate().update(model);
    }

    @Override
    public BaseModel find(Integer id) {
	return getHibernateTemplate().get(MedicineType.class, id);
    }

}
