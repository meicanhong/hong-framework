package hongframework.core.io;

/**
 * @Author: canhong
 * @Date: 2022/6/6 0:07
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
