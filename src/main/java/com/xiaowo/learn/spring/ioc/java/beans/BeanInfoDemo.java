package com.xiaowo.learn.spring.ioc.java.beans;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link BeanInfo} 示例
 * <p>
 * Created by wubo15 on 2020/8/22.
 *
 * @author wubo15
 * @date 2020/8/22
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
//        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor.toString());

            //propertyDescriptor 允许添加属性编辑器 - PropertyEditor
            //GUI -> text(String)  -> PropertyType
            //namse -> String age -> Integer
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyName = propertyDescriptor.getName();
            if ("age".endsWith(propertyName)) { // 为"age" 字段/属性增加 PropertyEditor
                //String  -> Integer
                Integer.valueOf("1");
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                propertyDescriptor.createPropertyEditor();
            }
        });

    }


    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }

    }

}
