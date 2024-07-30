import java.util.ArrayList;
import java.util.List;

class Order {
    String orderId;
    String customerName;
    double totalPrice;

    Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId + ", CustomerName: " + customerName + ", TotalPrice: $" + totalPrice;
    }
}

public class SortingOrders {

    // Bubble Sort implementation
    static void bubbleSort(List<Order> orders) {
        int n = orders.size();
        // Traverse through all orders
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent orders
                if (orders.get(j).totalPrice > orders.get(j + 1).totalPrice) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                }
            }
        }
    }

    // Quick Sort implementation
    static void quickSort(List<Order> orders, int low, int high) {
        if (low < high) {
            // Partition the list and get the pivot index
            int pi = partition(orders, low, high);
            // Recursively sort the sublists
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    // Helper method for Quick Sort
    private static int partition(List<Order> orders, int low, int high) {
        double pivot = orders.get(high).totalPrice;
        int i = low - 1; // Index of the smaller element
        for (int j = low; j < high; j++) {
            // If the current element is smaller than the pivot
            if (orders.get(j).totalPrice <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }
        // Swap orders[i + 1] and orders[high] (pivot)
        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);
        return i + 1;
    }

    public static void main(String[] args) {
        // Creating a list of sample orders
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("001", "Alice", 150.75));
        orders.add(new Order("002", "Bob", 200.50));
        orders.add(new Order("003", "Charlie", 125.00));
        orders.add(new Order("004", "Diana", 175.20));

        System.out.println("Original Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Applying Bubble Sort
        List<Order> bubbleSortedOrders = new ArrayList<>(orders);
        bubbleSort(bubbleSortedOrders);
        System.out.println("\nBubble Sorted Orders:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        // Applying Quick Sort
        List<Order> quickSortedOrders = new ArrayList<>(orders);
        quickSort(quickSortedOrders, 0, quickSortedOrders.size() - 1);
        System.out.println("\nQuick Sorted Orders:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}
