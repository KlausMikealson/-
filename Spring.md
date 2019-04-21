### Spring:
 - 开源框架
 - 轻量级，对比于EJB
 - 依赖的资源少、消耗的资源少
 - 分层架构
 - 核心：IOC、AOP
 - 方便解耦，简化开发
 - 切面编程
 - 支持事务
 - 方便测试
 - 方便集成各种框架

### 体系结构：
 - core container:
    - beans
    - core
    - context
    - expression language
 - aop
 - aspects
 - test
 - data access:
    - jdbc
    - orm
    - transactions
 - web:
    - web
    - servlet
    - struts
 
### bean 的作用域：
 - singleton
 - prototype
 - request
 - session
 - globalSession
 
### BeanFactory:
采用延迟加载，第一次 getBean 时才会初始化 bean

### ApplicationContext:
 - 国际化处理
 - 事件传递
 - Bean 自动装配
 - 各个不同应用层的 Context 实现
 
### bean 的实例化方式：
 - 默认构造
 - 静态工厂，常用于spring整合其他框架
   ```
   <bean id="" class="" factory-method="">
   ```
 - 实例工厂
   ```
   <bean id="" factory-bean="" factory-methoed="">
   ```
   
### BeanFactory 和 FactoryBean 对比：
BeanFactory：工厂，用于生产任意bean
FactoryBean：特殊 bean，用于生成另一个特定的 bean

### 作用域：
  - singleton
  - prototype
  - request
  - session
  - globalSession
  
### Bean 的生命周期：
1. instantiate bean 对象实例化
2. populate properties 封装属性
3. 如果 bean 实现 BeanNameAware 执行 setBeanName
4. 如果 bean 实现 BeanFactoryAware 或者 ApplicationContextAware 设置工厂 setBeanFactory 或者上下文对象 setApplicationContext
5. 如果存在类实现 BeanPostProcessor ,执行 postProcessBeforeInitialization
6. 如果 bean 实现 initializingBean 执行 afterPropertiesSet
7. 调用 <bean int-method="init"> 指定初始化方法 init
8. 如果存在类实现 BeanPostProcessor ，执行 postProcessAfterInitialization
9. 执行业务处理
10. 如果 bean 实现 DisposableBean 执行 destroy
11. 调用 <bean destroy-method=""> 指定销毁方法

### BeanPostProcessor:
Spring 提供共产钩子，用于修改实例对象，生成可代理对象，是AOP底层。
1. A a = new A();
2. a = B.before(a); // 将 a 的实例对象传递给后处理 bean，可以生成代理对象并返回
3. a.init();
4. a = B.after(a);
5. a.method(); // 生成代理对象，目的在目标方法前后执行（例如：开启事务、提交事务）
6. a.destroy();

### 属性依赖注入：
 - 构造方法
 - setter 方法
 - P 命名空间
 - SpEL


### AOP:
 - 横向抽取
 - 通过预编译方式和运行期动态代理实现程序功能的统一维护
 - 函数式编程的一种衍生范型
 - 利用 AOP 可以对业务逻辑的各个部分进行隔离，使业务逻辑各个部分之间耦合度降低
 - 提高程序的可重用性，提高开发效率
 - 横向抽取机制
 - 性能监控、事务管理、安全检查、缓存、日志
 - 纯 java 实现，不需要专门的编译过程和类加载器，在运行期通过代理方式向目标类织入增强代码
 
### AOP 实现原理：
 - 底层：代理机制
 - 接口+实现类：spring 采用 jdk 动态代理 Proxy
 - 实现类：spring 采用 cglib 字节码增强
 
 
### AOP 手动方式：JDK动态代理：
 - JDK 动态代理是对“装饰者”设计模式的简化，使用前提：必须有接口
 - cglib，没有接口，只有实现类，采用字节码增强框架cglib，在运行时创建目标类的子类，从而对目标类进行增强

### AspectJ:
 - AOP 框架
 - Spring2.0新增了对AspectJ切点表达式的支持
 
### JdbcTemplate:
 - Spring 提供用于操作 JDBC 的工具类
 - 依赖连接池
 







