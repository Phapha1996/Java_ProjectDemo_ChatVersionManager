package org.fage.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.fage.domain.Resource;

public interface ResourceService {

	//下载版本
	public InputStream downLoad(Resource resource) throws FileNotFoundException;

	//增加包括上传的功能，所以需要的局部变量多一些
	public void addResource(Resource resource, String root, String fileName,
			File file);

	public void deleteResource(Resource resource);
	
	public void updateResource(Resource resource);

	public Resource getFromId(int resourceId);

	public Resource getFromName(String resourceName);

	public List<Resource> getAllResource();
	
	public Resource getNew();

}