public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Table", "Furniture"),
            new Product("4", "Chair", "Furniture"),
            new Product("5", "Headphones", "Electronics")
        };

        // Test Linear Search
        System.out.println("Linear Search:");
        Product foundProduct = SearchAlgorithms.linearSearch(products, "Table");
        System.out.println(foundProduct != null ? foundProduct : "Product not found");

        // Test Binary Search
        System.out.println("Binary Search:");
        foundProduct = SearchAlgorithms.binarySearch(products, "Chair");
        System.out.println(foundProduct != null ? foundProduct : "Product not found");
    }
}
