package hong.framework.ioc.core;

import hong.framework.ioc.annotation.Component;
import hong.framework.ioc.annotation.Service;
import hong.framework.ioc.bean.BeanDefinition;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

/**
 * @Author: canhong
 * @Date: 2022/5/12 14:33
 */
@Data
@NoArgsConstructor
public class AnnotationApplicationContext extends BeanFactoryImpl {
    private String scanPath;

    public AnnotationApplicationContext(String scanPath) {
        this.scanPath = scanPath;
        init();
    }

    public void init() {
        loadAnnotation();
        try {
            autowired();
        } catch (Exception e) {
            System.out.println(String.format("自动注入失败：%s", e));
        }
    }

    private void loadAnnotation() {
        List<String> classNames = getClassNames();
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        for (String className : classNames) {
            Class<?> clazz = null;
            try {
                clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
            } catch (ClassNotFoundException e) {
                System.out.println(String.format("loadAnnotation时获取类失败：%s", e));
            }
            Component component = clazz.getAnnotation(Component.class);
            Service service = clazz.getAnnotation(Service.class);
            String beanName = toLowerCaseFirstOne(clazz.getSimpleName());
            if (Objects.nonNull(component) && StringUtils.isNotEmpty(component.value())) {
                beanName = component.value();
            }
            if (Objects.nonNull(service) && StringUtils.isNotEmpty(service.value())) {
                beanName =  service.value();
            }
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setClassName(className);
            beanDefinition.setName(beanName);
            beanDefinitions.add(beanDefinition);
        }

        if (CollectionUtils.isNotEmpty(beanDefinitions)) {
            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getName(), beanDefinition);
                try {
                    getBean(beanDefinition.getName());
                } catch (Exception e) {
                    System.err.println(String.format("通过注解创建Bean失败：%s", e));
                }
            }
        }
    }

    private List<String> getClassNames() {
        List<String> classNames = new ArrayList<>();
        try {
            boolean recursive = true;
            String packageDirName = scanPath.replace('.', '/');
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if (Objects.equals(protocol, "file")) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    scanClassesInPackageByFile(scanPath, filePath, recursive, classNames);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return classNames;
    }

    private void scanClassesInPackageByFile(String scanPath, String packagePath, boolean recursive, List<String> classNames) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (recursive && dir.isDirectory() || dir.getName().endsWith(".class"));
            }
        });

        for (File file : files) {
            if (file.isDirectory()) {
                scanClassesInPackageByFile(scanPath + "." + file.getName(), file.getAbsolutePath(), recursive, classNames);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                classNames.add(scanPath + '.' + className);
            }
        }
    }

    private  String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}
