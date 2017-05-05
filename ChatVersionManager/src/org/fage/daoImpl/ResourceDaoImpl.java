package org.fage.daoImpl;

import java.util.List;

import org.fage.dao.ResourceDao;
import org.fage.domain.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
/**
 * 自动事务管理
 * @author fage
 * @date 2017-1-6
 * @Discription 版本持久层
 * 
 */

@Repository//持久层
public class ResourceDaoImpl implements ResourceDao {
	private SessionFactory sessionFactory;
	
	@Required//自动注入SessionFactory
	@javax.annotation.Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//增
	public void add(Resource resource){
		sessionFactory.getCurrentSession().save(resource);
	}
	//通过id得
	public Resource get(int id){
		return sessionFactory.getCurrentSession().get(Resource.class, id);
	}
	//通过版本名得
	public Resource get(String name){
		return (Resource) sessionFactory.getCurrentSession().createQuery("from Resource r where r.name=?").setString(0, name).uniqueResult();
	}
	//删
	public void delete(Resource resource){
		sessionFactory.getCurrentSession().delete(resource);
	}
	//得到所有的
	public List<Resource> getAll(){
		return  sessionFactory.getCurrentSession().createQuery("from Resource").list();
	}
	
	public Resource getLast(){
		return (Resource) sessionFactory.getCurrentSession().createQuery("from Resource r order by r.id desc").setFirstResult(0).setMaxResults(1).uniqueResult();
	}
	
}
