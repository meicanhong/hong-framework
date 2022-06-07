package hongframework.test.event;

import hongframework.context.ApplicationListener;

import java.util.Date;

/**
 * @Author: canhong
 * @Date: 2022/6/7 19:30
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }

}
