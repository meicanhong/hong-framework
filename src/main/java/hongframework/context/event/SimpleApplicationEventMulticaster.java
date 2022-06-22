package hongframework.context.event;

import hongframework.beans.factory.BeanFactory;
import hongframework.context.ApplicationEvent;
import hongframework.context.ApplicationListener;

/**
 * @Author: canhong
 * @Date: 2022/6/7 18:27
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
