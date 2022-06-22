package hongframework.test.bean;

import hongframework.aop.MethodBeforeAdvice;
import hongframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: canhong
 * @Date: 2022/6/15 15:48
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}
