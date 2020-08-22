package com.xiawo.learn.spring.ioc.overview.container;

import com.xiawo.learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * IoC 容器示例
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
@Configuration
public class AnnotationApplicationAsIoCContainerDemo {

    public static void main(String[] args) {

        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类 AnnotationApplicationAsIoCContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(AnnotationApplicationAsIoCContainerDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        //按照类型查找集合对象
        lookupInByCollectionType(applicationContext);

        //关闭应用上下文
        applicationContext.close();
    }

    /**
     * 通过 Java 注解的方式，定义了一个 Bean
     *
     * @return
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("波波");
        return user;
    }

    private static void lookupInByCollectionType(AnnotationConfigApplicationContext applicationContext) {
        if (applicationContext instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) applicationContext;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User集合对象" + userMap);
        }
    }
}
