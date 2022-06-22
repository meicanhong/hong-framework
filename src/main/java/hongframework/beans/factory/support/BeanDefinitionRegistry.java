package hongframework.beans.factory.support;

import hongframework.beans.factory.config.BeanDefinition;

/**
 * @Author: canhong
 * @Date: 2022/6/5 15:45
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);
}
