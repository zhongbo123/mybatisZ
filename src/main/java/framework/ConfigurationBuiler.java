package framework;

/**
 * Created by zhongbo on 2018/12/24.
 */
public interface ConfigurationBuiler {
    public void buildDriver();
    public void buildUrl();
    public void buildUsername();
    public void buildPassword();
    public void buildMapperRegister();
    public Configuration buildConfiguration();
}
