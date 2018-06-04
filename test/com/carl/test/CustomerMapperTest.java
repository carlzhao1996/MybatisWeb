package com.carl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.carl.dao.CustomerMapper;
import com.carl.pojo.Customer;
import com.carl.utils.MyBatisUtil;

class CustomerMapperTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetCount() {
		//1. Get mybatis-config.xml input stream
		String resource="mybatis/mybatis-config.xml";
		SqlSession sqlsession = null;
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			//2. set up SqlSessionFactory Object and therefore finalize file reading
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3. Set up SqlSession
			 sqlsession = factory.openSession();
			//4. Get mapper file to operate data. Required to firstly input the file to mybatis-config.xml.
			int count = sqlsession.selectOne("com.carl.dao.CustomerMapper.getCount");
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
 
	}
	@Test
	public void testGetCustomerList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Customer> custlist = sqlSession.getMapper(CustomerMapper.class).getCustomerList();
		MyBatisUtil.closeSqlSession(sqlSession);
		for (Customer cust: custlist) {
			System.out.println(cust.getCu_name()+"\t"+cust.getCu_password()+"\t"+cust.getGender());
		}
	}
	
	@Test
	public void testGetCustomerByName() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		try {
			List<Customer> custs = sqlSession.getMapper(CustomerMapper.class).getCustomerByName("B");
			for (Customer customer : custs) {
				System.out.println(customer.getCu_name()+"\t"+
						customer.getCu_password()+"\t"+
							customer.getGender());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		
	}

}
