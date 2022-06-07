package hongframework.bean.factory.support;

import hongframework.bean.BeanException;
import hongframework.core.io.Resource;
import hongframework.core.io.ResourceLoader;

/**
 * @Author: canhong
 * @Date: 2022/6/6 0:14
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;

    void loadBeanDefinitions(String... locations) throws BeanException;

}
