package model;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
	public Dao() {
		try {
			// config.xml에 설정한 정보를 받아와 reader에 담음.
			Reader reader = Resources.getResourceAsReader("resources/mybatis-config.xml");
			/*
			 *  받아온 정보를 SqlSessionFactoryBuilder()를 통해서 
			 *  빌드-> build(reader)하고 
			 *  세션을 열어준다. -> openSession()
			 */
			this.session = new SqlSessionFactoryBuilder().build(reader).openSession();
			
			// 마이바티스로 바꾸면서 없어질 부분
			Class.forName(ControlConstants.JDBC_DRIVER);
			this.connection = DriverManager.getConnection(ControlConstants.DB_URL, ControlConstants.USER_NAME, ControlConstants.PASSWORD);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {e.printStackTrace();}
	}
	
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
	public void insert(String query) {
		try {
			statement = connection.createStatement();
			statement.execute(query);
		} catch (Exception e) {e.printStackTrace();}
	}
}
