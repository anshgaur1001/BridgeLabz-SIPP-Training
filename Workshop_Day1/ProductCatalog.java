import java.util.*;

// Product class
class Product {
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws IllegalArgumentException {
        if (stock < 0 || stock > 1000) { // assume max 1000
            throw new IllegalArgumentException("Stock must be between 0 and 1000.");
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Category: %s | Price: %.2f | Stock: %d",
                name, category, price, stock);
    }
}

// Catalog manager
public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    // Add a new product
    public void addProduct(Product p) {
        products.add(p);
    }

    // Search by name (partial match)
    public List<Product> searchByName(String name) {
        List<Product> results = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(p);
            }
        }
        return results;
    }

    // Search by category
    public List<Product> searchByCategory(String category) {
        List<Product> results = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                results.add(p);
            }
        }
        return results;
    }

    // Update stock
    public void updateStock(String productName, int newStock)
            throws IllegalArgumentException, NoSuchElementException {
        Product found = null;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                found = p;
                break;
            }
        }
        if (found == null) {
            throw new NoSuchElementException("Product not found: " + productName);
        }
        found.setStock(newStock);
    }

    // Generate a price-sorted report
    public void generatePriceReport(boolean ascending) {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        if (!ascending) {
            Collections.reverse(products);
        }

        System.out.println("\n=== Product Price Report ===");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        // Sample products
        catalog.addProduct(new Product("Laptop", "Electronics", 799.99, 50));
        catalog.addProduct(new Product("Smartphone", "Electronics", 499.99, 150));
        catalog.addProduct(new Product("Jeans", "Clothing", 39.99, 200));
        catalog.addProduct(new Product("Blender", "Appliances", 69.99, 75));

        // Search demo
        System.out.println("\nSearch by name 'phone':");
        List<Product> results = catalog.searchByName("phone");
        for (Product p : results) {
            System.out.println(p);
        }

        // Search by category
        System.out.println("\nSearch by category 'Electronics':");
        results = catalog.searchByCategory("Electronics");
        for (Product p : results) {
            System.out.println(p);
        }

        // Update stock
        try {
            catalog.updateStock("Laptop", 80);
            catalog.updateStock("NonExistentProduct", 10); // triggers exception
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("Error updating stock: " + e.getMessage());
        }

        // Generate price-sorted reports
        catalog.generatePriceReport(true); // ascending
        catalog.generatePriceReport(false); // descending
    }
}
