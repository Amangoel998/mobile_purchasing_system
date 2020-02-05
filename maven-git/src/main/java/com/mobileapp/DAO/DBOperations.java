package com.mobileapp.DAO;

import com.mobileapp.DTO.*;
import com.mobileapp.Exceptions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

public class DBOperations {
	private static Connection connection = null;
	private static PreparedStatement prepare_statement=null;
	private static ResultSet result_set=null;
	private static Set<Integer> mobileIds = new TreeSet<Integer>();
	static{
		connection = DBConnect.getDB();
		if(connection==null)
			throw new CustomException("Connection NOT Successful");
		try {
			mobileIds = getAvailableMobiles();
		} catch (SQLException e) {
			throw new CustomException("Fetching Mobiles NOT Successful");
		}
	}
//		try {
//			createPurchaseTable();
//			createSequence();
//			insertIntoMobilesTable();
//		} catch (SQLException e) {
//			throw new CustomException("Creation NOT Successful", e);
//		}
	public boolean hasMobileId(int id){
		return mobileIds.contains(id);
	}
	public static Set<Integer> getAvailableMobiles() throws SQLException{
		prepare_statement = connection.prepareStatement("SELECT mobileid from mobiles");
		result_set = prepare_statement.executeQuery();
		mobileIds.clear();
		// Adding valid mobile IDs into Set
		while(result_set.next())
			mobileIds.add(result_set.getInt(1));
		return mobileIds;
	}
//	private static void createMobilesTable() throws SQLException{
//		String create_table = "CREATE TABLE mobiles "
//				+ "(mobileid NUMBER PRIMARY KEY, "
//				+ "name VARCHAR2(20), "
//				+ "price NUMBER(10,2), "
//				+ "quantity VARCHAR2(20))";
//		prepare_statement = connection.prepareStatement(create_table);
//		boolean flag = prepare_statement.execute();
//		if(!flag){
//			throw new CustomException("Couldn't Create the Mobile Table");
//		}
//	}
//	private static void insertIntoMobilesTable() throws SQLException{
//		String create_table = "INSERT INTO mobiles VALUES(mobile_inc_seq.nextval, 'Nokia Lumia 520', 8000,20);"+
//				"INSERT INTO mobiles VALUES(mobile_inc_seq.nextval, 'Samsung Galaxy IV', 38000,40);"+
//				"INSERT INTO mobiles VALUES(mobile_inc_seq.nextval, 'Sony xperia C', 15000,30);";
//		prepare_statement = connection.prepareStatement(create_table);
//		prepare_statement.executeUpdate();
//		
//	}
	public int updateMobileQuantity(int mobileid, MobileDTO mobile) throws SQLException{
		if(!hasMobileId(mobileid))return 0;
		String update_table = "UPDATE TABLE mobiles SET quantity=? WHERE Mobileid=?";
		prepare_statement = connection.prepareStatement(update_table);
		prepare_statement.setString(1, String.valueOf(mobile.getQuantity()));
		prepare_statement.setInt(2, mobileid);
		int flag = prepare_statement.executeUpdate();
		if(flag>0)getAvailableMobiles();
		return flag;
	}
//	private static void createPurchaseTable() throws SQLException{
//		String create_table = "CREATE TABLE purchasedetails"
//				+ "(purchaseid NUMBER, "
//				+ "cname VARCHAR2(20), "
//				+ "mailid VARCHAR2(30), "
//				+ "phoneno VARCHAR2(20), "
//				+ "purchasedate DATE, "
//				+ "mobileid references mobiles(mobileid));";
//		prepare_statement = connection.prepareStatement(create_table);
//		boolean flag = prepare_statement.execute();
//		if(!flag)
//			throw new CustomException("Couldn't Create the Table");
//	}
	public int insertIntoPurchaseTable(PurchaseDTO m) throws SQLException{
		String create_table = "INSERT INTO purchasedetails VALUES("
				+ "purchase_inc_seq.nextval,?,?,?,?,?)";
		prepare_statement = connection.prepareStatement(create_table);
		prepare_statement.setString(1,m.getCname());
		prepare_statement.setString(2,m.getMailid());
		prepare_statement.setString(3,m.getPhoneno());
		prepare_statement.setDate(4,m.getPurchasedate());
		prepare_statement.setInt(5,m.getMobileid());
		return prepare_statement.executeUpdate();
	}
	public int insertMobile(MobileDTO m) throws SQLException{
		String create_table = "INSERT INTO mobiles VALUES(?,?,?,?)";
		prepare_statement = connection.prepareStatement(create_table);
		prepare_statement.setInt(1,m.getMobile_id());
		prepare_statement.setString(2,m.getName());
		prepare_statement.setFloat(3, m.getPrice());
		prepare_statement.setString(4, String.valueOf(m.getQuantity()));
		return prepare_statement.executeUpdate();
	}
	public int deleteMobile(int mid) throws SQLException{
		String delete_mobile = "DELETE FROM mobiles WHERE mobileid=?";
		prepare_statement = connection.prepareStatement(delete_mobile);
		prepare_statement.setInt(1,mid);
		return prepare_statement.executeUpdate();
	}
	public ResultSet allMobileDetail() throws SQLException {
		String select_all_mobiles = "Select * from mobiles";
	    prepare_statement = connection.prepareStatement(select_all_mobiles);
		result_set = prepare_statement.executeQuery();
		return result_set;
	}
	public ResultSet mobileRangeDetail(float low, float high) throws SQLException {
		String select_all_mobiles = "Select * from mobiles WHERE price BETWEEN ? AND ?";
	    prepare_statement = connection.prepareStatement(select_all_mobiles);
	    prepare_statement.setFloat(1, low);
	    prepare_statement.setFloat(2, high);
	    result_set = prepare_statement.executeQuery();
		return result_set;
	}
	public int getQuantity(int id) throws SQLException{
		int quant;
		String select_quat = "SELECT quantity FROM Mobiles WHERE mobileid=?;";
		prepare_statement = connection.prepareStatement(select_quat);
		prepare_statement.setInt(1, id);
		result_set = prepare_statement.executeQuery();
		result_set.next();
		quant = result_set.getInt(1);
		return quant;
	}
//	public boolean isAvailable(int id) throws SQLException{
//		if (!hasMobileId(id))
//			throw new CustomException("Does not contain this Mobile ID");
//		int quantity = getQuantity(id);
//		if(quantity>0)
//			return true;
//		return false;	
//	}
	
//	private static void createSequence() throws SQLException{
//		String create_mobile_sequence =
//				"CREATE SEQUENCE mobile_inc_seq START WITH 1000 INCREMENT BY 1";
//		String create_puchase_sequence =
//				"CREATE SEQUENCE purchase_inc_seq START WITH 10000 INCREMENT BY 1";
//		prepare_statement = connection.prepareStatement(create_mobile_sequence);
//		boolean flag = prepare_statement.execute();
//		if(!flag)
//			throw new CustomException("Couldn't Create the Mobile sequence");
//		prepare_statement = connection.prepareStatement(create_puchase_sequence);
//		flag = prepare_statement.execute();
//		if(!flag)
//			throw new CustomException("Couldn't Create the Purchase sequence");
//	}
}
