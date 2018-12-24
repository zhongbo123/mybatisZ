package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class ResourceUtil {
    public static InputStream getInputStreamResource(String path) throws FileNotFoundException {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }
}
