package com.cardealershipinventory.commad;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.cardealershipinventory.model.CarInventory;

public class Commands {
	@Autowired
	private CarInventory carInvent;
	public String inputCommands() {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println("Make :");
		String make = sc.nextLine();
		carInvent.setMake(make);

		System.out.println("Model :");
		String model = sc.nextLine();
		carInvent.setModel(model);

		System.out.println("Year :");
		int year = sc.nextInt();
		carInvent.setYear(year);

		System.out.println("SalePrice :");
		int saleprice = sc.nextInt();
		carInvent.setSalePrice(saleprice);
		
		return line;

	
	}
	
	public int inputCommand() {
		Scanner sc = new Scanner(System.in);
                  int num = sc.nextInt();
		return num;
		
	}

}
