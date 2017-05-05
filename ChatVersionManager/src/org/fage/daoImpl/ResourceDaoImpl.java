package org.fage.daoImpl;

import java.util.List;

import org.fage.dao.ResourceDao;
import org.fage.domain.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
/**
 * �Զ��������
 * @author fage
 * @date 2017-1-6
 * @Discription �汾�־ò�
 * 
 */

@Repository//�־ò�
public class ResourceDaoImpl implements ResourceDao {
	private SessionFactory sessionFactory;
	
	@Required//�Զ�ע��SessionFactory
	@javax.annotation.Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//��
	public void add(Resource resource){
		sessionFactory.getCurrentSession().save(resource);
	}
	//ͨ��id��
	public Resource get(int id){
		return sessionFactory.getCurrentSession().get(Resource.class, id);
	}
	//ͨ���汾����
	public Resource get(String name){
		return (Resource) sessionFactory.getCurrentSession().createQuery("from Resource r where r.name=?").setString(0, name).uniqueResult();
	}
	//ɾ
	public void delete(Resource resource){
		sessionFactory.getCurrentSession().delete(resource);
	}
	//�õ����е�
	public List<Resource> getAll(){
		return  sessionFactory.getCurrentSession().createQuery("from Resource").list();
	}
	
	public Resource getLast(){
		return (Resource) sessionFactory.getCurrentSession().createQuery("from Resource r order by r.id desc").setFirstResult(0).setMaxResults(1).uniqueResult();
	}
	
}
