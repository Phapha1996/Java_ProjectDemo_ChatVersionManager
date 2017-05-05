package org.fage.dao;

import java.util.List;

import org.fage.domain.Resource;

public interface ResourceDao {

	//����һ���汾
	public void add(Resource resource);

	//ͨ��id�õ��汾
	public Resource get(int id);

	//ͨ���汾����ȡ��ǰ�汾
	public Resource get(String name);

	//ɾ����ǰһ���汾
	public void delete(Resource resource);

	//�õ����еİ汾�����۾���
	public List<Resource> getAll();
	//�õ����ݿ������һ����Ҳ���ǵ�ǰ���µķ����汾
	public Resource getLast();

}