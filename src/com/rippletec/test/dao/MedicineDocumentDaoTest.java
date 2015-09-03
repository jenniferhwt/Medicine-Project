package com.rippletec.test.dao;

import java.util.Date;
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
import com.rippletec.medicine.dao.MedicineDocumentDao;
import com.rippletec.medicine.model.Medicine;
import com.rippletec.medicine.model.MedicineDocument;

/**
 * @author Liuyi
 *
 */
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)//defaultRollback true会回滚不会插入到数据库中 flase则会插入到数据库中
@Transactional
public class MedicineDocumentDaoTest implements IBaseDaoTest {
    
    @Resource(name=MedicineDocumentDao.NAME)
    private MedicineDocumentDao medicineDocumentDao;
    
    @Resource(name=MedicineDao.NAME)
    private MedicineDao medicineDao;

    @Override
    @Test
    public void testSave() throws Exception {
	Medicine medicine = medicineDao.find(17);
	MedicineDocument medicineDocument = new MedicineDocument(medicine, 1, "title", "content", "author", new Date());
	medicineDocumentDao.save(medicineDocument);
    }

    @Override
    @Test
    public void testDelete() throws Exception {
	medicineDocumentDao.delete(1);
    }

    @Override
    @Test
    public void testUpdate() throws Exception {
	MedicineDocument medicineDocument = medicineDocumentDao.find(2);
	medicineDocument.setTitle("updatetitie");
	medicineDocumentDao.update(medicineDocument);
    }

    @Override
    @Test
    public void testFind() throws Exception {
	System.out.println(medicineDocumentDao.find(1).toString());
    }

    @Override
    @Test
    public void testFindByPage() throws Exception {
	List<MedicineDocument> medicineDocuments = medicineDocumentDao.findByPage(new PageBean(0, 10));
	for (MedicineDocument medicineDocument : medicineDocuments) {
	    System.out.println(medicineDocument.toString());
	}
    }
    

   

}
