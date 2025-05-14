package Day10_May_03_2025_HW;

import java.util.ArrayList;

public class Database {

	static final ArrayList<Shop> Shop_DB = new ArrayList<>();

	static {
		Product[] shopAProducts = new Product[4];
		shopAProducts[0] = new Product("Flower", 3);
		shopAProducts[1] = new Product("Toy", 5);
		shopAProducts[2] = new Product("Phone", 100);
		shopAProducts[3] = new Product("Chair", 25);
		Shop shopA = new Shop("Shop A", shopAProducts, 10);
		shopA.addCustomer(new Customer("user1", "pass", "Silver"));
		shopA.addCustomer(new Customer("user2", "pass", "Gold"));
		Shop_DB.add(shopA);

		Product[] shopBProducts = {
				new Product("Cup", 6),
				new Product("Doll", 9),
				new Product("Laptop", 300),
				new Product("Table", 35) };
		Shop shopB = new Shop("Shop B", shopBProducts, 10);
		shopB.addCustomer(new Customer("user3", "1234", "Diamond"));
		shopB.addCustomer(new Customer("user4", "1234", "None"));
		Shop_DB.add(shopB);

	}

	public static Shop selectShop(String name) {
		for (int i = 0; i < Database.Shop_DB.size(); i++) {
			Shop selectShop = Database.Shop_DB.get(i);
			if (selectShop.name.equals(name)) {
				return selectShop;
			}
		}
		return null;
	}
}
