package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import constants.ControlConstants;

public class Dao {
	protected Connection connection;
	protected Statement statement;
	public Dao() {
		try {
			Class.forName(ControlConstants.JDBC_DRIVER);
			this.connection = DriverManager.getConnection(ControlConstants.DB_URL, ControlConstants.USER_NAME, ControlConstants.PASSWORD);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {e.printStackTrace();}
	}
	
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
	public ResultSet select(String query) {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			return resultSet;
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
}
