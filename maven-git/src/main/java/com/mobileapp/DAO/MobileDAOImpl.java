package com.mobileapp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobileapp.DTO.MobileDTO;
import com.mobileapp.DTO.PurchaseDTO;

public class MobileDAOImpl implements MobileDAO{
	private static DBOperations db = new DBOperations();
	@Override
	public boolean insertPurchase(PurchaseDTO purchase) throws SQLException {
//		System.out.println("Available Mobiles: "+db.getAvailableMobiles());
		return (db.insertIntoPurchaseTable(purchase)>0);
	}

	@Override
	public boolean updateMobileQuantity(int mobileid, MobileDTO mobile) throws SQLException {
		return (db.updateMobileQuantity(mobileid, mobile)>0);
	}

	@Override
	public boolean deleteMobile(int mobileId) throws SQLException {
		return (db.deleteMobile(mobileId)>0);
	}
	@Override
	public boolean addMobile(MobileDTO mobile) throws SQLException {
		return (db.insertMobile(mobile)>0);
	}

	@Override
	public ResultSet getAllMobiles() throws SQLException {
		return db.allMobileDetail();
	}

	@Override
	public ResultSet getRangeMobiles(float low, float high) throws SQLException {
		return db.mobileRangeDetail(low, high);
	}
}
