package hongframework.aop.framework.autoproxy;

import hongframework.aop.AdvisedSupport;
import hongframework.aop.Advisor;
import hongframework.aop.ClassFilter;
import hongframework.aop.Pointcut;
import hongframework.aop.TargetSource;
import hongframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import hongframework.aop.framework.ProxyFactory;
import hongframework.beans.BeanException;
import hongframework.beans.factory.BeanFactory;
import hongframework.beans.factory.BeanFactoryAware;
import hongframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import hongframework.beans.factory.config.PropertyValues;
import hongframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: canhong
 * @Date: 2022/6/8 21:01
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    private final Set<Object> earlyProxyReferences = Collections.synchronizedSet(new HashSet<Object>());

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeanException {
       return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeanException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeanException {
        return pvs;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        if (!earlyProxyReferences.contains(beanName)) {
            return wrapIfNecessary(bean, beanName);
        }

        return bean;
    }

    protected Object wrapIfNecessary(Object bean, String beanName) {
        if (isInfrastructureClass(bean.getClass())) {
            return bean;
        }

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            // 过滤匹配类
            if (!classFilter.matches(bean.getClass())) {
                continue;
            }

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(bean);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(true);

            // 返回代理对象
            return new ProxyFactory(advisedSupport).getProxy();
        }

        return bean;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) {
        earlyProxyReferences.add(beanName);
        return wrapIfNecessary(bean, beanName);
    }

}
