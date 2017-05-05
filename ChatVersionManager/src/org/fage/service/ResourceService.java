package org.fage.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.fage.domain.Resource;

public interface ResourceService {

	//���ذ汾
	public InputStream downLoad(Resource resource) throws FileNotFoundException;

	//���Ӱ����ϴ��Ĺ��ܣ�������Ҫ�ľֲ�������һЩ
	public void addResource(Resource resource, String root, String fileName,
			File file);

	public void deleteResource(Resource resource);
	
	public void updateResource(Resource resource);

	public Resource getFromId(int resourceId);

	public Resource getFromName(String resourceName);

	public List<Resource> getAllResource();
	
	public Resource getNew();

}