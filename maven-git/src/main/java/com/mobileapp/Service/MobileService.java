package com.mobileapp.Service;

import com.mobileapp.DTO.*;
import com.mobileapp.Exceptions.CustomException;

import java.util.List;

public interface MobileService 
{
	boolean makePurchase(PurchaseDTO purchase) throws CustomException;
	boolean updateQuantity(int mobileId) throws CustomException;
	boolean deleteMobile(int mobileId) throws CustomException;
	boolean addMobile(MobileDTO mobile) throws CustomException;
	List<MobileDTO> displayAllMobiles() throws CustomException;
	List<MobileDTO> searchMobileRange(float low, float high) throws CustomException;
}
