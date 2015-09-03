package com.rippletec.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.MedicineTypeDao;
import com.rippletec.medicine.model.MedicineType;

@Repository(MedicineTypeDao.NAME)
public class MedicineTypeDaoImpl extends BaseDaoImpl<MedicineType> implements MedicineTypeDao {

    @Override
    public String getClassName() {
	return MedicineType.CLASS_NAME;
    }

    @Override
    public Class<MedicineType> getPersistClass() {
	return MedicineType.class;
    }
    
    

}
