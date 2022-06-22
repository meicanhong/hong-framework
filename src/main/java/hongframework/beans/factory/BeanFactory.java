package hongframework.beans.factory;

import hongframework.beans.BeanException;

/**
 * @Author: canhong
 * @Date: 2022/6/5 11:29
 */
public interface BeanFactory {

    Object getBean(String name) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;

    <T> T getBean(String name, Class<T> requiredType) throws BeanException;

    <T> T getBean(Class<T> requiredType) throws BeanException;

}
