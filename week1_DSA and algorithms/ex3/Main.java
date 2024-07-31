package sorting_orders;
import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("1", "theo", 250.0),
            new Order("2", "savio", 150.0),
            new Order("3", "Charlie", 300.0),
            new Order("4", "rabin", 200.0),
            new Order("5", "hamil", 100.0)
        };

        System.out.println("Before Sorting:");
        Arrays.stream(orders).forEach(System.out::println);

        // Bubble Sort
        SortingAlgorithms.bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort:");
        Arrays.stream(orders).forEach(System.out::println);

        // Resetting the order array
        orders = new Order[]{
            new Order("1", "theo", 250.0),
            new Order("2", "savio", 150.0),
            new Order("3", "Charlie", 300.0),
            new Order("4", "rabin", 200.0),
            new Order("5", "hamil", 100.0)
        };

        // Quick Sort
        SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        Arrays.stream(orders).forEach(System.out::println);
    }
}
