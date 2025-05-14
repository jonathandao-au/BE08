package OOP;

public class Info {

	// Info class bundles/encapsulates below variables and functions.
	// Attributes would be relevant to the subject matter of the class.
		
	// Access modifiers
	
	public String fullName; // public. This allows the attribute to be available anywhere.
	String dob; 			// default. This allows the attribute to be accessed anywhere within the package.
	protected String sex;   // protected. This allows the attribute to be accessed anywhere within the package + by subclasses from different packages.
	private String email;   // private. This makes the attribute inaccessible outside of "Info" class.

	// These are attributes/properties of template.

	public void say(String textSay) {
		System.out.println(fullName + " says : " + textSay);
	}

	public void email(String email) {
		System.out.println(fullName + "'s email : " + email);
	}
	
	void showEmail() {
		System.out.println("Email: " + email);
	}
}