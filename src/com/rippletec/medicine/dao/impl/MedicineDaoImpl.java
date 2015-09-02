/**
 * 
 */
package com.rippletec.medicine.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.MedicineDao;
import com.rippletec.medicine.model.BaseModel;
import com.rippletec.medicine.model.Medicine;
import com.rippletec.medicine.support.PlusHibernateSupport;

/**
 * @author Liuyi
 *
 */
@Repository(MedicineDao.NAME)
public class MedicineDaoImpl extends PlusHibernateSupport implements
	MedicineDao {

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
	return getHibernateTemplate().get(Medicine.class, id);
    }

}
