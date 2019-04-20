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