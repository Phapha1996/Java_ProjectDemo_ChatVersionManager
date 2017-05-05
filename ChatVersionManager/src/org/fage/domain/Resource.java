package org.fage.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="t_resource")
public class Resource {
	//版本号
	private int id;
	//版本名
	private String title;
	//文件名
	private String name;
	//访问地址
	private String fileUrl;
	//发布日期
	private Date releaseDate;
	//版本描述
	private String discription;
	
	
	public String getDiscription() {
		return discription;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
