package hongframework.test.bean;

import hongframework.beans.factory.annotation.Autowired;
import hongframework.beans.factory.annotation.Value;
import hongframework.stereotype.Component;


import java.util.Random;

/**
 * @Author: canhong
 * @Date: 2022/6/6 16:00
 */
public class UserService implements IUserService {

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳，" + token;
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

