package hongframework.context.support;

import hongframework.bean.BeanException;
import hongframework.bean.factory.config.BeanPostProcessor;
import hongframework.context.ApplicationContext;
import hongframework.context.ApplicationContextAware;

/**
 * @Author: canhong
 * @Date: 2022/6/5 11:27
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }
}
