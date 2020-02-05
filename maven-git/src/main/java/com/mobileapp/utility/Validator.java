package com.mobileapp.utility;

import java.util.regex.Pattern;

import com.mobileapp.Exceptions.CustomException;

public class Validator {
	public static boolean isValidId(int id) throws CustomException{
		if(id>9999 || id<1000)
			throw new IllegalArgumentException("Invalid ID");
		return true;
	}
	public static boolean isValidQuantity(int quantity) throws CustomException{
		if(quantity<=0)
			throw new IllegalArgumentException("Invalid Quantity");
		return true;
	}
	public static boolean isValidPhone(String phone) throws CustomException{
		if(!Pattern.matches("^[0-9]{10}", phone))
			throw new IllegalArgumentException("Invalid Phone");
		return true;
	}
	public static boolean isValidName(String name) throws CustomException{
		if(!Pattern.matches("^([A-Z]{1}[a-z]{1,}[\\s]?)+$", name))
			throw new IllegalArgumentException("Invalid Name");
		return true;
	}
	public static boolean isValidAddress(String address) throws CustomException{
		if(!Pattern.matches("^[^_$[\\s]][a-zA-Z_-,#[\\s]]{5-50}", address))
			throw new IllegalArgumentException("Invalid Address");
		return true;
	}
	public static boolean isValidEmail(String email) throws CustomException{
		if(!Pattern.matches("^[A-Za-z0-9\\.]+(@)[A-Za-z0-9\\.]+\\.[A-Za-z]{2,}$", email))
			throw new IllegalArgumentException("Invalid Address");
		return true;
	}
}
