package Day10_May_03_2025_HW;

public class Shop {
    String name;
    Product[] products;
    Customer[] customers;
    int customerCount;
    int productCount;

    public Shop(String shopName, Product[] shopProducts, int maxCustomers) {
        name = shopName;
        products = shopProducts;
        customers = new Customer[maxCustomers];
        customerCount = 0;	
    }

    public void addCustomer(Customer customer) {
        customers[customerCount++] = customer;
    }
    
    public void addProduct(Product p) {
        products[productCount++] = p;
    }

    public Product[] getProducts() {
        return products;
    }

    public Customer login(String loginId, String loginPassword) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].id.equals(loginId) && customers[i].password.equals(loginPassword)) {
                return customers[i];
            }
        }
        return null;
    }

    public boolean idExists(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].id.equals(id)) return true;
        }
        return false;
    }
}