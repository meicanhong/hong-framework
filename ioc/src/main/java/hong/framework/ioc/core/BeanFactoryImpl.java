package hong.framework.ioc.core;

import cn.hutool.core.util.ReflectUtil;
import hong.framework.ioc.annotation.Autowired;
import hong.framework.ioc.bean.BeanDefinition;
import hong.framework.ioc.bean.ConstructorArg;
import hong.framework.ioc.bean.PropertyArg;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: canhong
 * @Date: 2022/5/12 11:28
 */
public class BeanFactoryImpl implements BeanFactory {

    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Object> earlyBeanMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, BeanDefinition> beanDefineMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        Object bean = beanMap.get(name);
        if (Objects.nonNull(bean)) {
            return bean;
        }
        Object earlyBean = earlyBeanMap.get(name);
        if (Objects.nonNull(earlyBean)) {
            System.err.println(String.format("%s存在循环依赖", name));
            return earlyBean;
        }
        BeanDefinition beanDefine = beanDefineMap.get(name);
        if (Objects.isNull(beanDefine)) {
            throw new Exception(String.format("找不到Bean：%s", name));
        }
        Object instance = createBean(beanDefine);
        earlyBeanMap.put(name, instance);
        setBeanProperty(beanDefine, instance);
        beanMap.put(name, instance);
        earlyBeanMap.remove(name);
        return instance;
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        String className = beanDefinition.getClassName();
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (CollectionUtils.isEmpty(constructorArgs)) {
            return ReflectUtil.newInstance(className);
        }
        for (ConstructorArg constructorArg : constructorArgs) {
            String ref = constructorArg.getRef();
            getBean(ref);
        }
        return ReflectUtil.newInstance(className);
    }

    protected void setBeanProperty(BeanDefinition beanDefinition, Object bean) throws Exception {
        List<PropertyArg> propertyArgs = beanDefinition.getPropertyArgs();
        if (CollectionUtils.isEmpty(propertyArgs)) {
            return;
        }
        for (PropertyArg propertyArg : propertyArgs) {
            String propertyArgName = propertyArg.getName();
            Object propertyArgValue = propertyArg.getValue();
            Class injectClass = propertyArgValue.getClass();
            String propertyArgRef = propertyArg.getRef();
            if (StringUtils.isNotEmpty(propertyArgRef)) {
                injectClass = getBean(propertyArgRef).getClass();
            }
            String methodName = "set" + propertyArgName.substring(0,1).toUpperCase() + propertyArgName.substring(1);
            Class<?> beanClass = Class.forName(beanDefinition.getClassName());
            Method method = beanClass.getMethod(methodName, injectClass);
            method.invoke(bean, propertyArgValue);
        }
    }

    protected void registerBean(String name, BeanDefinition beanDefinition) {
        beanDefineMap.put(name, beanDefinition);
    }

    protected void autowired() throws Exception {
        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            Object object = entry.getValue();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                Autowired autowired = field.getAnnotation(Autowired.class);
                if (Objects.nonNull(autowired)) {
                    String fieldName = field.getName();
                    Object bean = getBean(fieldName);
                    field.setAccessible(true);
                    field.set(object, bean);
                }
            }
        }
    }
}
