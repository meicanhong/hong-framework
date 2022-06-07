package hongframework.bean.factory.config;

import hongframework.bean.BeanException;
import hongframework.bean.factory.ConfigurableListableBeanFactory;

/**
 * @Author: canhong
 * @Date: 2022/6/6 11:04
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeanException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException;

}
