package com.mobileapp.DTO;

public final class MobileDTO {
	private int mobile_id;
	private String name;
	private int quantity;
	private float  price;
	
	public MobileDTO(int mobile_id, String name,  float price, int quantity) {
		this.mobile_id = mobile_id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public String toString(){
		return "Mobile ID: "+mobile_id+"\n"
				+ "Moble Name: "+name+"\n"
				+ "Mobile Price: "+price+"\n"
				+"Mobile Quantity: "+quantity+"\n";
	}
	public int getMobile_id() {
		return mobile_id;
	}
	public void setMobile_id(int mobile_id) {
		this.mobile_id = mobile_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
