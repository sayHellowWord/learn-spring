package com.xiawo.learn.spring.bean.definition;

import com.xiawo.learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 注解 BeanDefinition 示例
 * <p>
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */

@Import(AnnotationBeanDefinitionDemo.Config.class)

public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册   配置类（Configuration Class）
        applicationContext.register(Config.class);

        //通过Java APi
        registerBeanDefinition(applicationContext, "mercyblite-user", User.class);
        registerBeanDefinition(applicationContext, User.class);

        //启动
        applicationContext.refresh();

        // 1、通过 @Bean 方式定义
        // 2、通过 @Component 方式
        // 2、通过 @Import 来进行导入

        //按照类依赖查找
        System.out.println("Config 类型的所有Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有Beans" + applicationContext.getBeansOfType(User.class));


        //显示的关闭Spring 应用上下文
        applicationContext.close();
    }

    /**
     * 通过API 方式注册bean
     * 命名 Bean的注册
     *
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        //通过属性设置
        definitionBuilder
                .addPropertyValue("name", "波波")
                .addPropertyValue("id", 1L);

        registry.registerBeanDefinition(beanName, definitionBuilder.getBeanDefinition());
    }

    /**
     * 通过API 方式注册bean
     * f非命名 Bean的注册
     *
     * @param registry
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass) {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        //通过属性设置
        definitionBuilder
                .addPropertyValue("name", "波波")
                .addPropertyValue("id", 1L);
        BeanDefinitionReaderUtils.registerWithGeneratedName(definitionBuilder.getBeanDefinition(), registry);
    }


    @Component //定义当前类作为 Spring Bean（组件）
    public static class Config {


        /**
         * 通过 Java 注解的方式，定义了一个 Bean
         *
         * @return
         */
        @Bean(name = {"user", "bobo-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("波波");
            return user;
        }

    }


}
