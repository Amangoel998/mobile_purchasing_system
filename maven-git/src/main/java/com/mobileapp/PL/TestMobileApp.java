package com.mobileapp.PL;

import static com.mobileapp.utility.Input.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.mobileapp.DTO.MobileDTO;
import com.mobileapp.Exceptions.CustomException;
import com.mobileapp.Service.*;

public class TestMobileApp {
	private static MobileService mobsService=new MobileServiceImpl();
	private static Logger logger =  Logger.getRootLogger();
	static{
		try{
			PropertyConfigurator.configure("resource/log4j.properties");
		}catch(Exception e){
			System.out.println("File Error");
		}
		logger.setLevel(Level.WARN);
	}
	public static void main(String[] args) throws SQLException 
	{
		int choice;
		while(true)
		{
			displayMenu();
			choice = inputInt("Choice");
			switch(choice)
			{
			case 1 :
				try{
					System.out.println("Following are Avaiable Mobiles");
					List<MobileDTO> l = mobsService.displayAllMobiles();
					l.stream().forEach(System.out::println);
					if(mobsService.makePurchase(inputPurchase())){
						System.out.println("Purchase is Successfull");
					}
				}catch(CustomException e){
					logger.error(e);
					System.out.println(e.getMessage());
				}
				break;
			case 2 :
				try{
					List<MobileDTO> l = mobsService.displayAllMobiles();
					l.stream().forEach(System.out::println);
				}catch(CustomException e){
					logger.error(e);
					System.out.println(e.getMessage());
				}
				break;
			case 3 :
				try{
					if(mobsService.deleteMobile(inputMobileId("Mobile ID"))){
						System.out.println("Delete is Successfull");
					}
				}catch(CustomException e){
					logger.error(e);
					System.out.println(e.getMessage());
				}
				break;
			case 4 :
				try{
					List<MobileDTO> l = mobsService.searchMobileRange(inputPrice("Low Price"), inputPrice("High Price"));
					l.stream().forEach(System.out::println);
				}catch(CustomException e){
					logger.error(e);
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try{
					if(mobsService.updateQuantity(inputMobileId("Mobile ID"))){
						System.out.println("Update is Successfull");
					}
				}catch(CustomException e){
					logger.error(e);
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try{
					if(mobsService.addMobile(inputMobile())){
						System.out.println("Inserting Mobile is Successfull");
					}
				}catch(CustomException e){
					logger.error(e);
					System.out.println(e.getMessage());
				}
				break;
			default :
				System.out.println("Thank you");;
			
			}
		}
	}
	private static void displayMenu(){
		System.out.println("------Menu For Mobile Purcahse------");
		System.out.println("1.Purchase Mobile");
		System.out.println("2.All Mobile detail");
		System.out.println("3.Delete Mobile based on mobile id");
		System.out.println("4.Search mobile between price");
		System.out.println("5.Update Mobile Quantity");
		System.out.println("6.Add Mobile");
		System.out.println("Any other to Exit\n");
	}
}
