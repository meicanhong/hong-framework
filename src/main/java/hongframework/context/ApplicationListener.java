package hongframework.context;

import java.util.EventListener;

/**
 * @Author: canhong
 * @Date: 2022/6/7 12:03
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);

}
