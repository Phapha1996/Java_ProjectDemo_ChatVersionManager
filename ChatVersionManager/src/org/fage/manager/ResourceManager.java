package org.fage.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.fage.dao.ResourceDao;
import org.fage.domain.Resource;
import org.fage.service.ResourceService;
import org.fage.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
/**
 * @author fage
 */
/* @support IntelliJ
 * @date 2017-01-06
 * @spring 协助声明式事务管理
 */
@Service
public class ResourceManager implements ResourceService {
	private ResourceDao resourceDao;

	public ResourceDao getResourceDao() {
		return resourceDao;
	}
	@Required
	@javax.annotation.Resource(name="resourceDaoImpl")
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	
	//下载版本
	/* (non-Javadoc)
	 * @see org.fage.manager.ResourceService#downLoad(org.fage.domain.Resource)
	 */
	public InputStream downLoad(Resource resource) throws FileNotFoundException{
		Resource r = resourceDao.get(resource.getId());
		return new FileInputStream(new File(r.getFileUrl()));
	}
	
	
	//增加包括上传的功能，所以需要的局部变量多一些
	/* (non-Javadoc)
	 * @see org.fage.manager.ResourceService#addResource(org.fage.domain.Resource, java.lang.String, java.lang.String, java.io.File)
	 */
	public void addResource(Resource resource,String root,String fileName,File file){
		if(resource==null||fileName==null||file==null||fileName.equals("")){
			throw new RuntimeException("请不要传入空数据或者非法数据！！！");
		}
		UploadUtils.copy(file,new File(root,fileName));
		//构造完整路径进行存储进数据库
		String fileUrl = root +"\\"+fileName;
		resource.setFileUrl(fileUrl);
		resource.setName(fileName);
		resource.setReleaseDate(new Date());
		resourceDao.add(resource);
	}
	
	
	//删除记录的同时，也要把文件夹内的文件删除掉
	public void deleteResource(Resource resource){
		//删除文件
		Resource r = resourceDao.get(resource.getId());
		File file = new File(r.getFileUrl());
		if(!file.exists()){
			throw new RuntimeException("资源已经不存在了");
		}
		file.delete();
		//同步的把数据库中的记录删除
		resourceDao.delete(r);
	}

	//更新
	public void updateResource(Resource resource){
		if(resource==null||resource.getTitle()==null||resource.getDiscription()==null||resource.getTitle().equals("")||resource.getDiscription().equals("")){
			throw new RuntimeException("请不要传入空数据或者非法数据！！！");
		}
		Resource r = resourceDao.get(resource.getId());
		r.setTitle(resource.getTitle());
		r.setReleaseDate(new Date());
		r.setDiscription(resource.getDiscription());
	}
	
	
	public Resource getFromId(int resourceId){
		return resourceDao.get(resourceId);
	}
	
	
	public Resource getFromName(String resourceName){
		return resourceDao.get(resourceName);
	}
	
	public List<Resource> getAllResource(){
		List <Resource> resources = resourceDao.getAll();
		if(resources==null||resources.size()==0){
			throw new RuntimeException("当前您还未上传任何版本");
		}
		return resources;
	}
	//得到最新版本的
	public Resource getNew(){
		Resource r = resourceDao.getLast();
		if(r==null){
			throw new RuntimeException("当前管理员还未上传任何版本，请稍后再试");
		}
		return r;
	}
}
