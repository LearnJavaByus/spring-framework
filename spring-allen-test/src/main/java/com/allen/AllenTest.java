package com.allen;

import com.allen.entity.AllenTestBean;
import com.allen.service.PersonService;
import com.allen.service.TestService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: allen小哥 2020-03-22 08:25
 **/
public class AllenTest {

	/**
	 * 测试切点加载
	 */
	@Test
	public void testAspect(){
		ApplicationContext context = new ClassPathXmlApplicationContext("test-aspectj.xml");
		AllenTestBean testBean =(AllenTestBean) context.getBean("testBean");
		testBean.test();
	}

	/**
	 * 测试类与类之间的关系
	 */
	@Test
	public void testClass(){
		ApplicationContext context = new ClassPathXmlApplicationContext("test-class.xml");
		PersonService personBean =(PersonService) context.getBean("personService");
		personBean.person();

		TestService testBean =(TestService) context.getBean("testService");
		testBean.test();
	}

	@Test
	public void testConfig(){
		ApplicationContext context = new ClassPathXmlApplicationContext("test-config.xml");
		PersonService personBean =(PersonService) context.getBean("personService");
		personBean.person();
	}

}
