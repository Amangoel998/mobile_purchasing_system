package com.mobileapp.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.mobileapp.Exceptions.CustomException;

public final class DBConnect {
	private static Connection conn = null; 
	private static FileInputStream fp;
	private DBConnect() throws IOException, SQLException{
		String JDBC_URL, JDBC_USER, JDBC_PASSWD;
		fp = new FileInputStream("resource/oracle.properties");
		Properties db_properties = new Properties();
		db_properties.load(fp);
		fp.close();
		JDBC_URL = db_properties.getProperty("jdbc.url");
		JDBC_USER = db_properties.getProperty("jdbc.user");
		JDBC_PASSWD = db_properties.getProperty("jdbc.password");
		conn =  DriverManager.getConnection (JDBC_URL, JDBC_USER, JDBC_PASSWD);
	}
	public static Connection getDB() throws CustomException{
		if(conn==null){
			try{
				new DBConnect();
			}catch(Exception e){
				throw new CustomException("Couldn't connect to Database", e);
			}
		}
		return conn;
	}
}
