package hong.framework.ioc.service;

import hong.framework.ioc.annotation.Service;

/**
 * @Author: canhong
 * @Date: 2022/5/13 15:42
 */
@Service(value = "userService")
public class UserService {
    public void hello() {
        System.out.println("hello");
    }
}
