package Day10_May_03_2025_HW;

public class Shipping {
    public static double calculateShipping(double distanceKm) {
        if (distanceKm <= 2) return 0;
        else if (distanceKm <= 5) return 3;
        else if (distanceKm <= 10) return 5;
        else return 5 + Math.ceil((distanceKm - 10) / 2.0);
    }
}