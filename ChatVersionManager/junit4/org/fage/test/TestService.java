package org.fage.test;

import org.fage.controller.ResourceAction;
import org.fage.manager.ResourceManager;
import org.fage.service.ResourceService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	
	
	@Test
	public void test(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ResourceService rm = (ResourceService) context.getBean("resourceManager");
		System.out.println(rm.getNew().getId());
	}
	
	
	
}
