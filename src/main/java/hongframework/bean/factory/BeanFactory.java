package hongframework.bean.factory;

import hongframework.bean.BeanException;

/**
 * @Author: canhong
 * @Date: 2022/6/5 11:29
 */
public interface BeanFactory {

    Object getBean(String name) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;

    <T> T getBean(String name, Class<T> requiredType) throws BeanException;

}
