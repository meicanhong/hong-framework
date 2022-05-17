package hong.framework.ioc;

import hong.framework.ioc.core.AnnotationApplicationContext;
import hong.framework.ioc.service.UserService;

/**
 * @Author: canhong
 * @Date: 2022/5/13 15:43
 */
public class Test {
    public static void main(String[] args) throws Exception {
        AnnotationApplicationContext context = new AnnotationApplicationContext("hong.framework.ioc.service");
        UserService userService = (UserService) context.getBean("userService");
        userService.hello();
    }
}
