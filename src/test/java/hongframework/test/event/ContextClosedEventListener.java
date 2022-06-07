package hongframework.test.event;

import hongframework.context.ApplicationListener;
import hongframework.context.event.ContextClosedEvent;

/**
 * @Author: canhong
 * @Date: 2022/6/7 19:29
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}