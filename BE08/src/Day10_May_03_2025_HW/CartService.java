package Day10_May_03_2025_HW;

import java.util.Scanner;

public class CartService {

	static void viewCart(CartItem[] cart, int cartSize) {
		System.out.println();
		System.out.println("Your Cart:");
		System.out.println();
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
		
		Scanner scanner = new Scanner(System.in);
		
		if (cartSize == 0) {
			System.out.println();
			System.out.println("Your cart is empty.");
			return false;
		}

		double subtotal = 0;
		for (int i = 0; i < cartSize; i++) {
			subtotal += cart[i].getTotal();
		}

		double discount = currentCustomer.getPromotion();
		double shipping = Shipping.getShippingFee();
		double voucher = Voucher.applyVoucher(scanner, subtotal, shipping);

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
		Print.checkout(currentCustomer, voucher, shipping, currentCustomer.rank, discount, subtotal, total);
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
