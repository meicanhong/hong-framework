package hongframework.aop.aspectj;

import hongframework.aop.Pointcut;
import hongframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @Author: canhong
 * @Date: 2022/6/8 20:39
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;
    private Advice advice;
    private String expression;

    public void setExpression(String expression){
        this.expression = expression;
    }

    public void setAdvice(Advice advice){
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
