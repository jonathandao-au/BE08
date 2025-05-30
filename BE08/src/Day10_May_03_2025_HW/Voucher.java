package Day10_May_03_2025_HW;

import java.util.Scanner;

public class Voucher {

	static final String[] VoucherCodes = { "10%OFF", "$5OFF", "FREESHIP", "SHIP3" };
	static final String[] VoucherTargets = { "subtotal", "subtotal", "shipping", "shipping" };
	static final String[] VoucherModes = { "percent", "amount", "amount", "amount" };
	static final double[] VoucherValues = { 0.1, 5, 1000, 3 };

	public static int getVoucherIndex(String code) {
		for (int i = 0; i < VoucherCodes.length; i++) {
			if (VoucherCodes[i].equals(code)) {
				return i;
			}
		}
		return -1;
	}

	public static double applyVoucher(Scanner scanner, double subtotal, double shipping) {
	    System.out.println();
	    System.out.print("Enter voucher code (or press ENTER to skip): ");
	    String code = scanner.nextLine().toUpperCase();

	    int index = getVoucherIndex(code);
	    if (index == -1) {
	        System.out.println("Invalid voucher code or skipped.");
	        return 0.0; // no discount
	    }

	    String target = VoucherTargets[index];
	    String mode = VoucherModes[index];
	    double value = VoucherValues[index];
	    double discount = 0.0;

	    if (target.equals("subtotal")) {
	        if (mode.equals("percent")) {
	            discount = subtotal * value;
	        } else if (mode.equals("amount")) {
	            discount = Math.min(value, subtotal);
	        }
	    } else if (target.equals("shipping")) {
	        if (mode.equals("amount")) {
	            discount = Math.min(value, shipping);
	        }
	    }

	    System.out.println("Voucher " + code + " applied: -" + discount + " (" + target + ")");
	    return discount;
	}
}
