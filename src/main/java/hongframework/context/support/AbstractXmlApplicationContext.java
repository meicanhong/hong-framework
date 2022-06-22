package hongframework.context.support;

import hongframework.beans.factory.support.DefaultListableBeanFactory;
import hongframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author: canhong
 * @Date: 2022/6/6 15:17
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
