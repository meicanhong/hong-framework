package hongframework.context;

import hongframework.beans.BeanException;

/**
 * @Author: canhong
 * @Date: 2022/6/5 11:06
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeanException
     */
    void refresh() throws BeanException;

    /**
     * 注册关机钩子
     */
    void registerShutdownHook();

    /**
     * 关闭
     */
    void close();
}
