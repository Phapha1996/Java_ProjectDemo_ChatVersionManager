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
 * @spring Э������ʽ�������
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
	
	
	//���ذ汾
	/* (non-Javadoc)
	 * @see org.fage.manager.ResourceService#downLoad(org.fage.domain.Resource)
	 */
	public InputStream downLoad(Resource resource) throws FileNotFoundException{
		Resource r = resourceDao.get(resource.getId());
		return new FileInputStream(new File(r.getFileUrl()));
	}
	
	
	//���Ӱ����ϴ��Ĺ��ܣ�������Ҫ�ľֲ�������һЩ
	/* (non-Javadoc)
	 * @see org.fage.manager.ResourceService#addResource(org.fage.domain.Resource, java.lang.String, java.lang.String, java.io.File)
	 */
	public void addResource(Resource resource,String root,String fileName,File file){
		if(resource==null||fileName==null||file==null||fileName.equals("")){
			throw new RuntimeException("�벻Ҫ��������ݻ��߷Ƿ����ݣ�����");
		}
		UploadUtils.copy(file,new File(root,fileName));
		//��������·�����д洢�����ݿ�
		String fileUrl = root +"\\"+fileName;
		resource.setFileUrl(fileUrl);
		resource.setName(fileName);
		resource.setReleaseDate(new Date());
		resourceDao.add(resource);
	}
	
	
	//ɾ����¼��ͬʱ��ҲҪ���ļ����ڵ��ļ�ɾ����
	public void deleteResource(Resource resource){
		//ɾ���ļ�
		Resource r = resourceDao.get(resource.getId());
		File file = new File(r.getFileUrl());
		if(!file.exists()){
			throw new RuntimeException("��Դ�Ѿ���������");
		}
		file.delete();
		//ͬ���İ����ݿ��еļ�¼ɾ��
		resourceDao.delete(r);
	}

	//����
	public void updateResource(Resource resource){
		if(resource==null||resource.getTitle()==null||resource.getDiscription()==null||resource.getTitle().equals("")||resource.getDiscription().equals("")){
			throw new RuntimeException("�벻Ҫ��������ݻ��߷Ƿ����ݣ�����");
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
			throw new RuntimeException("��ǰ����δ�ϴ��κΰ汾");
		}
		return resources;
	}
	//�õ����°汾��
	public Resource getNew(){
		Resource r = resourceDao.getLast();
		if(r==null){
			throw new RuntimeException("��ǰ����Ա��δ�ϴ��κΰ汾�����Ժ�����");
		}
		return r;
	}
}
