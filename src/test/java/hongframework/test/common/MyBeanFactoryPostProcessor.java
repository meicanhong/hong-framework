package hongframework.test.common;

import hongframework.bean.BeanException;
import hongframework.bean.factory.ConfigurableListableBeanFactory;
import hongframework.bean.factory.config.BeanDefinition;
import hongframework.bean.factory.config.BeanFactoryPostProcessor;
import hongframework.bean.factory.config.PropertyValue;
import hongframework.bean.factory.config.PropertyValues;

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
