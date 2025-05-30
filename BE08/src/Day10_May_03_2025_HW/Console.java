package Day10_May_03_2025_HW;

import java.util.Scanner;

public class Console {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome.");
		System.out.println();

		for (int i = 0; i < Database.Shop_DB.size(); i++) {
			System.out.println((i + 1) + ". " + Database.Shop_DB.get(i).name);
		}

		System.out.println();
		System.out.print("Choose an option: ");
		int shopChoice = scanner.nextInt();
		scanner.nextLine();

		Shop currentShop = Database.Shop_DB.get(shopChoice - 1);

		Customer currentCustomer = null;
		boolean returnToLogin = true;

		while (returnToLogin) {
			Print.loginHome();
			String loginChoice = scanner.nextLine();

			if (loginChoice.equals("1")) {
				int attempts = 0;
				while (attempts < 3) {
					System.out.println();
					System.out.print("ID: ");
					String inputId = scanner.nextLine();
					System.out.print("Password: ");
					String inputPassword = scanner.nextLine();

					currentCustomer = currentShop.login(inputId, inputPassword);
					if (currentCustomer != null) {
						returnToLogin = false;
						break;
					}
					attempts++;
					System.out.println();
					System.out.println("Incorrect credentials. Attempts left: " + (3 - attempts));
				}
				if (currentCustomer == null) {
					Print.loginRetry();
					String retryChoice = scanner.nextLine();
					if (retryChoice.equals("2")) {
						return;
					}
				}
			} else {
				System.out.print("New ID: ");
				String newId = scanner.nextLine();
				if (currentShop.idExists(newId)) {
					System.out.println("ID already exists. Please try again.");
					continue;
				}
				System.out.print("New Password: ");
				String newPassword = scanner.nextLine();
				String newRank = "None";
				Customer newCustomer = new Customer(newId, newPassword, newRank);
				currentShop.addCustomer(newCustomer);
				System.out.println("Registration successful. Please log in.");
			}
		}

		CartItem[] cart = new CartItem[50];
		int cartSize = 0;

		while (true) {
			Print.mainMenu();
			String menuChoice = scanner.nextLine();

			if (menuChoice.equals("1")) {
				CartService.viewCart(cart, cartSize);
			} else if (menuChoice.equals("2")) {
				System.out.println();
				System.out.println("Your Rank: " + currentCustomer.rank);
				System.out.println("Promotion: " + currentCustomer.showPromotion());
			} else if (menuChoice.equals("3")) {
				while (true) {
					System.out.println("\nPRODUCT MENU");
					for (int i = 0; i < currentShop.products.length; i++) {
						Product prod = currentShop.products[i];
						System.out.println((i + 1) + ". " + prod.name + " - $" + prod.price);
					}
					System.out.println("0. Back to MAIN MENU");
					System.out.println();
					System.out.print("Choose an option: ");
					String productChoice = scanner.nextLine();

					if (productChoice.equals("0"))
						break;

					boolean validProduct = false;
					for (int i = 0; i < currentShop.products.length; i++) {
						String productChoiceStr = String.valueOf(i + 1);
						if (productChoice.equals(productChoiceStr)) {
							Product selectedProduct = currentShop.products[i];
							System.out.println();
							System.out.print("Quantity: ");
							String quantity = scanner.nextLine();
							boolean validQuantity = false;

							if (quantity.length() > 0 && quantity.length() <= 3) {
								boolean maxNum = true;
								for (int j = 0; j < quantity.length(); j++) {
									if (quantity.charAt(j) < '0' || quantity.charAt(j) > '9') {
										maxNum = false;
										break;
									}
								}

								if (maxNum) {
									int numQuantity = 0;
									for (int j = 0; j < quantity.length(); j++) {
										numQuantity = numQuantity * 10 + (quantity.charAt(j) - '0');
									}

									if (numQuantity >= 1 && numQuantity <= 100) {
										cart[cartSize++] = new CartItem(selectedProduct.name, selectedProduct.price,
												numQuantity);
										validQuantity = true;
									}
								}
							}

							if (!validQuantity) {
								System.out.println();
								System.out.println("Invalid quantity.");
							}
							validProduct = true;
							break;
						}
					}

					if (!validProduct) {
						System.out.println();
						System.out.println("Invalid option.");
					}
				}
			} else if (menuChoice.equals("4")) {
				if (cartSize == 0) {
					System.out.println();
					System.out.println("Your cart is empty.");
					continue;
				}

				CartService.viewCart(cart, cartSize);
				System.out.print("Enter item number to remove: ");
				String removeChoice = scanner.nextLine();
				boolean found = false;

				if (removeChoice.length() > 0 && removeChoice.length() <= 2) {
					boolean allDigits = true;
					for (int i = 0; i < removeChoice.length(); i++) {
						if (removeChoice.charAt(i) < '0' || removeChoice.charAt(i) > '9') {
							allDigits = false;
							break;
						}
					}

					if (allDigits) {
						int removeIndex = 0;
						for (int i = 0; i < removeChoice.length(); i++) {
							removeIndex = removeIndex * 10 + (removeChoice.charAt(i) - '0');
						}

						if (removeIndex >= 1 && removeIndex <= cartSize) {
							removeIndex--; // Adjust for 0-based index
							for (int j = removeIndex; j < cartSize - 1; j++) {
								cart[j] = cart[j + 1];
							}
							cartSize--;
							System.out.println();
							System.out.println("Item removed.");
							found = true;
						}
					}
				}

				if (!found) {
					System.out.println("Invalid index.");
				}
			} else if (menuChoice.equals("0")) {
				if (CartService.checkout(cart, cartSize, currentCustomer)) {
					break;
				}
			}
		}
		CartService.viewCart(cart, cartSize);
		CartService.checkout(cart, cartSize, currentCustomer);
	}
}

// Prioritise data segregation, using multiple classes (and subclasses if possible). [ENCAPSULATION]
// Eg. Console
// Console
// Shop => (Product => ShoppingCart + CartItem) + (Customer)
// There should be an private static void initData function to add demo data.
// Final, static, etc.
// Non-static txt read. Timeline-based.
// Re-read databases every time after critical operations.
// Environment class for static variables.
// Try utilising Encapsulation and Polymorphism
// Minimise impacts towards other classes.
// Prioritise changing services (operations) not main/console.
// INHERITANCE & POLYMORPHISM & DESIGN PATTERN FACTORY (refactoring.guru)
// ABSTRACTION - use it as a mold/template for similar functions/objects (concrete class). - Think about the similarity between.
// Abstraction vs Interface. extends (functions and attributes) vs implements (only functions). 