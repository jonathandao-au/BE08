package OOP;

public class SubInfo extends Info {
	String address;

	void showAddress(String address) {
		System.out.println(fullName + "'s address : " + address);
	}

	@Override
	public void say(String textSay) {
		System.out.println(fullName + " does not say : " + textSay);
	}
	
	public void test(String testing) {
	 // System.out.println(email);
		// This is not possible because email is set to private, thus not visible.
	}
}
