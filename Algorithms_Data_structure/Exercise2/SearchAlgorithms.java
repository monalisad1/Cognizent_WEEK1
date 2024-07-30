import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Product {
    String productId;
    String productName;
    String category;

    Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class SearchAlgorithms {

    // Linear Search
    static Product linearSearch(List<Product> products, String productId) {
        for (Product product : products) {
            if (product.productId.equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search (requires sorted list by productId)
    static Product binarySearch(List<Product> products, String productId) {
        int low = 0;
        int high = products.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products.get(mid).productId.compareTo(productId);

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

        // Sort products by productId for binary search
        products.sort((a, b) -> a.productId.compareTo(b.productId));

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
