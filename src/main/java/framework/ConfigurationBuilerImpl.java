package framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class ConfigurationBuilerImpl implements ConfigurationBuiler {
    Configuration configuration=new Configuration();
    Properties properties=null;
    Map<String,String> mapperRegister=new HashMap<String, String>();

    public ConfigurationBuilerImpl(Properties properties) {
        this.properties=properties;
    }

    public void buildDriver() {
        this.configuration.setJdbcDriver(properties.getProperty("jdbc.driver"));
    }

    public void buildUrl() {
        this.configuration.setJdbcUrl(properties.getProperty("jdbc.url"));
    }

    public void buildUsername() {
        this.configuration.setJdbcUsername(properties.getProperty("jdbc.username"));
    }

    public void buildPassword() {
        this.configuration.setJdbcPassword(properties.getProperty("jdbc.password"));
    }

    public void buildMapperRegister() {
        this.mapperRegister.put("namespace",properties.getProperty("namespace"));
        this.mapperRegister.put("sql",properties.getProperty("sql"));
        this.configuration.setMapperResigter(mapperRegister);
    }

    public Configuration buildConfiguration() {
        return this.configuration;
    }
}
