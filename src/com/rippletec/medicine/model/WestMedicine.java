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
@Table(name = "west_medicine")
public class WestMedicine extends BaseModel {

    public static final String MEDICINE_ID = "medicine_id";
    
    private static final long serialVersionUID = 5451907990648871088L;

    public WestMedicine() {
    }

    
    public WestMedicine(Medicine medicine, String name, String other_name,
	    String content, String current_application, String pharmacolo,
	    String pk_pd, String pharmacokinetics, String warn, String aDRS,
	    String interaction, String dose_explain, String manual,
	    String adult_dose, String foreign_dose, String preparations,
	    String store) {
	super();
	this.medicine = medicine;
	this.name = name;
	this.other_name = other_name;
	this.content = content;
	this.current_application = current_application;
	this.pharmacolo = pharmacolo;
	this.pk_pd = pk_pd;
	this.pharmacokinetics = pharmacokinetics;
	this.warn = warn;
	ADRS = aDRS;
	this.interaction = interaction;
	this.dose_explain = dose_explain;
	this.manual = manual;
	this.adult_dose = adult_dose;
	this.foreign_dose = foreign_dose;
	this.preparations = preparations;
	this.store = store;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 关联药品表
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = MEDICINE_ID)
    private Medicine medicine;

    // 西药药品名称
    @Column(name = "name", length = 255, nullable = false)
    private String name;

    // 别名
    @Column(name = "other_name", columnDefinition = "TEXT", nullable = false)
    private String other_name;

    // 组成成分
    @Column(name = "content", columnDefinition = "TEXT", nullable = true)
    private String content;

    // 临床运用
    @Column(name = "current_application", columnDefinition = "TEXT", nullable = true)
    private String current_application;

    // 药理学
    @Column(name = "pharmacolo", columnDefinition = "TEXT", nullable = true)
    private String pharmacolo;

    // 药效学
    @Column(name = "pk_pd", columnDefinition = "TEXT", nullable = true)
    private String pk_pd;

    // 药动学
    @Column(name = "pharmacokinetics", columnDefinition = "TEXT", nullable = true)
    private String pharmacokinetics;

    // 注意事项
    @Column(name = "warn", columnDefinition = "TEXT", nullable = true)
    private String warn;

    // 不良反应
    @Column(name = "ADRS", columnDefinition = "TEXT", nullable = true)
    private String ADRS;

    // 药物相互作用
    @Column(name = "interaction", columnDefinition = "TEXT", nullable = true)
    private String interaction;

    // 给药说明
    @Column(name = "dose_explain", columnDefinition = "TEXT", nullable = true)
    private String dose_explain;

    // 用法用量
    @Column(name = "manual", columnDefinition = "TEXT", nullable = true)
    private String  manual;

    // 成人用量
    @Column(name = "adult_dose", columnDefinition = "TEXT", nullable = true)
    private String adult_dose;

    // 国外用法用量参考
    @Column(name = "foreign_dose", columnDefinition = "TEXT", nullable = true)
    private String foreign_dose;

    // 制剂与规格
    @Column(name = "preparations", columnDefinition = "TEXT", nullable = true)
    private String preparations;

    // 贮法
    @Column(name = "store", columnDefinition = "TEXT", nullable = true)
    private String store;

    

    @Override
    public String toString() {
	return "WestMedicine [id=" + id + ", name=" + name + ", other_name="
		+ other_name + ", content=" + content
		+ ", current_application=" + current_application
		+ ", pharmacolo=" + pharmacolo + ", pk_pd=" + pk_pd
		+ ", pharmacokinetics=" + pharmacokinetics + ", warn=" + warn
		+ ", ADRS=" + ADRS + ", interaction=" + interaction
		+ ", dose_explain=" + dose_explain + ", manual=" + manual
		+ ", adult_dose=" + adult_dose + ", foreign_dose="
		+ foreign_dose + ", preparations=" + preparations + ", store="
		+ store + "]";
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

    public String getOther_name() {
	return other_name;
    }

    public String getContent() {
	return content;
    }

    public String getCurrent_application() {
	return current_application;
    }

    public String getPharmacolo() {
	return pharmacolo;
    }

    public String getPk_pd() {
	return pk_pd;
    }

    public String getPharmacokinetics() {
	return pharmacokinetics;
    }

    public String getWarn() {
	return warn;
    }

    public String getADRS() {
	return ADRS;
    }

    public String getInteraction() {
	return interaction;
    }

    public String getDose_explain() {
	return dose_explain;
    }

    public String getAdult_dose() {
	return adult_dose;
    }

    public String getForeign_dose() {
	return foreign_dose;
    }

    public String getPreparations() {
	return preparations;
    }

    public String getStore() {
	return store;
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

    public void setOther_name(String other_name) {
	this.other_name = other_name;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setCurrent_application(String current_application) {
	this.current_application = current_application;
    }

    public void setPharmacolo(String pharmacolo) {
	this.pharmacolo = pharmacolo;
    }

    public void setPk_pd(String pk_pd) {
	this.pk_pd = pk_pd;
    }

    public void setPharmacokinetics(String pharmacokinetics) {
	this.pharmacokinetics = pharmacokinetics;
    }

    public void setWarn(String warn) {
	this.warn = warn;
    }

    public void setADRS(String aDRS) {
	ADRS = aDRS;
    }

    public void setInteraction(String interaction) {
	this.interaction = interaction;
    }

    public void setDose_explain(String dose_explain) {
	this.dose_explain = dose_explain;
    }

    public void setAdult_dose(String adult_dose) {
	this.adult_dose = adult_dose;
    }

    public void setForeign_dose(String foreign_dose) {
	this.foreign_dose = foreign_dose;
    }

    public void setPreparations(String preparations) {
	this.preparations = preparations;
    }

    public void setStore(String store) {
	this.store = store;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }
    
    

}
