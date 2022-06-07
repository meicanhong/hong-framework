package hongframework.test.common;

import hongframework.bean.BeanException;
import hongframework.bean.factory.config.BeanPostProcessor;
import hongframework.test.bean.UserService;

/**
 * @Author: canhong
 * @Date: 2022/6/6 16:03
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }
}
