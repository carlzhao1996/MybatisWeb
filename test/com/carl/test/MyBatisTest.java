package com.carl.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

class MyBatisTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testMybatis() {
		/*/MybatisWeb/resources/mybatis/mybatis-config.xml
		 * 1. Get mybatis-config.xml file
		 * 2. Build SqlSessionFactory
		 * 3. Build SqlSession
		 * 4. Output SqlSession object
		 * */
		InputStream is;
		SqlSession sqlSession=null;
		try {
			is = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = sqlSessionFactory.openSession();
			System.out.println(sqlSession);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
}
