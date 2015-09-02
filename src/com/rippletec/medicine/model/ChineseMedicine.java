/**
 * 
 */
package com.rippletec.medicine.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * @author Liuyi
 *
 */
@Repository
@Entity
@Table(name = "chinese_medicine")
public class ChineseMedicine extends BaseModel {

    private static final long serialVersionUID = -7463751072679829110L;

    public static final String MEDICINE_ID = "medicine_id";

    public ChineseMedicine() {
    }

    public ChineseMedicine(Medicine medicine, String name, String content,
	    String efficacy, String annouce, String preparations,
	    String manual, String store, String category) {
	super();
	this.medicine = medicine;
	this.name = name;
	this.content = content;
	this.efficacy = efficacy;
	this.annouce = annouce;
	this.preparations = preparations;
	this.manual = manual;
	this.store = store;
	this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 关联药品表
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = MEDICINE_ID)
    private Medicine medicine;

    // 中药药品名称
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    // 药物成分
    @Column(name = "content", length = 255, nullable = false)
    private String content;

    // 功效主治
    @Column(name = "efficacy", columnDefinition = "TEXT", nullable = true)
    private String efficacy;

    // 用药监护
    @Column(name = "annouce", columnDefinition = "TEXT", nullable = true)
    private String annouce;

    // 制剂规格
    @Column(name = "preparations", columnDefinition = "TEXT", nullable = true)
    private String preparations;

    // 用法用量
    @Column(name = "manual", columnDefinition = "TEXT", nullable = true)
    private String manual;

    // 贮法
    @Column(name = "store", columnDefinition = "TEXT", nullable = true)
    private String store;

    // 管理分类
    @Column(name = "category", columnDefinition = "TEXT", nullable = true)
    private String category;

    @Override
    public String toString() {
	return "ChineseMedicine [id=" + id + ", name=" + name + ", content="
		+ content + ", efficacy=" + efficacy + ", annouce=" + annouce
		+ ", preparations=" + preparations + ", manual=" + manual
		+ ", store=" + store + ", category=" + category + "]";
    }

    public Integer getId() {
	return id;
    }

    public Medicine getMedicine() {
	return medicine;
    }

    public String getName() {
	return name;
    }

    public String getContent() {
	return content;
    }

    public String getEfficacy() {
	return efficacy;
    }

    public String getAnnouce() {
	return annouce;
    }

    public String getPreparations() {
	return preparations;
    }

    public String getStore() {
	return store;
    }

    public String getCategory() {
	return category;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setMedicine(Medicine medicine) {
	this.medicine = medicine;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setEfficacy(String efficacy) {
	this.efficacy = efficacy;
    }

    public void setAnnouce(String annouce) {
	this.annouce = annouce;
    }

    public void setPreparations(String preparations) {
	this.preparations = preparations;
    }

    public void setStore(String store) {
	this.store = store;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getManual() {
	return manual;
    }

    public void setManual(String manual) {
	this.manual = manual;
    }

}
