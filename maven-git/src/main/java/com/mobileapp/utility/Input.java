package com.mobileapp.utility;

import java.time.LocalDate;
import java.util.Scanner;
import java.sql.Date;

import com.mobileapp.DTO.MobileDTO;
import com.mobileapp.DTO.PurchaseDTO;
import com.mobileapp.Exceptions.CustomException;

public class Input{
	static Scanner sc = new Scanner(System.in);
	
	public static int inputMobileId(String s){
		int id;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				Thread.sleep(1000);
				id = sc.nextInt();
				if(Validator.isValidId(id))
					return id;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid "+s+", enter again");
				sc.nextLine();
			}
		}
	}
	public static String inputName(String s){
		String st;
		sc.nextLine();
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				st = sc.nextLine();
				if(Validator.isValidName(st))
					return st;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid, enter again");
			}
		}
	}
	public static String inputPhone(String s){
		String st;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				st = sc.next();
				if(Validator.isValidPhone(st))
					return st;
				else throw new Exception();
			}catch(Exception e){
				System.err.println("Invalid "+s+", enter again");
			}
		}
	}
	public static String inputEmail(String s){
		String st;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				st = sc.next();
				if(Validator.isValidEmail(st))
					return st;
				else throw new Exception();
			}catch(Exception e){
				System.out.println("Invalid "+s+", enter again");
			}
		}
	}
	public static Date inputDate(String s){
		System.out.println("Enter "+s+": ");
		while(true){
			try{
				System.err.println("Enter Year Month Day");
				int d = sc.nextInt(), m = sc.nextInt(), y = sc.nextInt();
				LocalDate ld = LocalDate.of(y, m, d);
				return Date.valueOf(ld);
			}catch(Exception e){
				System.out.println("Invalid "+s+", enter again: ");
			}
		}
	}
	public static float inputPrice(String s){
		float f;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				f = sc.nextFloat();
				return f;
			}catch(CustomException e){
				System.out.println("Invalid "+s+", enter again: ");
			}
		}
	}
	public static int inputQuantity(String s){
		int f;
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				f = sc.nextInt();
				if(Validator.isValidQuantity(f))
					return f;
			}catch(CustomException e){
				System.out.println("Invalid "+s+", enter again");
			}
		}
	}
	public static PurchaseDTO inputPurchase(){
		return new PurchaseDTO(inputMobileId("Mobile ID"),
				inputName("Customer Name"),
				inputEmail("Email"),
				inputPhone("Phone Number"));
	}
	public static MobileDTO inputMobile(){
		return new MobileDTO(inputMobileId("Mobile ID (4 Digits)"),
				inputName("Mobile Name"),
				inputPrice("Price"),
				inputQuantity("Mobile Quantity"));
	}
//
	public static int inputInt(String s){
		while(true){
			try{
				System.out.println("Enter "+s+": ");
				int i = sc.nextInt();
				return i;
			}catch(Exception e){
				System.out.println("Invalid "+s+", enter again");
			}
		}
	}
//	public static String inputString(String s){
//		while(true){
//			System.out.println("Enter "+s+": ");
//			try{
//				return sc.next();
//			}catch(Exception e){
//				System.out.println("Invalid "+s+"\nEnter again: ");
//			}
//		}
//	}
//	public static String inputStringLine(String s){
//		while(true){
//			System.out.println("Enter "+s+": ");
//			try{
//				return sc.nextLine();
//			}catch(Exception e){
//				System.out.println("Invalid "+s+"\n");
//			}
//		}
//	}
//	public static boolean inputBool(String s){
//		while(true){
//			System.out.println("Enter "+s+": ");
//			try{
//				boolean b = sc.nextBoolean();
//				return b;
//			}catch(Exception e){
//				System.out.println("Invalid "+s+"\nEnter again: ");
//			}
//		}
//	}
//
//	public static double inputDouble(String s){
//		while(true){
//			System.out.println("Enter "+s+": ");
//			try{
//				return sc.nextDouble();
//			}catch(Exception e){
//				System.out.println("Invalid "+s+"\nEnter again: ");
//			}
//		}
//	}
//	
//	public static long inputLong(String s){
//		long st;
//		while(true){
//			System.out.println("Enter "+s+": ");
//			try{
//				st = sc.nextLong();
//				return st;
//			}catch(Exception e){
//				System.out.println("Invalid "+s+"\nEnter again: ");
//			}
//		}
//	}
//	public static EmployeeDTO inputEmployee() throws CustomException{
//		System.out.println("Enter Employee Details:");
//		return new EmployeeDTO(
//				inputInt("Employee ID"),
//				inputInt("ManagerID"),
//				inputName("First Name"),
//				inputName("Last Name"),
//				inputName("Designation"),
//				inputEmail("Email"),
//				inputString("Phone Number"),
//				inputDate("Hiredate"),
//				inputInt("Salary"),
//				inputDepartment());
//	}
}