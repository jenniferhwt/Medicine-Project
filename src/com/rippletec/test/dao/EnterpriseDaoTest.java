package com.rippletec.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rippletec.medicine.bean.PageBean;
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
	Enterprise enterprise = new Enterprise(2, "testSave4", "logo", "123456", "@com");
	System.out.println(enterprise);
	enterpriseDao.save(enterprise);
    }

    @Override
    @Test
    public void testDelete() throws Exception {
	enterpriseDao.delete(3);
	
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
	Enterprise enterprise = enterpriseDao.find(1);
	enterprise.setName("updateName2");
	enterpriseDao.update(enterprise);
    }

    @Override
    @Test
    public void testFind() throws Exception {
	System.out.println(enterpriseDao.find(10).getName());
	System.out.println(enterpriseDao.find(1).getMedicineTypeEnterprises().size());
    }
    
    @Override
    @Test
    public void testFindByPage() throws Exception {
	List<Enterprise> enterprises  = enterpriseDao.findByPage(Enterprise.TYPE, 1 , new PageBean(0, 10));
	for (Enterprise enterprise : enterprises) {
	    System.out.println(enterprise.toString());
	}
    }
    
    @Test
    public void testFindByPage2() throws Exception {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put(Enterprise.TYPE, 1);
	map.put(Enterprise.EMAIL, "@com");
	List<Enterprise> enterprises  = enterpriseDao.findByPage(map,new PageBean(0, 10));
	for (Enterprise enterprise : enterprises) {
	    System.out.println(enterprise.toString());
	}
    }

}
