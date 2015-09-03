/**
 * 
 */
package com.rippletec.medicine.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * @author Liuyi
 *
 */
@Repository
@Entity
@Table(name = "medicine_type")
public class MedicineType extends BaseModel {
    
    public static final String CLASS_NAME = "MedicineType";
    public static final String PARENT_TYPE_ID = "parent_type_id";

    // 最顶级分类的父类别id为-1
    public static final int DEFAULT_PARENT_ID = -1;

    private static final long serialVersionUID = -521600701786316983L;

    public MedicineType() {
    }

    public MedicineType(String name, Integer parent_type_id) {
	super();
	this.name = name;
	this.parent_type_id = parent_type_id;
    }

    public MedicineType(String name, MedicineType parent_type) {
	super();
	this.name = name;
	this.parent_type_id = parent_type.getId();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="medicineType")
    @OrderBy(value="id asc")
    private Set<Medicine> medicines = new LinkedHashSet<Medicine>();

    // 分类名称
    @Column(name = "name", length = 255, nullable = false)
    private String name;

    // 父类别id
    @Column(name = PARENT_TYPE_ID, nullable = false)
    private Integer parent_type_id;

    @Override
    public String toString() {
	return "MedicineType [id=" + id + ", name=" + name
		+ ", parent_type_id=" + parent_type_id + "]";
    }

    public Integer getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public Integer getParent_type_id() {
	return parent_type_id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setParent_type_id(Integer parent_type_id) {
	this.parent_type_id = parent_type_id;
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Set<Medicine> medicines) {
        this.medicines = medicines;
    }
    
}
