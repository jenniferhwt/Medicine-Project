package com.rippletec.medicine.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.MedicineDocumentDao;
import com.rippletec.medicine.model.BaseModel;
import com.rippletec.medicine.model.MedicineDocument;
import com.rippletec.medicine.support.PlusHibernateSupport;

/**
 * @author Liuyi
 *
 */
@Repository(MedicineDocumentDao.NAME)
public class MedicineDocumentDaoImpl extends PlusHibernateSupport implements
	MedicineDocumentDao {
    
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
	return getHibernateTemplate().get(MedicineDocument.class, id);
    }

}
