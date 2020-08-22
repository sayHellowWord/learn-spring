package com.xiawo.learn.spring.ioc.overview.dependency.lookup;

import com.xiawo.learn.spring.ioc.overview.annotation.Supper;
import com.xiawo.learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * <p>
 * 通过名称的方式查找
 *
 * <p>
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
public class DependencyLookUpDemo {


    public static void main(String[] args) {

        //配置XML 配置文件
        //启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-look-up.xml");
      /*  User user = (User) beanFactory.getBean("user");
        System.out.println(user.toString());*/

        //通过名称的方式查找
        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);

        //按照类型查找
        lookupInByType(beanFactory);
        //按照类型查找集合对象
        lookupInByCollectionType(beanFactory);
        lookupInByAnnotationType(beanFactory);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找:" + user.toString());
    }


    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找:" + user.toString());
    }

    private static void lookupInByType(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean(User.class);
        System.out.println("按照类型实时查找:" + user.toString());
    }

    private static void lookupInByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User集合对象" + userMap);
        }
    }

    private static void lookupInByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Supper.class);
            System.out.println("查找到的标注 @SuperUser集合对象" + userMap);
        }
    }

}
