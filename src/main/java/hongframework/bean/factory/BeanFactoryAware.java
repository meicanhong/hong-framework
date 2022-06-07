package hongframework.bean.factory;

import hongframework.bean.BeanException;

/**
 * @Author: canhong
 * @Date: 2022/6/6 23:31
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeanException;

}
