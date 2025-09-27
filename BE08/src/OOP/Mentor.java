package OOP;

public class Mentor {
    String name;
    int yearsOfExperience;

    public Mentor(String name, int years) {
        this.name = name;
        this.yearsOfExperience = years;
    }

    public void showInfo() {
        System.out.println("Name: " + name + ", Years of Experience: " + yearsOfExperience);
    }
}
