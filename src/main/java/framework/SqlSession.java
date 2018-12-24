package framework;

/**
 * Created by zhongbo on 2018/12/24.
 */
public interface SqlSession {
    public Mapper getMapper(Class<?> mapperClass);

    public Object select();
}
