package com.xiawo.learn.spring.bean.definition.factory;

import com.xiawo.learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

}
