package Day10_May_03_2025_HW;

import java.util.Scanner;

public class Shipping {
    public static double getShippingFee() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        System.out.print("Enter delivery distance (in km): ");
        double distanceKm = scanner.nextDouble();
        scanner.nextLine();

        if (distanceKm <= 2) return 0;
        else if (distanceKm <= 5) return 3;
        else if (distanceKm <= 10) return 5;
        else return 5 + Math.ceil((distanceKm - 10) / 2.0);
    }
}