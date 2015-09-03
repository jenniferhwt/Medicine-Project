package com.rippletec.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rippletec.medicine.dao.EnterpriseDao;
import com.rippletec.medicine.model.Enterprise;

/**
 * @author Liuyi
 *
 */
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)//defaultRollback true会回滚不会插入到数据库中 flase则会插入到数据库中
@Transactional
public class EnterpriseDaoTest implements IBaseDaoTest {
    
    @Resource(name=EnterpriseDao.NAME)
    private EnterpriseDao enterpriseDao;

    @Override
    @Test
    public void testSave() throws Exception {
	Enterprise enterprise = new Enterprise(1, "testSave3", "logo", "123456", "@com");
	System.out.println(enterprise);
	enterpriseDao.save(enterprise);
    }

    @Override
    @Test
    public void testDelete() throws Exception {
	enterpriseDao.delete(4);
	
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
	Enterprise enterprise = (Enterprise) enterpriseDao.find(1);
	enterprise.setName("updateName");
	enterpriseDao.update(enterprise);
    }

    @Override
    @Test
    public void testFind() throws Exception {
	System.out.println(((Enterprise)enterpriseDao.find(1)).getMedicineTypeEnterprises().size());
    }

}
