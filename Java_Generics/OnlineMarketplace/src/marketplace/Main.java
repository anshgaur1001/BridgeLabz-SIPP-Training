package marketplace;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product<? extends Category>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("The Alchemist", 499.0, new BookCategory("Fiction"));
        Product<ClothingCategory> tshirt = new Product<>("Polo T-Shirt", 799.0, new ClothingCategory("Casual Wear"));
        Product<GadgetCategory> phone = new Product<>("Smartphone", 19999.0, new GadgetCategory("Mobile"));

        catalog.add(book);
        catalog.add(tshirt);
        catalog.add(phone);

        // Apply discounts
        DiscountUtil.applyDiscount(book, 10);     // 10% off
        DiscountUtil.applyDiscount(tshirt, 20);   // 20% off
        DiscountUtil.applyDiscount(phone, 5);     // 5% off

        // Display product catalog
        for (Product<? extends Category> product : catalog) {
            product.showDetails();
        }
    }
}
