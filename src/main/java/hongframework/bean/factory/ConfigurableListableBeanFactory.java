package hongframework.bean.factory;

import hongframework.bean.BeanException;
import hongframework.bean.factory.config.AutowireCapableBeanFactory;
import hongframework.bean.factory.config.BeanDefinition;
import hongframework.bean.factory.config.BeanPostProcessor;
import hongframework.bean.factory.config.ConfigurableBeanFactory;

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
