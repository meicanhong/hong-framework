package hongframework.beans.factory;

import hongframework.beans.BeanException;
import hongframework.beans.factory.config.AutowireCapableBeanFactory;
import hongframework.beans.factory.config.BeanDefinition;
import hongframework.beans.factory.config.BeanPostProcessor;
import hongframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author: canhong
 * @Date: 2022/6/5 11:11
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 根据BeanName获取BeanDefinition
     * @param beanName
     * @return
     * @throws BeanException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    /**
     * 提前初始化单例Bean
     * @throws BeanException
     */
    void preInstantiateSingletons() throws BeanException;

    /**
     * 添加BeanPostProcessor
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
