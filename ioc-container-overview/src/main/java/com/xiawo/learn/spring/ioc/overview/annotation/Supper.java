package com.xiawo.learn.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
