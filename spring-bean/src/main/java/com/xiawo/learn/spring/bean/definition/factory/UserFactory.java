package com.xiawo.learn.spring.bean.definition.factory;

import com.xiawo.learn.spring.ioc.overview.domain.User;

/**
 * {@link com.xiawo.learn.spring.ioc.overview.domain.User} 工厂类
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

}
