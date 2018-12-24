package framework;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class DefaultSqlSession implements SqlSession{
    Configuration configuration=null;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public Mapper getMapper(Class<?> mapperClass) {
        return null;
    }

    public Object select() {
        IJdbcTemplate iJdbcTemplate=new JdbcTemplete(this.configuration);
        return iJdbcTemplate.select();
    }
}
