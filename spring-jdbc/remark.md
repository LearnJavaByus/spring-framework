## 一、spring源码事务分析过程
### 1、tx:annotation-driven标签解析过程，TxNamespaceHandler 的init()方法，侧重看对事务标签的解析过程
   如：registerBeanDefinitionParser("annotation-driven", new AnnotationDrivenBeanDefinitionParser());
   从 AnnotationDrivenBeanDefinitionParser 的parse() 开始学习
   
### 2、事务的执行过程
   如：TransactionInterceptor 的invoke()方法
   
### 3、事务的提交过程
   如：TransactionAspectSupport 的 commitTransactionAfterReturning()方法
   
### 4、事务的回滚过程
   如: TransactionAspectSupport 的 completeTransactionAfterThrowing()的方法