package com.mobileapp.Service;

import com.mobileapp.DAO.*;
import com.mobileapp.DTO.MobileDTO;
import com.mobileapp.DTO.PurchaseDTO;
import com.mobileapp.Exceptions.CustomException;
import com.mobileapp.utility.Input;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileServiceImpl implements MobileService{
	private static MobileDAOImpl dao = null;
	private static boolean flag = false;
	private static ResultSet result = null;
	public MobileServiceImpl() {
		dao = new MobileDAOImpl();
	}
	@Override
	public boolean makePurchase(PurchaseDTO purchase) throws CustomException {
		flag = false;
		try{
			flag = dao.insertPurchase(purchase);
			if(!flag)
				throw new CustomException("Couldn't make Purchase");
			return flag;
		}catch(SQLException e){
			throw new CustomException("SQL Exception Occured while updating mobile", e);
		}catch(Exception e){
			throw new CustomException("Some other Exception while updating mobile", e);
		}
	}

	@Override
	public boolean updateQuantity(int mobileId) throws CustomException {
		flag = false;
		MobileDTO mobile = Input.inputMobile();
		try{
			flag = dao.updateMobileQuantity(mobileId, mobile);
			if(!flag)
				throw new CustomException("Couldn't update mobile");
			return flag;
		}catch(SQLException e){
			throw new CustomException("SQL Exception Occured while updating mobile", e);
		}catch(Exception e){
			throw new CustomException("Some other Exception while updating mobile", e);
		}
	}

	@Override
	public boolean deleteMobile(int mobileId) throws CustomException {
		flag = false;
		try{
			flag = dao.deleteMobile(mobileId);
			if(!flag)
				throw new CustomException("Couldn't delete mobile Entry");
			return flag;
		}catch(SQLException e){
			throw new CustomException("SQL Exception Occured while deleting in mobile", e);
		}catch(Exception e){
			throw new CustomException("Some other Exception while deleting in mobile", e);
		}
	}
	@Override
	public boolean addMobile(MobileDTO mobile) throws CustomException {
		flag = false;
		try{
			flag = dao.addMobile(mobile);
			if(!flag)
				throw new CustomException("Couldn't add new mobile");
			return flag;
		}catch(SQLException e){
			throw new CustomException("SQL Exception Occured while adding in mobile", e);
		}catch(Exception e){
			throw new CustomException("Some other Exception while adding in mobile", e);
		}
	}
	@Override
	public List<MobileDTO> displayAllMobiles() throws CustomException {
		try{
			result = dao.getAllMobiles();
			return getListFromResultSet();
		}catch(SQLException e){
			throw new CustomException("SQL Exception Occured while selecting in mobile", e);
		}catch(Exception e){
			throw new CustomException("Some other Exception while selecting in mobile", e);
		}
	}

	@Override
	public List<MobileDTO> searchMobileRange(float low, float high) throws CustomException {
		try{
			result = dao.getRangeMobiles(low, high);
			return getListFromResultSet();
		}catch(SQLException e){
			throw new CustomException("SQL Exception Occured while selecting range in mobile", e);
		}catch(Exception e){
			throw new CustomException("Some other Exception while selecting range in mobile", e);
		}
	}
	private List<MobileDTO> getListFromResultSet() throws SQLException{
		List<MobileDTO> list = new ArrayList<MobileDTO>();
		MobileDTO mobile = null;
		while(result.next()){
			mobile = new MobileDTO(result.getInt(1),
					result.getString(2),
					Float.parseFloat(result.getString(3)),
					result.getInt(4));
			list.add(mobile);
		}
		return list;
	}
	
}
