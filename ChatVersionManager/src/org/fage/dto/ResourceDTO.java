package org.fage.dto;

import java.util.Date;

import org.fage.domain.Resource;

public class ResourceDTO {
	private int id;
	//版本名
	private String title;
	//文件名
	private String fileName;
	//安卓端访问地址
	private String androidUrl;
	//发布日期
	private Date releaseDate;
	//版本描述
	private String discription;
	
	public ResourceDTO(int id, String title, String fileName,
			String androidUrl, Date releaseDate, String discription) {
		super();
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.androidUrl = androidUrl;
		this.releaseDate = releaseDate;
		this.discription = discription;
	}
	public ResourceDTO(){
		
	}
	public ResourceDTO(Resource resource,String url){
		this.id = resource.getId();
		this.title = resource.getTitle();
		this.fileName = resource.getName();
		this.androidUrl = url;
		this.releaseDate = resource.getReleaseDate();
		this.discription = resource.getDiscription();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAndroidUrl() {
		return androidUrl;
	}
	public void setAndroidUrl(String androidUrl) {
		this.androidUrl = androidUrl;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	
}
