package com.allen.aop;

import com.allen.entity.AllenTestBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: allen小哥 2020-03-22 09:11
 **/
public class AopTest {

	@Test
	public void testAspect(){
		ApplicationContext context = new ClassPathXmlApplicationContext("test-aspectj.xml");
		AllenTestBean testBean =(AllenTestBean) context.getBean("testBean");
		testBean.test();
	}
}
