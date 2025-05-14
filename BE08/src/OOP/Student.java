package OOP;

public class Student {
    String name;
    String gmail;
    String phone;

    public Student(String name, String gmail, String phone) {
        this.name = name;
        this.gmail = gmail;
        this.phone = phone;
    }

    public void showInfo() {
        System.out.println("Name: " + name + ", Gmail: " + gmail + ", Phone: " + phone);
    }
}
