package com.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	/**
	 * create a static connection object
	 */
	private static Connection connection;
	/**
	 * Function to get connection
	 * @return
	 */
	public static Connection getConnection()
	{
		try {
			if(connection==null||connection.isClosed())
				new DBConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  connection;
	}
	
	/**
	 * Function to create a connection
	 */
	private DBConnection()
	{
	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String username="pooja";
			String password="pooja";
			String url="jdbc:sqlserver://127.0.0.1\\SQLEXPRESS"+";databaseName=ITBazar";
			connection=DriverManager.getConnection(url,username,password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	
	
	
}
