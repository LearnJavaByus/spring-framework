## Code of spring
  study spring-framework code example
  
## context源码分析
### 1、Spring上下文初始化

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        既refresh()方法分析

### 2、标签解析
  主要内容是<bean/>、<beans/>、<import/>、<alias/>四个默认标签的解析过程
  
      AbstractXmlApplicationContext 的loadBeanDefinitions()方法分析
### 3、自定义标签的解析
   主要内容是除了默认标签外其他自定义标签的解析过程
   
    BeanDefinitionParserDelegate的parseCustomElement()的方法
    
### 4、context:component-scan标签解析
  主要内容是<context:component-scan/>标签的解析过程
  
    ContextNamespaceHandler的init()方法
    registerBeanDefinitionParser("component-scan", new ComponentScanBeanDefinitionParser());
    ComponentScanBeanDefinitionParser 的parse()方法进行解析
  
### 5、@Component注解的扫描
   主要内容是@Component、@Service等注解的扫描过程
   
     ClassPathBeanDefinitionScanner的doScan()进行分析
 
### 6、@Configuration注解解析
   主要内容是介绍注解方式配置Spring的解析过程，涉及到的注解有@Configuration、@Bean、@Scope、@ComponentScan、@ImportResource、@Import等，阅读Spring boot源码之前需要先了解这部分知识
    
    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
    
    ConfigurationClassPostProcessor 的postProcessBeanDefinitionRegistry()方法分析
    
    @Configuration：我们可以把它理解为Spring的xml配置文件中的<beans/>标签，也就是Spring容器的上下文
    @Bean：我们可以把它理解为Spring的xml配置文件中的<bean/>标签，也就是用来注册一个bean的，我们可以配置initMethod、destroyMethod等注解属性来完成和<bean/>标签中对应属性配置一样的功能
    @Scope：用来配置bean的作用域，默认是singleton，也就是单例
    @ComponentScan：我们可以把它理解为Spring的xml配置文件中的<context:component-scan/>标签，也就是用来扫描@Component注解注册bean的，如果未指定包，则将从声明此注解的类的包进行扫描
    @ImportResource：我们可以使用它来引入另一个Spring配置文件的配置
    @Import：我们可以使用它来引入另一个注解配置
    
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
        
### 2、AOP的代理创建
  主要内容是AOP代理创建的过程，包括什么时候使用CGLIB代理，什么时候使用JDK动态代理
      
      AbstractAutoProxyCreator的 createProxy()方法
       

### 3、aop的执行
  主要内容是AOP的执行过程，包括前置增强、后置增强等流程的分析
  
    JdkDynamicAopProxy的invoke()方法
    适配器类型:
    MethodBeforeAdviceAdapter 对应@Before注解创建的advice的适配器
    AfterReturningAdviceAdapter  对应@AfterReturning注解创建的advice的适配器
    ThrowsAdviceAdapter  对应@AfterThrowing注解创建的advice的适配器
    MethodInterecptor  对应@After注解创建的advice的适配器
    IntroductionInterecptor  对应@DeclareParents注解创建的advice的适配器
    
    此处对MethodBeforeAdviceAdapter 的getInterceptor()进行分析
    
    CglibAopProxy 的getProxy()方法进行分析
    
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