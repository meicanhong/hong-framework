package hongframework.beans.factory;

/**
 * @Author: canhong
 * @Date: 2022/6/6 22:44
 */
public interface DisposableBean {

    /**
     * Bean 销毁后调用
     *
     * @throws Exception
     */
    void destroy() throws Exception;
}
