package com.xiawo.learn.spring.ioc.overview.dependency.injection;

import com.xiawo.learn.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入示例
 * <p>
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
public class DependencyInjectionDemo {


    public static void main(String[] args) {
        //配置XML 配置文件
        //启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
//        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        /**
         *  自定义Bean
         */
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println(userRepository.toString());

        /**
         * 内建依赖
         */
        System.out.println(userRepository.getBeanFactory());
        System.out.println(objectFactory.getObject());
        System.out.println(objectFactory.getObject() == beanFactory);

        //false 依赖注入  为什么不会成立 whoIsIoCContainer
        System.out.println(beanFactory == userRepository.getBeanFactory());

        //error no qualifying 依赖查找
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        /**
         * 容器内建Bean
         */
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取Environment类型的bean" + environment);

    }

    private static void whoIsIoCContainer(UserRepository userRepository, BeanFactory beanFactory) {

        //为什么不会成立
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        /**
         * ApplicationContext is  BeanFactory
         *
         * ConfigurableApplicationContext <- ApplicationContext  <- BeanFactory
         * ConfigurableApplicationContext#getBeanFactory
         *
         * 组合+代理
         */
    }


}
