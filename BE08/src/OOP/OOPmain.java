	// Day09 April 26 2025.

package OOP;

public class OOPmain {

	// OOP - Object-Oriented Programming.
	// Programming revolves around objects and the templates/classes that they are created on.
	//

	public static void main(String[] args) {
		// This is the object/ instance.

		Info jonathan = new Info(); // Constructor. The "jonathan" variable directly refers to the address of its object.
		
		System.out.println(jonathan);
		System.out.println("Full name: " + jonathan.fullName);
		System.out.println("Date of birth: " + jonathan.dob);
		System.out.println("Sex: " + jonathan.sex);
	 // System.out.println("Email: " + jonathan.email);
		System.out.println();

		Info arashii = new Info(); // Constructor. The "arashii" variable directly refers to the address of its object.
		
		System.out.println(arashii);
		System.out.println("Full name: " + arashii.fullName);
		System.out.println("Date of birth: " + arashii.dob);
		System.out.println("Sex: " + arashii.sex);
	 // System.out.println("Email: " + arashii.email);
		System.out.println();

		
		System.out.println("Are jonathan and arashii the same? => " + (jonathan == arashii));
		System.out.println();

		// These 2 objects share the same template but refer to 2 different addresses.
		// This returns as false despite having the same values since they are not the same object.
		// It compares the addresses of the objects not the values.
		// Values are not assigned so they return default values at first.
		
		jonathan.fullName = "Jonathan Quan Dao";
		jonathan.dob = "24/07/2000";
		jonathan.sex = "Male";
		
		arashii.fullName = "Lee Sung-ho";
		arashii.dob = "24/07/1999";
		arashii.sex = "Male";
		
		// Assigning value for the object's attributes.
		// Done manually and separately for each.
		
		System.out.println(jonathan);
		System.out.println("Full name: " + jonathan.fullName);
		System.out.println("Date of birth: " + jonathan.dob);
		System.out.println("Sex: " + jonathan.sex);
	 // System.out.println("Email: " + jonathan.email);
		System.out.println();
		
		System.out.println(arashii);
		System.out.println("Full name: " + arashii.fullName);
		System.out.println("Date of birth: " + arashii.dob);
		System.out.println("Sex: " + arashii.sex);
	 // System.out.println("Email: " + arashii.email);
		System.out.println();
		
		// Shows value after assigned.
		
		// Functions from Info.java
		// Direct value or assigned value.
		
		jonathan.say("Hello.");
		arashii.say("Hi.");
		System.out.println();
		
		String text = "Sample text.";
		
		jonathan.say(text);
		arashii.say(text);
		System.out.println();
		
		// jonathan.email and arashii.email are inaccessible due to being set private.
		// They could only be accessed in Info.
		
		// Day10 May 03 2025.
		
		// 4 attribute types:
		
		// Encapsulation.
		
		// This involves encapsulating/bundling relevant attributes/data and methods/functions on those data into a unit, typically a class.
		
		
		// Classes are the templates in which data and functions are encapsulated. Object is the instance created from pre-existing classes.
		
		// Inheritance. 
		
		SubInfo sub = new SubInfo();
		
		sub.fullName = "Seonbae";
		sub.dob = "24/05/2000";
		sub.sex = "Male";
		sub.address = "Please do not doxx me.";
		
		System.out.println("Full name: " + sub.fullName);
		System.out.println("Date of birth: " + sub.dob);
		System.out.println("Sex: " + sub.sex); 
		sub.say("Testing.");
		sub.showAddress(sub.address);
		System.out.println();
		
		// A subclass inherits all its superclass attributes and functions.
		// Hence a subclass can have more attributes and functions.
		// A subclass "extends" a superclass so it's inherently larger and more expansive.
		// Different subclasses from a superclass do not inherit each other.
		// Multiple inheritance is not possible. DIAMOND PROBLEM.
		 
		Info og = new Info();
	 // SubInfo s = new Info();
	 // SubInfo s2 = new SubInfo2();
		Info info = new SubInfo();
		Info info2 = new SubInfo2();
		
		// "I have a big toolbox (SubInfo/SubInfo2), but I’ll only use the tools that exist in the standard one (Info)."
		// This is possible because the template is sufficient. SubInfo has all the attributes and functions Info possesses.
		
		// Polymorphism.
		
		// Override allows subclasses to implement functions from a superclass in a different way.
		// Overload allows multiple methods with the same name but different parameter lists.
		
		SubInfo poly = new SubInfo();
		poly.say("SubInfo poly = new SubInfo();");
		
		SubInfo2 poly2 = new SubInfo2();
		poly2.say("ubInfo2 poly2 = new SubInfo2();");
		
		System.out.println();
		og.say("This uses the say function from Info");
		info.say("This uses the say function from SubInfo");
		info2.say("This uses the say function from SubInfo2");
		
		System.out.println();
		og.showEmail();
		info.showEmail();
		info2.showEmail();
		
		// These are possible because they use the showEmail function is accessed directly from Info, even though email is set to private in Info.
		
		// Abstraction.
		
		
		
		
		
		
		
	}

}
