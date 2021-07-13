package com.cardealershipinventory.model;

public class CarInventory {

	private String make;
	private String Model;
	private int year;
	private float salePrice;
	

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}



	@Override
	public String toString() {
		return "CarInventory [make=" + make + ", Model=" + Model + ", year=" + year + ", salePrice=" + salePrice + "]";
	}
	
	
	
	

}
