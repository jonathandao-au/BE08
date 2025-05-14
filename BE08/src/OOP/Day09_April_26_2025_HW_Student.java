package OOP;

public class Day09_April_26_2025_HW_Student {
	String name;
    String gmail;
    String phone;

    public void Student(String name, String gmail, String phone) {
        this.name = name;
        this.gmail = gmail;
        this.phone = phone;
    }

    public void showInfo() {
        System.out.println("Student - Name: " + name + ", Gmail: " + gmail + ", Phone: " + phone);
    }
}