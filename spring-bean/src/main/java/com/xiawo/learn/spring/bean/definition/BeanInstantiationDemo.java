package com.xiawo.learn.spring.bean.definition;

import com.xiawo.learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化实例
 * <p>
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        //配置XML 配置文件
        //启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");
        User user = (User) beanFactory.getBean("user-by-static-method");
        User userByInstancemMethod = (User) beanFactory.getBean("user-by-instance-method");
        System.out.println(user.toString());
        System.out.println(user == userByInstancemMethod);


    }

}
