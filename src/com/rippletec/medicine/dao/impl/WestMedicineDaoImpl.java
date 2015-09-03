package com.rippletec.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.WestMedicineDao;
import com.rippletec.medicine.model.WestMedicine;

@Repository(WestMedicineDao.NAME)
public class WestMedicineDaoImpl extends BaseDaoImpl<WestMedicine> implements
	WestMedicineDao {

    @Override
    public String getClassName() {
	return WestMedicine.CLASS_NAME;
    }

    @Override
    public Class<WestMedicine> getPersistClass() {
	return WestMedicine.class;
    }
   

}
