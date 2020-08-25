# 依赖查找的类型
## 单一类型依赖查找
* JNDI - javax.naming.Context#lookup(javax.naming.Name)
* JavaBeans-java.beans.beancontext.BeanContext
## 集合类型依赖查找
* java.beans.beancontext.BeanContext
## 层次性依赖查找
* java.beans.beancontext.BeanContext


## 延迟查找
ObjectFactory
ObjectProvider

## 安全依赖查找


## 内建依赖
enviroment
systemProperties
systemEnvironment
messageSource
LifecycleProcessor
applicationEventMulticaster

## 依赖查找异常
## BeansException
NoSuchBeanDefinitionException
NoUniqueBeanDefinitionException
BeanInstantiationException
BeanCreationException
BeanDefinitionStoreException