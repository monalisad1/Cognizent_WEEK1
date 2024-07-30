import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Product {
    String id;
    String name;
    String category;

    Product(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + category;
    }
}

class SearchAlgorithms {
    // Linear Search
    static Product linearSearch(List<Product> products, String id) {
        for (Product product : products) {
            if (product.id.equals(id)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search (requires sorted list by id)
    static Product binarySearch(List<Product> products, String id) {
        int low = 0;
        int high = products.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products.get(mid).id.compareTo(id);

            if (cmp == 0) {
                return products.get(mid);
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Sample products
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Coffee Maker", "Home Appliances"),
            new Product("4", "Desk Chair", "Furniture")
        ));

        // Display all products
        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println(product);
        }

        // Sort products by id for binary search
        products.sort((a, b) -> a.id.compareTo(b.id));

        // Search for products
        String searchId = "3";

        // Linear search
        Product foundProduct = linearSearch(products, searchId);
        System.out.println("\nLinear Search Result:");
        if (foundProduct != null) {
            System.out.println(foundProduct);
        } else {
            System.out.println("Product not found");
        }

        // Binary search
        foundProduct = binarySearch(products, searchId);
        System.out.println("\nBinary Search Result:");
        if (foundProduct != null) {
            System.out.println(foundProduct);
        } else {
            System.out.println("Product not found");
        }
    }
}
