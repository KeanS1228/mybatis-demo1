package org.shitj;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.shitj.mapper.TestMapper;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 这里因为在 mybatis.xml 里配了，所以可以不写
//        sqlSessionFactory.getConfiguration().addMapper(TestMapper.class);
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        System.out.println(testMapper.selectById());
    }
}