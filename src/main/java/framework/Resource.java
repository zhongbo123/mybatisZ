package framework;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class Resource {

    ClassLoader defaultClassLoader;
    ClassLoader systemClassLoader;

    Resource() {
        try {
            this.systemClassLoader = ClassLoader.getSystemClassLoader();
        } catch (SecurityException var2) {
            ;
        }

    }

    public Class<?> classForName(String name) throws ClassNotFoundException {
        return this.classForName(name, this.getClassLoaders((ClassLoader)null));
    }

    ClassLoader[] getClassLoaders(ClassLoader classLoader) {
        return new ClassLoader[]{classLoader, this.defaultClassLoader, Thread.currentThread().getContextClassLoader(), this.getClass().getClassLoader(), this.systemClassLoader};
    }


    Class<?> classForName(String name, ClassLoader[] classLoader) throws ClassNotFoundException {
        ClassLoader[] arr$ = classLoader;
        int len$ = classLoader.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            ClassLoader cl = arr$[i$];
            if(null != cl) {
                try {
                    Class<?> c = Class.forName(name, true, cl);
                    if(null != c) {
                        return c;
                    }
                } catch (ClassNotFoundException var8) {
                    ;
                }
            }
        }

        throw new ClassNotFoundException("Cannot find class: " + name);
    }
}
