import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    int stock;

    public Product(String name, String category, int stock) {
        this.name = name;
        this.category = category;
        this.stock = stock;
    }
}

public class OnlineStoreInventoryReport {

    public static void generateReport(List<Product> products) {
        Scanner sc = new Scanner(System.in);

        // Edge Case 1: Empty list
        if (products == null || products.isEmpty()) {
            System.out.println("No products available in the inventory.");
            return;
        }

        // Edge Case 2: Clean invalid data (negative stock or null category)
        products = products.stream()
                .filter(p -> p.stock >= 0 && p.category != null)
                .collect(Collectors.toList());

        // Group by category and sum stock
        Map<String, Integer> stockByCategory =
                products.stream()
                        .collect(Collectors.groupingBy(
                                p -> p.category,
                                Collectors.summingInt(p -> p.stock)
                        ));

        // Ask user for report type
        System.out.println("Choose report type:");
        System.out.println("1. Show stock by category");
        System.out.println("2. Show total stock across all categories");
        System.out.println("3. Show both");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("---- Stock by Category ----");
                stockByCategory.forEach((cat, stock) ->
                        System.out.println(cat + " : " + stock + " units"));
                break;

            case 2:
                System.out.println("---- Total Stock ----");
                int totalStock = stockByCategory.values()
                        .stream().mapToInt(Integer::intValue).sum();
                System.out.println("Total stock available = " + totalStock + " units");
                break;

            case 3:
                System.out.println("---- Stock by Category ----");
                stockByCategory.forEach((cat, stock) ->
                        System.out.println(cat + " : " + stock + " units"));
                System.out.println("---- Total Stock ----");
                int total = stockByCategory.values()
                        .stream().mapToInt(Integer::intValue).sum();
                System.out.println("Total stock available = " + total + " units");
                break;

            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 5),
                new Product("Shirt", "Clothing", 10),
                new Product("Phone", "Electronics", 7),
                new Product("Shoes", "Clothing", 3),
                new Product("Book", null, 4),         // null category (ignored)
                new Product("Tablet", "Electronics", -2) // negative stock (ignored)
        );

        generateReport(products);
    }
}
