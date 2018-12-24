package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class PropertiesUtil {
    public static Properties getProperties(String propertieName) throws IOException {
        InputStream inputStream=ResourceUtil.getInputStreamResource(propertieName);
        Properties properties=new Properties();
        properties.load(inputStream);
        return properties;
    }
}
