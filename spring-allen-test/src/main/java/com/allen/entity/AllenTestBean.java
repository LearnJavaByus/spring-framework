package com.allen.entity;

/**
 * @author: allen小哥 2020-03-22 09:12
 * 创建用于拦截的bean
 **/
public class AllenTestBean {

	private String testStr= "testStr";

	public String getTestStr() {
		System.out.println("|执行get操作|");
		return testStr;
	}

	public void setTestStr(String testStr) {
		System.out.println("|执行set操作|=");
		this.testStr = testStr;
	}

	public void test(){
		System.out.println("TestBean的test方法");
	}
}
