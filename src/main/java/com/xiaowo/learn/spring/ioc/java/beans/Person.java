package com.xiaowo.learn.spring.ioc.java.beans;

/**
 * 描述人的POJO类
 * 贫血模型
 *
 * Setter/Getter方法
 * JavaBeans  可写方法(Writable)/可读方法(Readable)
 *
 * <p>
 * <p>
 * Created by wubo15 on 2020/8/22.
 *
 * @author wubo15
 * @date 2020/8/22
 */
public class Person {

    /**
     * 反射
     * 字段 + 类型
     * method
     * 构造器
     */

    private String name;//Property

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}