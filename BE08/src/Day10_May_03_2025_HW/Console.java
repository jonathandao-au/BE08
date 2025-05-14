package Day10_May_03_2025_HW;

import java.util.Scanner;

public class Console {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Shop selection

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
			System.out.println();
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println();
			System.out.print("Choose an option: ");
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
					System.out.println("Maximum attempts reached.");
					System.out.println();
					System.out.println("1. Try Login Again");
					System.out.println("2. Exit");
					System.out.println();
					System.out.print("Choose an option: ");
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
				String newRank = "None"; // Default ranking to "None" for new account.
				Customer newCustomer = new Customer(newId, newPassword, newRank);
				currentShop.addCustomer(newCustomer);
				System.out.println("Registration successful. Please log in.");
			}
		}

		CartItem[] cart = new CartItem[50];
		int cartSize = 0;

		while (true) {
			System.out.println();
			System.out.println("MAIN MENU");
			System.out.println("1. View Cart");
			System.out.println("2. Ranking");
			System.out.println("3. View Products");
			System.out.println("4. Remove Item from Cart");
			System.out.println("0. Checkout");
			System.out.println();
			System.out.print("Choose an option: ");
			String menuChoice = scanner.nextLine();

			if (menuChoice.equals("1")) {
				viewCart(cart, cartSize);
			} else if (menuChoice.equals("2")) {
				System.out.println();
				System.out.println("Your Rank: " + currentCustomer.rank);
				System.out.println("Promotion: " + currentCustomer.getPromotion());
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

				viewCart(cart, cartSize);
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
				// Checkout process
				if (checkout(cart, cartSize, currentCustomer)) {
					break; // Exit loop if checkout is successful
				}
			}
		}
	}

	static void viewCart(CartItem[] cart, int cartSize) {
		System.out.println();
		System.out.println("Your Cart:");
		if (cartSize == 0) {
			System.out.println("Your cart is empty.");
			return;
		}
		for (int i = 0; i < cartSize; i++) {
			CartItem item = cart[i];
			System.out.println(
					(i + 1) + ". " + item.name + " $" + item.price + " x " + item.quantity + " = $" + item.getTotal());
		}
	}

	static boolean checkout(CartItem[] cart, int cartSize, Customer currentCustomer) {
		if (cartSize == 0) {
			System.out.println();
			System.out.println("Your cart is empty.");
			return false;
		}

		double subtotal = 0;
		for (int i = 0; i < cartSize; i++) {
			subtotal += cart[i].getTotal();
		}

		double shipping = 5;
		double discount = currentCustomer.getDiscount();
		double voucher = 1.0;

		if (currentCustomer.rank.equals("Silver")) {
			shipping = shipping / 2;
		}

		double total = subtotal * (1 - discount) - voucher + shipping;

		System.out.println();
		System.out.println("CHECKOUT");
		System.out.println();
		for (int i = 0; i < cartSize; i++) {
			CartItem item = cart[i];
			System.out.println(
					(i + 1) + ". " + item.name + " $" + item.price + " x " + item.quantity + " = $" + item.getTotal());
		}

		System.out.println("Shipping fee: $" + shipping);
		System.out.println("Voucher: -$" + voucher);
		System.out.println("Rank: " + currentCustomer.rank + " -$" + (discount * subtotal));
		System.out.println("Total: $" + total);
		System.out.println();
		System.out.println("1. Confirm and Pay");
		System.out.println("2. Cancel and return to MAIN MENU");
		System.out.println();
		System.out.print("Choose an option: ");
		String choice = scanner.nextLine();
		if (choice.equals("1")) {
			System.out.println("Payment successful. Thank you!");
			cartSize = 0;
			return true;
		} else {
			System.out.println("Checkout cancelled.");
			return false;
		}
	}
}

// Prioritise data segregation, using multiple classes (and subclasses if possible).
// Eg. Console
// Console
// Shop => (Product => ShoppingCart + CartItem) + (Customer)
// There should be an private static void initData function to add demo data.
// Final, static, etc.