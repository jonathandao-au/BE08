package OOP;

public class SubInfo2 extends Info {

	@Override
	public void say(String textSay) {
		System.out.println(fullName + " says this in a different way: " + textSay);
	}

//	@Override
//	void showEmail() {
//		System.out.println("Email: " + email);
	// This is not possible as email is set to private in Info.
	// Using Info's showEmail is viable but overriding it is not.
}
