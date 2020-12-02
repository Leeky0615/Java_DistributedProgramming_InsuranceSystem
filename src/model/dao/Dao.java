package model.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Dao {
	// 사용될 SqlSession 인스턴스
	protected SqlSession session;
	
	public Dao() {
		try {
			// config.xml에 설정한 정보를 받아와 reader에 담음.
			Reader reader = Resources.getResourceAsReader("resources/mybatis-config.xml");
			/*
			 *  받아온 정보를 SqlSessionFactoryBuilder()를 통해서 
			 *  빌드-> build(reader)하고 
			 *  세션을 열어준다. -> openSession()
			 */
			this.session = new SqlSessionFactoryBuilder().build(reader).openSession(true);
		} catch (Exception e) {e.printStackTrace();}
	}
	// session의 insert함수 호출 -> 파라미터로 매핑된 클래스.태그 와 객체(DB에 들어갈 데이터가 담김)를 사용
	public void insert(String query, Object object) {session.insert(query+".Insert",object);}
	
	// session의 update함수 호출 -> 파라미터로 매핑된 클래스.태그 와 객체(DB에 들어갈 데이터가 담김)를 사용
	public void update(String query, Object object) {session.update(query+".Update",object);}
	
	// session의 delete함수 호출 -> 파라미터로 매핑된 클래스.태그 와 객체(DB에 들어갈 데이터가 담김)를 사용
	public void delete(String query, Object object) {session.insert(query+".Delete",object);}
}
