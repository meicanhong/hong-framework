package hongframework.context;

import hongframework.beans.factory.ListableBeanFactory;
import hongframework.beans.factory.config.HierarchicalBeanFactory;
import hongframework.core.io.ResourceLoader;

/**
 * @Author: canhong
 * @Date: 2022/6/5 11:28
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
