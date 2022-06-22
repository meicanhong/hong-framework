package hongframework.beans.factory;

import hongframework.beans.BeanException;

/**
 * @Author: canhong
 * @Date: 2022/6/6 23:31
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeanException;

}
