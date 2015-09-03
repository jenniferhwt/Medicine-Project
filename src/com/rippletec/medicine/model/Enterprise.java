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
import javax.persistence.OneToMany;
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
@Table(name = Enterprise.TABLE_NAME)
public class Enterprise extends BaseModel {

    private static final long serialVersionUID = -2404813734314317948L;
    
    public static final String CLASS_NAME = "Enterprise";
    public static final String TABLE_NAME = "enterprise";
    public static final String NAME = "name";
    public static final String LOGO = "logo";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String TYPE = "type";
    
    /**
     * 外资
     */
    public static final int FOREIGN = 1;
    /**
     * 合资
     */
    public static final int JOINT = 2;    
    /**
     * 内资
     */
    public static final int DOMESTIC = 3;

    public Enterprise() {
    }

    public Enterprise(Integer type, String name, String logo, String phone,
	    String email) {
	super();
	this.type = type;
	this.name = name;
	this.logo = logo;
	this.phone = phone;
	this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 关联企业分类表
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
    @Cascade(CascadeType.ALL)
    @OrderBy(value="id asc")
    private Set<EnterpriseMedicineType> medicineTypeEnterprises = new LinkedHashSet<EnterpriseMedicineType>();

    // 企业类型type：1表示外资，2表示合资，3表示内资
    @Column(name = "type", length = 1, nullable = false)
    private Integer type;

    // 企业名称
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    // 企业logo
    @Column(name = "logo", length = 255, nullable = false)
    private String logo;

    // 企业联系电话,可为null
    @Column(name = "phone", length = 100, nullable = true)
    private String phone;

    // 企业邮箱,可为null
    @Column(name = "email", length = 100, nullable = true)
    private String email;

    @Override
    public String toString() {
	return "Enterprise [id=" + id + ", type=" + type + ", name=" + name
		+ ", logo=" + logo + ", phone=" + phone + ", email=" + email
		+ "]";
    }

    public Integer getId() {
	return id;
    }

    public Integer getType() {
	return type;
    }

    public String getName() {
	return name;
    }

    public String getLogo() {
	return logo;
    }

    public String getPhone() {
	return phone;
    }

    public String getEmail() {
	return email;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setType(Integer type) {
	this.type = type;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setLogo(String logo) {
	this.logo = logo;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Set<EnterpriseMedicineType> getMedicineTypeEnterprises() {
	return medicineTypeEnterprises;
    }

    public void setMedicineTypeEnterprises(
	    Set<EnterpriseMedicineType> medicineTypeEnterprises) {
	this.medicineTypeEnterprises = medicineTypeEnterprises;
    }

}
