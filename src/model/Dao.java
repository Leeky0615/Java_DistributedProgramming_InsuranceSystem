package model;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import constants.ControlConstants;

public class Dao {
	// 마이바티스로 바꾸면서 없어질 부분
	protected Connection connection;
	protected Statement statement;
	
	// 사용될 SqlSession 인스턴스
	protected SqlSession session;
	
	// insert에 사용될 Map
	protected Map<String,Object> param;

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
			
			// new Map
			this.param = new HashMap<String,Object>();
			
			// 마이바티스로 바꾸면서 없어질 부분
			Class.forName(ControlConstants.JDBC_DRIVER);
			this.connection = DriverManager.getConnection(ControlConstants.DB_URL, ControlConstants.USER_NAME, ControlConstants.PASSWORD);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {e.printStackTrace();}
	}
	// session의 insert함수 호출 -> 파라미터로 매핑된 클래스.태그 와 객체(DB에 들어갈 데이터가 담김)를 사용
	public void insert(String query, Object object) {session.insert(query+".Insert",object);}
	
	// 마이바티스로 바꾸면서 없어질 부분
	public void update(String query) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {e.printStackTrace();}
	}
	public void delete(String query) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {e.printStackTrace();}
	}
}
