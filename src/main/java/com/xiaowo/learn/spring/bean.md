#Spring Bean 定义

## 什么是BeanDefinition
BeanDefinition是Spring Framework中定义Bean的配置元信息接口，包含：
* Bean的类名
* Bean行为配置元素，如作用域、自动绑定的模式、生命周期回调等
* 其他Bean引用，又可称作合作者或者依赖
* 配置设置，比如Bean属性

##  BeanDefinition 元信息
|  属性（Property)   | 说明  |
|  ----  | ----  |
| class  | Bean全类名，必须是具体类，不用抽象类或接口 |
| name  | Bean的名称或者ID |
| scope  | Bean的作用域（如：singleton、prototype等） |
| Contractor arguments  | Bean的构造器参数（用于依赖注入） |
| Properties  |  Bean的属性设置（用于依赖注入） |
| Autowiring mode  |  Bean自动绑定模式（如：通过名称byName） |
| Lazy initialization mode  |  Bean延迟初始化模式（延迟和非延迟） |
| Initialization method  |  Bean初始化回调方法名称 |
| Destruction method  | Bean 销毁回调方法名称 |

## BeanDefinition构建
* 通过 BeanDefinitionBuilder（XML）
* 通过 AbstractBeanDefinition 以及派生类

## 命名 Spring Bean
* Bean 的名称
每个Bean用友一个或多个标识符（identifiers）,这些标识符在Bean所在的容器必须是唯一的。通常，一个Bean仅有一个标识符，如果需要额外的，可开了使用别名（Alias）来扩充。
如果留空的话，容器会为Bean自动生成一个唯一的名称（BeanNameGenerator）
* Bean名称生成器（BeanNameGenerator）
    * DefaultBeanNameGenerator（默认）
    * AnnotationBeanNameGenerator
 
# 注册 Spring Bean
* BeanDefinition注册
    * XML 配置元信息
    * Java 注解配置元信息
    * Java API 配置元信息
  
# 实例化 Spring Bean
## 常规方式
* 通过构造器（配置元信息：XML 、JAVA 注解 和JAVA API）
* 通过静态工程方法（配置元信息：XML 、 JAVA API）
* 通过Bean工程方法（配置元信息：XML 、 JAVA API）
* 通过FactoryBean（配置元信息：XML 、JAVA 注解 和JAVA API）
## 特殊方式
* 通过ServiceLoaderFactoryBean（配置元信息：XML 、JAVA 注解 和JAVA API）
* 通过AutowireCapableBeanFactory#createBean(java.lang.Class,int,boolean)
* 通过BeanDefinitionRegistry#registerBeanDefinition(String , BeanDefinition)

# 初始化 SPring Bean
* @PostConstruct 标注方法
* 实现InitializingBean的afterPropertiesSet()方法
* 自定义初始化方法
    * XML <bean init-method
    * Java 注解 @Bean(initMethod)
    * Java API： AbstractBeanDefinition#SetInitMethodName(String)
    
# 延迟初始化Spring Bean
* XML配置 <Bean lazy-init
* Java注解@Lazy(true)