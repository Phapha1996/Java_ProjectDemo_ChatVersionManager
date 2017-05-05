package org.fage.dao;

import java.util.List;

import org.fage.domain.Resource;

public interface ResourceDao {

	//增加一个版本
	public void add(Resource resource);

	//通过id得到版本
	public Resource get(int id);

	//通过版本名获取当前版本
	public Resource get(String name);

	//删除当前一个版本
	public void delete(Resource resource);

	//得到所有的版本，无论旧新
	public List<Resource> getAll();
	//得到数据库中最后一个，也就是当前最新的发布版本
	public Resource getLast();

}