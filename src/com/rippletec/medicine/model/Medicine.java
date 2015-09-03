/**
 * 
 */
package com.rippletec.medicine.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Repository;

/**
 * @author Liuyi
 *
 */
@Repository
@Entity
@Table(name = "medicine")
public class Medicine extends BaseModel {

    private static final long serialVersionUID = 6854826662685735308L;

    public static final String CLASS_NAME = "Medicine";
    public static final String MEDICINE_TYPE_ID = "medicine_type_id";
    public static final String ENTER_MEDICINE_TYPE_ID = "enter_medicine_type_id";
    public static final String CHINESE_MEDICINE_ID = "chinese_medicine_id";
    public static final String WEST_MEDICINE_ID = "west_medicine_id";
    public static final int CHINESE = 1;
    public static final int WEST = 2;

    public Medicine() {
    }

    
    /**
     * 基本构造方法
     * @param medicineType
     * @param gib_type
     * @param enterpriseMedicineType
     * @param price
     */
    public Medicine(MedicineType medicineType, Integer gib_type,
	    EnterpriseMedicineType enterpriseMedicineType, Double price) {
	super();
	this.medicineType = medicineType;
	this.gib_type = gib_type;
	this.enterpriseMedicineType = enterpriseMedicineType;
	this.price = price;
    }
    /**
     * 西药构造方法
     * @param medicineType
     * @param westMedicine
     * @param medicineDocuments
     * @param gib_type
     * @param enterpriseMedicineType
     * @param price
     */
    public Medicine(MedicineType medicineType, WestMedicine westMedicine,
	    Set<MedicineDocument> medicineDocuments, Integer gib_type,
	    EnterpriseMedicineType enterpriseMedicineType, Double price) {
	super();
	this.medicineType = medicineType;
	this.westMedicine = westMedicine;
	this.medicineDocuments = medicineDocuments;
	this.gib_type = gib_type;
	this.enterpriseMedicineType = enterpriseMedicineType;
	this.price = price;
    }
    /**
     * 中药构造方法
     * @param medicineType
     * @param chineseMedicine
     * @param medicineDocuments
     * @param gib_type
     * @param enterpriseMedicineType
     * @param price
     */
    public Medicine(MedicineType medicineType, ChineseMedicine chineseMedicine,
	    Set<MedicineDocument> medicineDocuments, Integer gib_type,
	    EnterpriseMedicineType enterpriseMedicineType, Double price) {
	super();
	this.medicineType = medicineType;
	this.chineseMedicine = chineseMedicine;
	this.medicineDocuments = medicineDocuments;
	this.gib_type = gib_type;
	this.enterpriseMedicineType = enterpriseMedicineType;
	this.price = price;
    }



    // 药品Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 关联所属类别
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = MEDICINE_TYPE_ID)
    private MedicineType medicineType;
    
    // 中药
    //！！请getChineseOrWest()方法获取
    @OneToOne(fetch=FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name=CHINESE_MEDICINE_ID)
    private ChineseMedicine chineseMedicine;
    
    // 西药
    //！！请getChineseOrWest()方法获取
    @OneToOne(fetch=FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name=WEST_MEDICINE_ID)
    private WestMedicine westMedicine;

    // 关联药物文章
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicine")
    @Cascade(CascadeType.ALL)
    @OrderBy(value="id asc")
    private Set<MedicineDocument> medicineDocuments = new LinkedHashSet<MedicineDocument>();

    // 药品所属第一级类型：1=中药，2=西药
    @Column(name = "gib_type", length = 1, nullable = false)
    private Integer gib_type;

    // 药品所属企业药品分类id
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = ENTER_MEDICINE_TYPE_ID)
    private EnterpriseMedicineType enterpriseMedicineType;

    // 药品价格
    @Column(name = "price", length = 10, nullable = false, precision = 2)
    private Double price;

    

    @Override
    public String toString() {
	return "Medicine [id=" + id + ", medicineType=" + medicineType
		+ ", medicineDocuments=" + medicineDocuments + ", gib_type="
		+ gib_type + ", enterpriseMedicineType="
		+ enterpriseMedicineType + ", price=" + price + "]";
    }
    
    public BaseModel getChineseOrWest(){
	return gib_type == 1 ? getChineseMedicine() : getWestMedicine();
    }

    public Integer getId() {
	return id;
    }

    public MedicineType getMedicineType() {
	return medicineType;
    }

    public Integer getGib_type() {
	return gib_type;
    }

    public Double getPrice() {
	return price;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setMedicineType(MedicineType medicineType) {
	this.medicineType = medicineType;
    }

    public void setGib_type(Integer gib_type) {
	this.gib_type = gib_type;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

    public Set<MedicineDocument> getMedicineDocuments() {
	return medicineDocuments;
    }

    public void setMedicineDocuments(Set<MedicineDocument> medicineDocuments) {
	this.medicineDocuments = medicineDocuments;
    }

    public EnterpriseMedicineType getEnterpriseMedicineType() {
        return enterpriseMedicineType;
    }

    public void setEnterpriseMedicineType(
    	EnterpriseMedicineType enterpriseMedicineType) {
        this.enterpriseMedicineType = enterpriseMedicineType;
    }

    public ChineseMedicine getChineseMedicine() {
        return chineseMedicine;
    }

    public WestMedicine getWestMedicine() {
        return westMedicine;
    }

    public void setChineseMedicine(ChineseMedicine chineseMedicine) {
        this.chineseMedicine = chineseMedicine;
    }

    public void setWestMedicine(WestMedicine westMedicine) {
        this.westMedicine = westMedicine;
    }

 
    
    
    

}
