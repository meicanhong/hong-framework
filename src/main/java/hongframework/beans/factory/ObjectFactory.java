package hongframework.beans.factory;

import hongframework.beans.BeanException;

/**
 * @Author: canhong
 * @Date: 2022/6/26 18:47
 */
public interface ObjectFactory<T> {

    T getObject() throws BeanException;

}
