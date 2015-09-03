/**
 * 
 */
package com.rippletec.medicine.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "medicine_document")
public class MedicineDocument extends BaseModel {

    public static final String CLASS_NAME = "MedicineDocument";
    public static final String MEDICINE_ID = "medicine_id";
    private static final long serialVersionUID = 1344487290503116724L;

    public MedicineDocument() {

    }

    public MedicineDocument(Medicine medicine, Integer type, String title,
	    String content, String author, Date date) {
	super();
	this.medicine = medicine;
	this.type = type;
	this.title = title;
	this.content = content;
	this.author = author;
	this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 文章所关联的药物
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = MEDICINE_ID)
    private Medicine medicine;

    // 药品文章类型
    @Column(name = "type", length = 1, nullable = false)
    private Integer type;

    // 药品文章标题
    @Column(name = "title", length = 255, nullable = false)
    private String title;

    // 药品文章内容
    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    // 药品文章作者
    @Column(name = "author", length = 100, nullable = false)
    private String author;

    // 药品文章发布日期
    @Column(name = "date", columnDefinition = "DATE", nullable = false)
    private Date date;

    

    @Override
    public String toString() {
	return "MedicineDocument [id=" + id + ", type=" + type + ", title="
		+ title + ", content=" + content + ", author=" + author
		+ ", date=" + date + "]";
    }

    public Integer getId() {
	return id;
    }

    public Medicine getMedicine() {
	return medicine;
    }

    public Integer getType() {
	return type;
    }

    public String getTitle() {
	return title;
    }

    public String getContent() {
	return content;
    }

    public String getAuthor() {
	return author;
    }

    public Date getDate() {
	return date;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setMedicine(Medicine medicine) {
	this.medicine = medicine;
    }

    public void setType(Integer type) {
	this.type = type;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public void setDate(Date date) {
	this.date = date;
    }

}
