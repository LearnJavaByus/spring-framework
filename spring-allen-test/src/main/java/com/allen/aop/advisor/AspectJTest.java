package com.allen.aop.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author: allen小哥 2020-03-22 09:15
 * 创建Advisor
 **/
@Aspect
public class AspectJTest {

	/**
	 * //scope ：方法作用域，如public,private,protect
	 * //returnt-type：方法返回值类型
	 * //fully-qualified-class-name：方法所在类的完全限定名称
	 * //parameters 方法参数
	 * execution(<scope> <return-type> <fully-qualified-class-name>.*(parameters))
	 */
	@Pointcut("execution(* *.test(..))")
	public void test(){

	}

	/**
	 *  前置增强:BeforeAdvice代表前置增强，是为了将来版本扩展需要而定义的。而MethodBeforeAdvice是目前可用的前置增强，
	 *  表示在目标方法执行前实施增强。既是目标方法执行前要做的事。
	 */
	@Before("test()")
	public void beforeTest(){
		System.out.println("before");
	}

	/**
	 * 后置增强:AfterReturningAdvice代表后置增强，表示目标方法执行后实施增强。既是目标方法执行后要做的事。
	 */
	@After("test()")
	public void afterTest(){
		System.out.println("after");
	}

	/**
	 * 环绕增强:MethodInterecptor代表环绕增强，表示在目标方法执行前后实施增强。既是目标方法执行前后要做的事。
	 * @param
	 * @return
	 */
	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint p){
		System.out.println("around----before");
		Object object = null;
		try {
			 object = p.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("around----after");
		return object;
	}
}
