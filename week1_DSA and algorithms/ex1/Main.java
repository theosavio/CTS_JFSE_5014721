public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Adding products
        Product product1 = new Product("1", "Laptop", 10, 1000.0);
        Product product2 = new Product("2", "Smartphone", 20, 500.0);
        manager.addProduct(product1);
        manager.addProduct(product2);

        // Display all products
        System.out.println("All Products:");
        manager.displayAllProducts();

        // Update product
        product1.setPrice(900.0);
        manager.updateProduct(product1);
        System.out.println("After updating Laptop price:");
        manager.displayAllProducts();

        // Delete product
        manager.deleteProduct("2");
        System.out.println("After deleting Smartphone:");
        manager.displayAllProducts();
    }
}
