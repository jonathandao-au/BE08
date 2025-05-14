package OOP;

public class Day09_April_26_2025_HW_Mentor {
	String name;
    int yearOfExperience;

    public void Mentor(String name, int yearOfExperience) {
        this.name = name;
        this.yearOfExperience = yearOfExperience;
    }

    public void showInfo() {
        System.out.println("Mentor - Name: " + name + ", Years of Experience: " + yearOfExperience);
    }
}