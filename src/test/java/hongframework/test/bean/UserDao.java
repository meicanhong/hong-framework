package hongframework.test.bean;

import hongframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: canhong
 * @Date: 2022/6/6 16:00
 */
@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
