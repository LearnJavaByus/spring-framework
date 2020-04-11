## Code of spring
  study spring-framework code example


## bean源码分析过程
### 1、bean的创建
   介绍bean创建过程和bean的声明周期，包括一些关键的扩展如BeanPostProcessor、各种Aware、InitializingBean等的调用过程
    学习入口:
        
        A a = applicationContext .getBean(A.class);  最后doGetBean方法进行研究。

### 2、bean的销毁
   主要内容是bean的销毁流程，包括DisposableBean的调用过程
   
      AbstractApplicationContext 的registerShutdownHook()进行研究

## AOP 源码分析过程
### 1、aop:aspectj-autoproxy标签解析
   主要内容是介绍<aop:aspectj-autoproxy>标签的解析过程，包括如何寻找advice，如何匹配advice等
    
        AopNamespaceHandler 的init()方法new AspectJAutoProxyBeanDefinitionParser()的parse()方法
        bean的实例化postProcessAfterInitialization方法
        


## spring源码事务分析过程
### 1、tx:annotation-driven标签解析过程，TxNamespaceHandler 的init()方法，侧重看对事务标签的解析过程
   
      如：registerBeanDefinitionParser("annotation-driven", new AnnotationDrivenBeanDefinitionParser());
    从 AnnotationDrivenBeanDefinitionParser 的parse() 开始学习
   
### 2、事务的执行过程
        如：TransactionInterceptor 的invoke()方法
   
### 3、事务的提交过程
    如：TransactionAspectSupport 的 commitTransactionAfterReturning()方法
   
### 4、事务的回滚过程
    如: TransactionAspectSupport 的 completeTransactionAfterThrowing()的方法