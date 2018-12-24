package framework;

/**
 * Created by zhongbo on 2018/12/24.
 */
public interface SqlSessionFactory {
    public SqlSession openSqlSession();

    public Configuration getConfiguration();
}
