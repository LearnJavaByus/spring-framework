package com.allen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author: allen小哥 2020-03-28 10:52
 **/
@Service
@Lazy
public class TestService {

	@Autowired
	PersonService personService;

	public void test(){
		System.out.println("|===|==天道酬勤");
	}


}
