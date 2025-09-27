package Day10_May_03_2025_HW;

public class Print {

	public static void loginHome() {
		System.out.println();
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println();
		System.out.print("Choose an option: ");
	}

	public static void loginRetry() {
		System.out.println("Maximum attempts reached.");
		System.out.println();
		System.out.println("1. Try Login Again");
		System.out.println("2. Exit");
		System.out.println();
		System.out.print("Choose an option: ");
	}

	public static void mainMenu() {
		System.out.println();
		System.out.println("MAIN MENU");
		System.out.println();
		System.out.println("1. View Cart");
		System.out.println("2. Ranking");
		System.out.println("3. View Products");
		System.out.println("4. Remove Item from Cart");
		System.out.println("0. Checkout");
		System.out.println();
		System.out.print("Choose an option: ");
	}

	public static void checkout(Customer currentCustomer, double voucher, double shipping, String rank, double discount,
			double subtotal, double total) {
		System.out.println();
		System.out.println("Voucher: -$" + voucher);
		System.out.println("Shipping fee: $" + shipping);
		System.out.println("Rank: " + rank + " -$" + (discount * subtotal));
		System.out.println("Total: $" + total);
		System.out.println();
		System.out.println("1. Confirm and Pay");
		System.out.println("2. Cancel and return to MAIN MENU");
		System.out.println();
		System.out.print("Choose an option: ");
	}
}
