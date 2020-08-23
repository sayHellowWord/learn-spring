package com.xiawo.learn.spring.bean.definition;

import com.xiawo.learn.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
public class BeanDefinitionCreationDemo {


    public static void main(String[] args) {

        // 1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过属性设置
        beanDefinitionBuilder
                .addPropertyValue("name", "波波")
                .addPropertyValue("id", 1L);
        //获取 BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //BeanDefinition 并非Bean 最终状态 可以自定义修改


        // 2.通过 AbstractBeanDefinition  以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);

        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "波波");
        propertyValues.addPropertyValue("id", 1L);
        propertyValues
                .add("name", "波波")
                .add("id", 1L);
        genericBeanDefinition.setPropertyValues(propertyValues);


    }



}
