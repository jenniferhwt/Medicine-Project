package com.rippletec.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.rippletec.medicine.dao.EnterpriseDao;
import com.rippletec.medicine.model.Enterprise;

/**
 * @author Liuyi
 *
 */
@Repository(EnterpriseDao.NAME)
public class EnterpriseDaoImpl extends BaseDaoImpl<Enterprise> implements
	EnterpriseDao {

    @Override
    public String getClassName() {
	return Enterprise.CLASS_NAME;
    }

    @Override
    public Class<Enterprise> getPersistClass() {
	return Enterprise.class;
    }

}
