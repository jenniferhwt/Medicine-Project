/**
 * 
 */
package com.rippletec.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.MedicineDao;
import com.rippletec.medicine.model.Medicine;

/**
 * @author Liuyi
 *
 */
@Repository(MedicineDao.NAME)
public class MedicineDaoImpl extends BaseDaoImpl<Medicine> implements
	MedicineDao {

    @Override
    public String getClassName() {
	return Medicine.CLASS_NAME;
    }

    @Override
    public Class<Medicine> getPersistClass() {
	return Medicine.class;
    }
}
