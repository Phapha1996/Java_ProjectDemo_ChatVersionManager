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
 * ��Ҫ���ϴ����ص�����
 * @author fage
 * @support IntelliJ
 * @date 2017-01-06
 * @Discription MVC���
 */
@Controller
@Scope("prototype")
public class ResourceAction extends ActionSupport{
	private ResourceService resourceService;
	private Resource resource;
	private Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	//�ϴ�����
	private File version;
	private String versionFileName;
	private String versionContentType;
	//��̬·������
	private String uploadSaveDir;
	//json��׿����
	private String json;
	
	@Required
	@javax.annotation.Resource(name="resourceManager")
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	//����
	@JSON(serialize=false)//����json��Ҫ����getxxx����
	public InputStream getDownLoad(){
		try {
			return resourceService.downLoad(resource);
		} catch (FileNotFoundException e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	//�������еİ汾
	public String list() throws Exception{
		request.put("allResource", resourceService.getAllResource());
		return "success";
	}
	//���Ӱ汾
	public String add()throws Exception{
		String root = ServletActionContext.getServletContext().getRealPath(uploadSaveDir);
		resourceService.addResource(resource,root,versionFileName,version);
		return "page";
	}
	//���ӵĽ���
	public String addui()throws Exception{
		return "success";
	}
	//ɾ���汾����������ɾ�˼�¼ͬʱҲҪɾ���ļ�
	public String delete()throws Exception{
		resourceService.deleteResource(resource);
		return "page";
	}
	//���½���
	public String updateui()throws Exception{
		request.put("resource",resourceService.getFromId(resource.getId()));
		return "success";
	}
	//����
	public String update()throws Exception{
		resourceService.updateResource(resource);
		return "page";
	}
	
	//��ʾ��ϸ��Ϣ
	public String show() throws Exception{
		resource = resourceService.getFromId(resource.getId());
		String url = ServletActionContext.getRequest().getRequestURL().toString()+"?resource.id="+resource.getId()+"&&resource.name="+resource.getName();
		request.put("url",url.replaceAll("resource_show", "download"));
		request.put("resource",resource);
		
		return "success";
	}
	//����
	public String download()throws Exception{
		String url = ServletActionContext.getRequest().getRequestURL().toString()+"?resource.id="+resource.getId()+"&&resource.name="+resource.getName();
		request.put("url",url);
		return "success";
	}
	//����json���ذ�׿��
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
