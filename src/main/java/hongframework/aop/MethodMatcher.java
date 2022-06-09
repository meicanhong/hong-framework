package hongframework.aop;

import java.lang.reflect.Method;

/**
 * @Author: canhong
 * @Date: 2022/6/8 20:05
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);

}
