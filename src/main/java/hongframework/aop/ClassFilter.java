package hongframework.aop;

/**
 * @Author: canhong
 * @Date: 2022/6/8 20:05
 */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);

}
