package hongframework.test.common;

import hongframework.beans.BeanException;
import hongframework.beans.factory.ConfigurableListableBeanFactory;
import hongframework.beans.factory.config.BeanDefinition;
import hongframework.beans.factory.config.BeanFactoryPostProcessor;
import hongframework.beans.factory.config.PropertyValue;
import hongframework.beans.factory.config.PropertyValues;

/**
 * @Author: canhong
 * @Date: 2022/6/6 16:00
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));

    }
}
