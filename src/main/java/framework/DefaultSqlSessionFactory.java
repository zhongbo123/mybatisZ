package framework;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    Configuration configuration=null;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSqlSession() {
        return new DefaultSqlSession(this.configuration);
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }
}
