package com.cardealershipinventory.main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cardealershipinventory.commad.Commands;
import com.cardealershipinventory.dao.CarInventoryDao;
import com.cardealershipinventory.model.CarInventory;

class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CarInventoryDao carInventory = context.getBean("carInventDao", CarInventoryDao.class);
		// System.out.println(carInventory);
		System.out.println("Welcome to Mullet Joe's Gently Used Autos!");

		CarInventory carInvent = new CarInventory();

		// System.out.println(carInventory.delete(2000));

		System.out.println("Enter Command :");
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

		if (line.toLowerCase().equals("add")) {
                 
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
			
			System.out.println(carInventory.save(carInvent));

		} else if (line.toLowerCase().equals("list")) {

			List<CarInventory> listOfCar = carInventory.getListOfCar();

			if (listOfCar.size() > 0) {
				
				listOfCar.forEach(carlist -> System.out.println(carlist));
				System.out.println("Number Of Cars : " + listOfCar.size());
				double listOfPrice = listOfCar.stream().mapToDouble(listPrice -> listPrice.getSalePrice()).sum();

				System.out.println("Total Inventory : "+listOfPrice);

			} else {
				System.out.println("There are currently no cars in the catalog.");
			}

		} else if (line.toLowerCase().equals("delete")) {

			System.out.println("Entr " + "'Year'" + " To Remove from Catalog :");

			int delete = sc.nextInt();

			if (delete <= 4) {
				System.out.println(carInventory.delete(delete));
			} else {
				System.out.println("please enter valid year");
			}

		} else if (line.toLowerCase().equals("quit")) {

			System.out.println("Good Bye!");

		} else {
			System.out.println("Sorry, but " + line + " is not a valid command. Please try again.");
		}

	}
}
