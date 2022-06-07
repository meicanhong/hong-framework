package hongframework.context;

import hongframework.bean.factory.ListableBeanFactory;
import hongframework.bean.factory.config.HierarchicalBeanFactory;
import hongframework.core.io.ResourceLoader;

/**
 * @Author: canhong
 * @Date: 2022/6/5 11:28
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
