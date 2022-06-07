package hongframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: canhong
 * @Date: 2022/6/6 0:06
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
