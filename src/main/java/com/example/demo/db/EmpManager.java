package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.EmpVo;

public class EmpManager {

	private static SqlSessionFactory factory;
	static{
		try{
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}	
	}
	
	public static List<EmpVo> listAll(){		
		SqlSession session = factory.openSession();
		List<EmpVo> list = session.selectList("empvo.selectAll");
		session.close();
		return list;
	}
}
