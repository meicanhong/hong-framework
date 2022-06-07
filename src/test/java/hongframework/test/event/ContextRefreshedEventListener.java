package hongframework.test.event;

import hongframework.context.ApplicationListener;
import hongframework.context.event.ContextRefreshedEvent;

/**
 * @Author: canhong
 * @Date: 2022/6/7 19:30
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}

