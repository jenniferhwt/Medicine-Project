package com.rippletec.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rippletec.medicine.dao.EnterpriseDao;
import com.rippletec.medicine.dao.EnterpriseMedicineTypeDao;
import com.rippletec.medicine.model.Enterprise;
import com.rippletec.medicine.model.EnterpriseMedicineType;
import com.rippletec.medicine.model.Medicine;

/**
 * @author Liuyi
 *
 */
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)//defaultRollback true会回滚不会插入到数据库中 flase则会插入到数据库中
@Transactional
public class EnterpriseMedicineTypeDaoTest implements IBaseDaoTest {
    
    @Resource(name=EnterpriseMedicineTypeDao.NAME)
    private EnterpriseMedicineTypeDao enterpriseMedicineTypeDao;
    @Resource(name=EnterpriseDao.NAME)
    private EnterpriseDao enterpriseDao;


    @Override
    @Test
    public void testSave() throws Exception {
	Enterprise enterprise = (Enterprise) enterpriseDao.find(1);
	EnterpriseMedicineType enterpriseMedicineType = new EnterpriseMedicineType("saveType", enterprise);
	enterpriseMedicineTypeDao.save(enterpriseMedicineType);
    }

    @Override
    @Test
    public void testDelete() throws Exception {
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
    }

    @Override
    @Test
    public void testFind() throws Exception {
	EnterpriseMedicineType enterpriseMedicineType = (EnterpriseMedicineType)enterpriseMedicineTypeDao.find(13);
//	System.out.println(enterpriseMedicineType.toString());
//	System.out.println(enterpriseMedicineType.getEnterprise().toString());
	Medicine medicine = (Medicine) enterpriseMedicineType.getMedicines().iterator().next();
	System.out.println(medicine.getChineseOrWest().toString());
	
    }

}
