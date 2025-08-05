package marketplace;

public class DiscountUtil {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}
