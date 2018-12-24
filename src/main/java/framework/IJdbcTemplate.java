package framework;

import java.sql.Connection;

/**
 * Created by zhongbo on 2018/12/24.
 */
public interface IJdbcTemplate {
    public Connection getConnection();

    public Object select();
}
