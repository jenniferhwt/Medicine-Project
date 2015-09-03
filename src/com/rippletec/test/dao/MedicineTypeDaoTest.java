package com.rippletec.test.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rippletec.medicine.bean.PageBean;
import com.rippletec.medicine.dao.MedicineTypeDao;
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
public class MedicineTypeDaoTest implements IBaseDaoTest {
    
    @Resource(name="MedicineTypeDao")
    public MedicineTypeDao medicineTypeDao;

    @Override
    @Test
    public void testSave() throws Exception {
	MedicineType medicineType = new MedicineType("savetest", MedicineType.DEFAULT_PARENT_ID);
	medicineTypeDao.save(medicineType);
    }

    @Override
    @Test
    public void testDelete() throws Exception {
	medicineTypeDao.delete(1);
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
	MedicineType medicineType = medicineTypeDao.find(6);
	medicineType.setParent_type_id(3);
	medicineTypeDao.update(medicineType);
    }

    @Override
    @Test
    public void testFind() throws Exception {
	System.out.println(medicineTypeDao.find(6).toString());
    }
    
    @Test
    public void testFind2() throws Exception {
	MedicineType medicineType = medicineTypeDao.find(15);
	Iterator<Medicine> iterator = medicineType.getMedicines().iterator();
	while (iterator.hasNext()) {
	    Medicine medicine = iterator.next();
	    System.out.println(medicine.getChineseOrWest().toString());
	}
    }

    @Override
    @Test
    public void testFindByPage() throws Exception {
	List<MedicineType> medicineTypes = medicineTypeDao.findByPage(new PageBean(0, 10));
	for (MedicineType medicineType : medicineTypes) {
	    System.out.println(medicineType.toString());
	}
    }

}
