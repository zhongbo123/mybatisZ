package framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class MapperProxy implements InvocationHandler{

    Class<?> target=null;
    Configuration configuration=null;

    public MapperProxy(Configuration configuration) {
        this.configuration = configuration;
    }

    public Object bind(Class<?> target){
        this.target=target;
        return Proxy.newProxyInstance(this.target.getClassLoader(),new Class[]{this.target},this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Connection connection=new JdbcTemplete(this.configuration).getConnection();
        Map<String,String> mapperRegister=this.configuration.getMapperResigter();
        String sql=mapperRegister.get("sql");
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        System.out.println("查询完毕");
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        int dataLength=resultSetMetaData.getColumnCount();
        while (resultSet.next()){
            for (int i = 0; i <dataLength ; i++) {
                String colName=resultSetMetaData.getColumnName(i+1);
                System.out.println(resultSet.getObject(colName).toString());
            }

        }
        System.out.println();
        return null;
    }
}
