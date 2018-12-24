package framework;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class SqlSessionFactoryBuilder {
    public static SqlSessionFactory build(){
        DefaultSqlSessionFactory defaultSqlSessionFactory=null;
        try {
            Properties properties=PropertiesUtil.getProperties("db.properties");
            ConfigurationBuiler configurationBuiler=new ConfigurationBuilerImpl(properties);
            configurationBuiler.buildDriver();
            configurationBuiler.buildUrl();
            configurationBuiler.buildUsername();
            configurationBuiler.buildPassword();
            configurationBuiler.buildMapperRegister();
            Configuration configuration=configurationBuiler.buildConfiguration();
            defaultSqlSessionFactory=new DefaultSqlSessionFactory(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultSqlSessionFactory;
    }
}
