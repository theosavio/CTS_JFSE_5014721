import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Product> inventory;

    public InventoryManager() {
        this.inventory = new HashMap<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Method to update a product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    // Method to delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    // Method to retrieve a product
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    // Method to display all products
    public void displayAllProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}
