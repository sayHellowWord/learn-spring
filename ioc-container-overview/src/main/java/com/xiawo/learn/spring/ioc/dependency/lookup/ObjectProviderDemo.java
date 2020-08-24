package com.xiawo.learn.spring.ioc.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by wubo15 on 2020/8/24.
 *
 * @author wubo15
 * @date 2020/8/24
 */
public class ObjectProviderDemo { // @Configration 是非必须注解


    public static void main(String[] args) {

        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类 AnnotationApplicationAsIoCContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(ObjectProviderDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        //按照类型查找集合对象
        lookupInByObjectProvider(applicationContext);

        //关闭应用上下文
        applicationContext.close();
    }


    @Bean
    public String helloWorld(){ // @Bean未定义bean名称 方法名就是Bean的名称 = "helloWorld"
        return "helloWorld";
    }

    /**
     * 延迟加载
     * @param applicationContext
     */
    private static void lookupInByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider =  applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

}
