package com.mobileapp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobileapp.DTO.*;

public interface MobileDAO {
    boolean insertPurchase(PurchaseDTO purchase) throws SQLException;
    boolean deleteMobile(int mobileId) throws SQLException;
	boolean updateMobileQuantity(int mobileid, MobileDTO mobile) throws SQLException;
	boolean addMobile(MobileDTO mobile) throws SQLException;
    ResultSet getAllMobiles() throws SQLException;
    ResultSet getRangeMobiles(float low, float high) throws SQLException;
}
