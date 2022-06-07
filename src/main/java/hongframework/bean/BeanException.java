package hongframework.bean;

/**
 * @Author: canhong
 * @Date: 2022/6/5 10:52
 */
public class BeanException extends RuntimeException {

    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
