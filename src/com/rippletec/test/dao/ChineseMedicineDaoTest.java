package com.rippletec.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rippletec.medicine.dao.ChineseMedicineDao;
import com.rippletec.medicine.dao.EnterpriseDao;
import com.rippletec.medicine.dao.EnterpriseMedicineTypeDao;
import com.rippletec.medicine.dao.MedicineDao;
import com.rippletec.medicine.dao.MedicineTypeDao;
import com.rippletec.medicine.model.ChineseMedicine;
import com.rippletec.medicine.model.EnterpriseMedicineType;
import com.rippletec.medicine.model.Medicine;
import com.rippletec.medicine.model.MedicineType;


/**
 * @author Liuyi
 *
 */
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)//defaultRollback true会回滚不会插入到数据库中 flase则会插入到数据库中
@Transactional
public class ChineseMedicineDaoTest implements IBaseDaoTest {
    
    @Resource(name=ChineseMedicineDao.NAME)
    private ChineseMedicineDao chineseMedicineDao;
    @Resource(name=MedicineTypeDao.NAME)
    private MedicineTypeDao medicineTypeDao;
    @Resource(name=EnterpriseMedicineTypeDao.NAME)
    private EnterpriseMedicineTypeDao enterpriseMedicineTypeDao;
    @Resource(name=EnterpriseDao.NAME)
    private EnterpriseDao enterpriseDao;
    @Resource(name=MedicineDao.NAME)
	private MedicineDao medicineDao;
    
    @Override
    @Test
    public void testSave() throws Exception {
	MedicineType medicineType = new MedicineType("testmedicinesave",MedicineType.DEFAULT_PARENT_ID );
	EnterpriseMedicineType enterpriseMedicineType = (EnterpriseMedicineType) enterpriseMedicineTypeDao.find(13);
	Medicine medicine = new Medicine(medicineType, Medicine.CHINESE, enterpriseMedicineType, 888.0);
	ChineseMedicine chineseMedicine = new ChineseMedicine(medicine, "saveCheinse", "content", "efficacy", "annouce", "usage", "preparations", "store", "category");
	chineseMedicineDao.save(chineseMedicine);
    }

    @Override
    @Test
    public void testDelete() throws Exception {
	chineseMedicineDao.delete(3);
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
    }

    @Override
    @Test
    public void testFind() throws Exception {
	ChineseMedicine chineseMedicine = (ChineseMedicine) chineseMedicineDao.find(9);
	System.out.println(chineseMedicine.toString());
	System.out.println(chineseMedicine.getMedicine().toString());
    }

}
