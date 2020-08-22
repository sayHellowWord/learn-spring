package com.xiawo.learn.spring.ioc.overview.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * 超级
 * <p>
 * Created by wubo15 on 2020/8/23.
 *
 * @author wubo15
 * @date 2020/8/23
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Supper {


}
