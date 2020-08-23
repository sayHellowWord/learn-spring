# 什么是IOC
好莱坞原则-控制反转

# 主要实现策略
* 服务定位 JNDI
* 依赖查找
* 依赖注入：
    * 构造器
    * 参数注入
    * setter注入
    * 接口注入
 * 上下文查询
 * 模板方法
 * 策略模式
 
 # 目的
 实现与任务之间要产生解耦
 好莱坞原则
 
 # 职责
 * 通用职责
 * 依赖处理
    * 依赖查找
    * 依赖注入
    * 类型转换
 * 生命周期管理
    * 容器
    * 托管的资源（Java Beans或其他资源）
 * 配置
    * 容器
    * 外部化配置
    * 托管的资源（Java Beans或其他资源）
    
# Java Beans
##特性
    依赖查找
    生命周期管理
    配置元信息
    事件
    自定义
    资源管理
    持久化
 
 
 # 依赖查找 VS 依赖注入
 依赖处理 ： 主动获取、被动提供
 实现便利性
 代码侵入性
 API依赖性
 可读性
 
 # 构造器注入 VS Settler注入
 
 # 问题
 ## 什么是IOC
 IOC是反转控制，类似于好莱坞原则，主要是依赖查找和依赖注入实现
 
 ## 依赖查找和依赖注入的区别
 依赖查找是主动或手动的依赖查找方式，通常需要依赖容器或标准API实现
 依赖注入则是手动或自动依赖绑定的方式，无需依赖特定的容器和API
 
 ## Spring 作为IoC容器有什么优势
 典型的IOC管理，依赖查找和依赖注入
 AOP抽象
 事物抽象
 事件机制
 SPI扩展
 强大的第三方整合
 易测试性
 更好的面向对象
 
 # Spring IoC 依赖查找
 ## 根据 Bean名称查找
 * 实时查找
 * 延迟查找
 
 ## 根据Bean类型查找
 * 单个Bean对象
 * 集合Bean对象
 ## 根据Bean名称+类型查找
 ## 根据Bean注解查找
 * 单个Bean对象
 * 集合Bean对象
 
 # Spring IoC 依赖注入
 ## 根据名称注入
 ## 根据类型注入
 * 单个Bean对象
 * 集合Bean对象
 ## 注入容器内建Bean对象
 ## 注入非Bean对象
 ## 注入类型
 * 实时注入
 * 延迟注入
 
  # Spring IoC 依赖来源
  ## 自定义Bean
  ## 容器内建Bean对象
  ## 容器内建依赖
 
 # Spring IoC 配置元信息
 ## Bean 定义配置
 * 基于XML文件
 * 基于Properties文件
 * 基于Java注解
 * 基于Java Api（专题讨论）
 * Grooy的DSL
 ## IoC容器配置
 * 基于XML文件
 * 基于Java注解
 * 基于Java Api（专题讨论）
## 外部化属性配置
* 基于Java注解

# BeanFactory 和 ApplicationContext 谁才是Spring IoC的容器
ApplicationContext是BeanFactory的超集
除了IoC
* 面向切片AOP
* 配置元信息
* 资源管理
* 事件
* 国际化
* 注解
* Environment抽象

# Spring IoC 容器生命周期

  applicationContext.refresh()

## 启动 AbstractApplicationContext
            // Prepare this context for refreshing.
			prepareRefresh();

			// Tell the subclass to refresh the internal bean factory.
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			// Prepare the bean factory for use in this context.
			prepareBeanFactory(beanFactory);

			try {
				// Allows post-processing of the bean factory in context subclasses.
				postProcessBeanFactory(beanFactory);

				// Invoke factory processors registered as beans in the context.
				invokeBeanFactoryPostProcessors(beanFactory);

				// Register bean processors that intercept bean creation.
				registerBeanPostProcessors(beanFactory);

				// Initialize message source for this context.
				initMessageSource();

				// Initialize event multicaster for this context.
				initApplicationEventMulticaster();

				// Initialize other special beans in specific context subclasses.
				onRefresh();

				// Check for listener beans and register them.
				registerListeners();

				// Instantiate all remaining (non-lazy-init) singletons.
				finishBeanFactoryInitialization(beanFactory);

				// Last step: publish corresponding event.
				finishRefresh();
			}

## 运行

## 停止 AbstractApplicationContext


			// Destroy all cached singletons in the context's BeanFactory.
			destroyBeans();

			// Close the state of this context itself.
			closeBeanFactory();

			// Let subclasses do some final clean-up if they wish...
			onClose();

# 问题
## 什么是Spring IoC容器
实现依赖反转DI，实现方式有依赖查找、依赖注入

## BeanFactory 与 FactoryBean
BeanFactory是IoC的底层容器
FactoryBean是创建Bean的一种方式，帮助实现复杂的初始化逻辑


## Spring IoC容器启动时做了那些准备
IoC配置元信息读取和解析、IoC容器生命周期、Spring事件发布、国际化等
