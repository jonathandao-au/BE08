package BE08;

public class Day01_March292025_HW_optimized {
    public static void main(String[] args) {
        double math = 10;
        double eng = 9.5;
        double lit = 5.1;

        // Calculate the average and round it to 1 decimal place
        double avg = Math.round((math + eng + lit) / 3 * 10) / 10.0;

        // Determine individual grades
        int mathGrade = getGrade(math);
        int engGrade = getGrade(eng);
        int litGrade = getGrade(lit);

        // Print subject grades
        System.out.println("Math = " + math + " => " + getGradeText(mathGrade));
        System.out.println("English = " + eng + " => " + getGradeText(engGrade));
        System.out.println("Literature = " + lit + " => " + getGradeText(litGrade));

        // If any subject is an F, overall grade is F
        int avgGrade;
        if (mathGrade == 6 || engGrade == 6 || litGrade == 6) {
            avgGrade = 6;
        } else {
            // Determine the maximum allowed grade (1 tier above the highest subject grade)
            int maxAllowedGrade = Math.max(mathGrade, Math.max(engGrade, litGrade)) + 1;

            // Get the grade based on the average
            avgGrade = getGrade(avg);

            // Ensure overall grade does not exceed the maximum allowed grade
            avgGrade = Math.min(avgGrade, maxAllowedGrade);
        }

        // Print final average and overall grade
        System.out.println("Average = " + avg + " => " + getGradeText(avgGrade));
    }

    // Function to determine grade based on score
    public static int getGrade(double score) {
        if (score >= 9) return 1; // S
        if (score >= 8) return 2; // A
        if (score >= 7) return 3; // B
        if (score >= 6) return 4; // C
        if (score >= 5) return 5; // D
        return 6; // F
    }

    // Function to return letter grade from integer value
    public static String getGradeText(int grade) {
        switch (grade) {
            case 1: return "S Grade";
            case 2: return "A Grade";
            case 3: return "B Grade";
            case 4: return "C Grade";
            case 5: return "D Grade";
            case 6: return "F Grade";
            default: return "Invalid Grade";
        }
    }
}