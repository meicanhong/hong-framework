package hongframework.beans.factory;

/**
 * @Author: canhong
 * @Date: 2022/6/6 23:31
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}
