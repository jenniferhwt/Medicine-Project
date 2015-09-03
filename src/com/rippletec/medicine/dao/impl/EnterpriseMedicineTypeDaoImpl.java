package com.rippletec.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.EnterpriseMedicineTypeDao;
import com.rippletec.medicine.model.EnterpriseMedicineType;

/**
 * @author Liuyi
 *
 */
@Repository(EnterpriseMedicineTypeDao.NAME)
public class EnterpriseMedicineTypeDaoImpl extends BaseDaoImpl<EnterpriseMedicineType>
	implements EnterpriseMedicineTypeDao {

    @Override
    public String getClassName() {
	return EnterpriseMedicineType.CLASS_NAME;
    }

    @Override
    public Class<EnterpriseMedicineType> getPersistClass() {
	return EnterpriseMedicineType.class;
    }

   
}
