package hongframework.beans.factory;

/**
 * @Author: canhong
 * @Date: 2022/6/6 22:44
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
