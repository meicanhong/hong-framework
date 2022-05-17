package hong.framework.ioc.core;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: canhong
 * @Date: 2022/5/12 11:28
 */
public interface BeanFactory {
    public Object getBean(String name) throws Exception;
}
