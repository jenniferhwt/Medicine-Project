/**
 * 
 */
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
import com.rippletec.medicine.dao.ChineseMedicineDao;
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
public class MedicineDaoTest implements IBaseDaoTest{
    
    	@Resource(name=MedicineDao.NAME)
	private MedicineDao medicineDao;
    	
    	@Resource(name=MedicineTypeDao.NAME)
        public MedicineTypeDao medicineTypeDao;
    	
    	@Resource(name=ChineseMedicineDao.NAME)
        private ChineseMedicineDao chineseMedicineDao;
    	
    	@Resource(name=EnterpriseMedicineTypeDao.NAME)
        private EnterpriseMedicineTypeDao enterpriseMedicineTypeDao;

	@Override
	@Test
	public void testSave() throws Exception {
	    EnterpriseMedicineType enterpriseMedicineType = enterpriseMedicineTypeDao.find(11);
	    MedicineType medicineType = medicineTypeDao.find(15);
	    Medicine medicine = new Medicine(medicineType, Medicine.CHINESE, enterpriseMedicineType, 888.0);
	    medicineDao.save(medicine);
	}
	
	@Test
	public void testSave2 () throws Exception {
	    EnterpriseMedicineType enterpriseMedicineType = enterpriseMedicineTypeDao.find(11);
	    MedicineType medicineType = medicineTypeDao.find(15);
	    ChineseMedicine chineseMedicine = new ChineseMedicine(null, "saveCheinse", "content", "efficacy", "annouce", "usage", "preparations", "store", "category");
	    Medicine medicine = new Medicine(medicineType, Medicine.CHINESE, enterpriseMedicineType, 888.0);
	    chineseMedicine.setMedicine(medicine);
	    medicine.setChineseMedicine(chineseMedicine);
	    medicineDao.save(medicine);
	}


	@Override
	@Test
	public void testDelete() throws Exception {
		medicineDao.delete(11);
	    
	}

	@Override
	@Test
	public void testUpdate() throws Exception {
	    MedicineType medicineType = new MedicineType("testMedicineType",1);
	    medicineType.setId(6);
	    Medicine medicine = new Medicine(medicineType, Medicine.CHINESE, null, 888.0);
	    medicine.setId(15);
	    medicineDao.update(medicine);
	}

	@Override
	@Test
	public void testFind() throws Exception {
	    medicineDao.find(17);
	}
	
	
	@Test
	public void testFind2() throws Exception {
	    System.out.println(medicineDao.find(1).getMedicineDocuments().toString());
	}

	@Override
	@Test
	public void testFindByPage() throws Exception {
	    List<Medicine> medicines = medicineDao.findByPage(new PageBean(0, 10));
	    for (Medicine medicine : medicines) {
		System.out.println(medicine.toString());
	    }
	}
	
}
