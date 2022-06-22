package hongframework.context;

import hongframework.beans.BeanException;
import hongframework.beans.factory.Aware;

/**
 * @Author: canhong
 * @Date: 2022/6/6 23:32
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeanException;

}
