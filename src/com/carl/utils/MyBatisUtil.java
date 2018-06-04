package com.carl.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	//factory can only be set once
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
			factory= new SqlSessionFactoryBuilder().build(is,"development");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Get SqlSession
	 * @return SqlSession
	 * */ 
	public static SqlSession getSqlSession() {
		return factory.openSession(false);
	}
	/**
	 * Close SqlSession
	 */
	public static void closeSqlSession(SqlSession sqlSession) {
		if(sqlSession!=null) {
			sqlSession.close();
		}
	}
}
