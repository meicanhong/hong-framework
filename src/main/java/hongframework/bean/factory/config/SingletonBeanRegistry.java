package hongframework.bean.factory.config;

/**
 * @Author: canhong
 * @Date: 2022/6/5 15:36
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
