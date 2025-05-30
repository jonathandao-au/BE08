package Day10_May_03_2025_HW;

public class CartItem extends Product {
    public int quantity;

    public CartItem(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }
}