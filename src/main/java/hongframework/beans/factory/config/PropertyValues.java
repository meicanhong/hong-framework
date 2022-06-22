package hongframework.beans.factory.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: canhong
 * @Date: 2022/6/5 10:56
 */
public class PropertyValues {
    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValues.toArray(propertyValues.toArray(new PropertyValue[0]));
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValues) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
