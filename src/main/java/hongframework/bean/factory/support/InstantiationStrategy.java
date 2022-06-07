package hongframework.bean.factory.support;

import hongframework.bean.BeanException;
import hongframework.bean.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: canhong
 * @Date: 2022/6/5 15:50
 */
public interface InstantiationStrategy {
    /**
     * 初始化Bean
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeanException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException;
}
