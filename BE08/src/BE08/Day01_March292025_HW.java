	// March 29, 2025
package BE08;
public class Day01_March292025_HW {
public static void main(String[] args) {
double math = 5.1;
double eng = 5.1;
double lit = 5.1;
double avg = (math + eng + lit) / 3; // Or double avg = ((double) Math.round((math + eng + lit) / 3) * 10) / 10;
avg = Math.round(avg * 10) / 10.0; // Math operators between ints result in ints. At least one double is required to result in double.
int mathgrade;
int enggrade;
int litgrade;
int avggrade; // avggrade is not needed but a placeholder in case of expanding the program.

	// Grade: F<5, D>=5, C>=6, B>=7, A >=8, S>=9.
	// Extra conditions: 1 F = Average F, Average Grade = +1 Grade maximum of the lowest grade.
	// If conditions OR = || AND = &&.
	// Extra: else if, else, switch case, round, ceil, floor, max, return.
	// Data: double,... ?

	// Advisable to use else if () {} ladder rather than nested - if () {} else {if () {}} for readability.
	// Could utilize only mingrade for all mathgrade, enggrade, and litgrade for extra conditions.

System.out.print("Math = " + math);
if (math >= 9) {mathgrade = 1; System.out.println(" => S Grade.");} 
else if (math >= 8) {mathgrade = 2;  System.out.println(" => A Grade.");} 
else if (math >= 7) {mathgrade = 3;  System.out.println(" => B Grade.");}
else if (math >= 6) {mathgrade = 4;  System.out.println(" => C Grade.");} 
else if (math >= 5) {mathgrade = 5;  System.out.println(" => D Grade.");} else {mathgrade = 6;  System.out.println(" => F Grade.");}

System.out.print("English = " + eng);
if (eng >= 9) {enggrade = 1; System.out.println(" => S Grade.");} 
else if (eng >= 8) {enggrade = 2;  System.out.println(" => A Grade.");} 
else if (eng >= 7) {enggrade = 3;  System.out.println(" => B Grade.");} 
else if (eng >= 6) {enggrade = 4;  System.out.println(" => C Grade.");} 
else if (eng >= 5) {enggrade = 5;  System.out.println(" => D Grade.");} else {enggrade = 6;  System.out.println(" => F Grade.");}

System.out.print("Literature = " + lit);
if (lit >= 9) {litgrade = 1; System.out.println(" => S Grade.");} 
else if (lit >= 8) {litgrade = 2;  System.out.println(" => A Grade.");} 
else if (lit >= 7) {litgrade = 3;  System.out.println(" => B Grade.");} 
else if (lit >= 6) {litgrade = 4;  System.out.println(" => C Grade.");} 
else if (lit >= 5) {litgrade = 5;  System.out.println(" => D Grade.");} else {litgrade = 6;  System.out.println(" => F Grade.");}

System.out.print("Average = " + avg);
if (mathgrade == 6 || enggrade == 6 || litgrade == 6) {avggrade = 6; System.out.println(" => F Grade.");} 
else if (avg >= 9 && mathgrade <= 2 && enggrade <= 2 && litgrade <= 2) {avggrade = 1; System.out.println(" => S Grade.");} 
else if (avg >= 8 && mathgrade <= 3 && enggrade <= 3 && litgrade <= 3) {avggrade = 2;  System.out.println(" => A Grade.");} 
else if (avg >= 7 && mathgrade <= 4 && enggrade <= 4 && litgrade <= 4) {avggrade = 3;  System.out.println(" => B Grade.");} 
else if (avg >= 6 && mathgrade <= 5 && enggrade <= 5 && litgrade <= 5) {avggrade = 4;  System.out.println(" => C Grade.");} 
else if (avg >= 5) {avggrade = 5;  System.out.println(" => D Grade.");} // if (avg < 5) is not needed as avg < 5 guarantees at least 1 F grade.

}
}