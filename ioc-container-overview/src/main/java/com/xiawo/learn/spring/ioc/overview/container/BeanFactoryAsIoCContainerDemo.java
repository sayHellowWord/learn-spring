package com.xiawo.learn.spring.ioc.overview.container;

import com.xiawo.learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * IoC 容器示例
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
public class BeanFactoryAsIoCContainerDemo {


    public static void main(String[] args) {

        //创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //XML 配置文件 ClassPath路径
        String location = "classpath:META-INF/dependency-look-up.xml";

        //加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int beanDefinitionNum = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量" + beanDefinitionNum);
        //按照类型查找集合对象
        lookupInByCollectionType(beanFactory);
    }

    private static void lookupInByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User集合对象" + userMap);
        }
    }
}
