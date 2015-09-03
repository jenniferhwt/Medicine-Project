package com.rippletec.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.MedicineDocumentDao;
import com.rippletec.medicine.model.MedicineDocument;

/**
 * @author Liuyi
 *
 */
@Repository(MedicineDocumentDao.NAME)
public class MedicineDocumentDaoImpl extends BaseDaoImpl<MedicineDocument> implements
	MedicineDocumentDao {

    @Override
    public String getClassName() {
	return MedicineDocument.CLASS_NAME;
    }

    @Override
    public Class<MedicineDocument> getPersistClass() {
	return MedicineDocument.class;
    }
    
    

}
