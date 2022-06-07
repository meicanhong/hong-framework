package hongframework.bean.factory.config;

import hongframework.bean.BeanException;

/**
 * @Author: canhong
 * @Date: 2022/6/5 11:20
 */
public interface BeanPostProcessor {

    /**
     * 在Bean初始化前执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException;

    /**
     * 在Bean初始化后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException;
}
