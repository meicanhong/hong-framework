package hongframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author: canhong
 * @Date: 2022/6/8 20:37
 */
public interface Advisor {

    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
