package com.rippletec.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.ChineseMedicineDao;
import com.rippletec.medicine.model.ChineseMedicine;


@Repository(ChineseMedicineDao.NAME)
public class ChineseMedicineDaoImpl extends BaseDaoImpl<ChineseMedicine> implements
	ChineseMedicineDao {

    @Override
    public String getClassName() {
	return ChineseMedicine.CLASS_NAME;
    }

    @Override
    public Class<ChineseMedicine> getPersistClass() {
	return ChineseMedicine.class;
    }
    
}
