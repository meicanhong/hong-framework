package hongframework.aop;

/**
 * @Author: canhong
 * @Date: 2022/6/8 20:38
 */
public interface PointcutAdvisor extends Advisor {

    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();

}
