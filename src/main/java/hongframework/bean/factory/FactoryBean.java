package hongframework.bean.factory;

/**
 * @Author: canhong
 * @Date: 2022/6/7 11:12
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
