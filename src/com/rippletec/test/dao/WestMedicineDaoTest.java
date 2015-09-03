package com.rippletec.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rippletec.medicine.bean.PageBean;
import com.rippletec.medicine.dao.MedicineDao;
import com.rippletec.medicine.dao.WestMedicineDao;
import com.rippletec.medicine.model.Medicine;
import com.rippletec.medicine.model.WestMedicine;

/**
 * @author Liuyi
 *
 */
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)//defaultRollback true会回滚不会插入到数据库中 flase则会插入到数据库中
@Transactional
public class WestMedicineDaoTest implements IBaseDaoTest {
    
    @Resource(name=WestMedicineDao.NAME)
    private WestMedicineDao westMedicineDao;
    
    @Resource(name=MedicineDao.NAME)
	private MedicineDao medicineDao;

    @Override
    @Test
    public void testSave() throws Exception {
	Medicine medicine = medicineDao.find(11);
	WestMedicine westMedicine = new WestMedicine(medicine, "west", "west", "west", "west", "west", "west", "west", "west", "west", "west", "west", "west", "west", "west", "west", "west");
	System.out.println(westMedicine.toString());
	westMedicineDao.save(westMedicine);
	
    }

    @Override
    @Test
    public void testDelete() throws Exception {
	westMedicineDao.delete(2);
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
    }

    @Override
    @Test
    public void testFind() throws Exception {
	WestMedicine westMedicine = westMedicineDao.find(1);
	System.out.println(westMedicine.toString());
	System.out.println(westMedicine.getMedicine().toString());
    }

    @Override
    @Test
    public void testFindByPage() throws Exception {
	List<WestMedicine> westMedicines  = westMedicineDao.findByPage(new PageBean(0, 10));
	for (WestMedicine westMedicine : westMedicines) {
	    System.out.println(westMedicine.toString());
	}
    }

}
