package Day10_May_03_2025_HW;

public class Customer {
	String id;
	String password;
	String rank;

	public Customer(String customerId, String customerPassword, String customerRank) {
		id = customerId;
		password = customerPassword;
		rank = customerRank;
	}

	public String getPromotion() {
		if (rank.equals("Silver"))
			return "50% off shipping fee";
		if (rank.equals("Gold"))
			return "2% off total";
		if (rank.equals("Diamond"))
			return "3% off total";
		return "No promotions";
	}

	public double getDiscount() {
		switch (rank) {
		case "Silver":
			return 0.02;
		case "Gold":
			return 0.03;
		case "Diamond":
			return 0.05;
		default:
			return 0.0;
		}
	}
}