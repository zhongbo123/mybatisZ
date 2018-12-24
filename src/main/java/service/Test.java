package service;

import framework.SqlSession;
import framework.SqlSessionFactory;
import framework.SqlSessionFactoryBuilder;

/**
 * Created by zhongbo on 2018/12/24.
 */
public class Test {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory=SqlSessionFactoryBuilder.build();
        SqlSession sqlSession=sqlSessionFactory.openSqlSession();
        sqlSession.select();
    }
}
