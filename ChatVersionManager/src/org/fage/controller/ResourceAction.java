package org.fage.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.fage.domain.Resource;
import org.fage.dto.ResourceDTO;
import org.fage.service.ResourceService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 主要是上传下载等内容
 * @author fage
 * @support IntelliJ
 * @date 2017-01-06
 * @Discription MVC层次
 */
@Controller
@Scope("prototype")
public class ResourceAction extends ActionSupport{
	private ResourceService resourceService;
	private Resource resource;
	private Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	//上传属性
	private File version;
	private String versionFileName;
	private String versionContentType;
	//动态路径设置
	private String uploadSaveDir;
	//json安卓数据
	private String json;
	
	@Required
	@javax.annotation.Resource(name="resourceManager")
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	//下载
	@JSON(serialize=false)//告诉json不要解析getxxx方法
	public InputStream getDownLoad(){
		try {
			return resourceService.downLoad(resource);
		} catch (FileNotFoundException e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	//返回所有的版本
	public String list() throws Exception{
		request.put("allResource", resourceService.getAllResource());
		return "success";
	}
	//增加版本
	public String add()throws Exception{
		String root = ServletActionContext.getServletContext().getRealPath(uploadSaveDir);
		resourceService.addResource(resource,root,versionFileName,version);
		return "page";
	}
	//增加的界面
	public String addui()throws Exception{
		return "success";
	}
	//删除版本附带级联，删了记录同时也要删除文件
	public String delete()throws Exception{
		resourceService.deleteResource(resource);
		return "page";
	}
	//更新界面
	public String updateui()throws Exception{
		request.put("resource",resourceService.getFromId(resource.getId()));
		return "success";
	}
	//更新
	public String update()throws Exception{
		resourceService.updateResource(resource);
		return "page";
	}
	
	//显示详细信息
	public String show() throws Exception{
		resource = resourceService.getFromId(resource.getId());
		String url = ServletActionContext.getRequest().getRequestURL().toString()+"?resource.id="+resource.getId()+"&&resource.name="+resource.getName();
		request.put("url",url.replaceAll("resource_show", "download"));
		request.put("resource",resource);
		
		return "success";
	}
	//下载
	public String download()throws Exception{
		String url = ServletActionContext.getRequest().getRequestURL().toString()+"?resource.id="+resource.getId()+"&&resource.name="+resource.getName();
		request.put("url",url);
		return "success";
	}
	//解析json返回安卓端
	public String androidJson() throws Exception{
		Resource r = resourceService.getNew();
		String url = ServletActionContext.getRequest().getRequestURL().toString()+"?resource.id="+r.getId()+"&&resource.name="+r.getName();
		ResourceDTO dto = new ResourceDTO(r,url.replaceAll("android/json", "download"));
		JSONObject jsonObject = JSONObject.fromObject(dto);
		json = jsonObject.toString();
		return "success";
	}
	
	@JSON(serialize=false)
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	@JSON(serialize=false)
	public File getVersion() {
		return version;
	}
	public void setVersion(File version) {
		this.version = version;
	}
	@JSON(serialize=false)
	public String getVersionFileName() {
		return versionFileName;
	}
	public void setVersionFileName(String versionFileName) {
		this.versionFileName = versionFileName;
	}
	@JSON(serialize=false)
	public String getVersionContentType() {
		return versionContentType;
	}
	public void setVersionContentType(String versionContentType) {
		this.versionContentType = versionContentType;
	}
	@JSON(serialize=false)
	public String getUploadSaveDir() {
		return uploadSaveDir;
	}
	public void setUploadSaveDir(String uploadSaveDir) {
		this.uploadSaveDir = uploadSaveDir;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
}
