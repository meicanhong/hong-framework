package hong.framework.ioc.bean;

import lombok.Data;

import java.util.List;

/**
 * @Author: canhong
 * @Date: 2022/5/12 11:21
 */
@Data
public class BeanDefinition {
    private String name;
    private String className;
    private String[] interfaceNames;
    private List<ConstructorArg> constructorArgs;
    private List<PropertyArg> propertyArgs;
}
