package framework;

import service.UserMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class JdbcTemplete implements IJdbcTemplate{
    Configuration configuration=null;
    Connection connection=null;

    public JdbcTemplete(Configuration configuration) {
        this.configuration = configuration;
    }

    public Connection getConnection(){
        try {
            Class.forName(this.configuration.getJdbcDriver());
            connection= DriverManager.getConnection(this.configuration.getJdbcUrl(),this.configuration.getJdbcUsername(),this.configuration.getJdbcPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Object select() {
        Object o=null;
        Map<String,String> mapperRegister=this.configuration.getMapperResigter();
        try {
            /*Class clazz=Class.forName(mapperRegister.get("namespace"));
            Object object=clazz.newInstance();*/
            Resource resource=new Resource();
            Class<?> object=resource.classForName(mapperRegister.get("namespace"));
            UserMapper userMapper= (UserMapper) new MapperProxy(this.configuration).bind(object);
            o=userMapper.select();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}
