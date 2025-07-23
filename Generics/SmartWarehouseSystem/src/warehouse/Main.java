package warehouse;

public class Main {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Smartphone", "Samsung"));
        electronicsStorage.addItem(new Electronics("Laptop", "Dell"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Milk", "2025-01-10"));
        groceryStorage.addItem(new Groceries("Bread", "2025-01-05"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        System.out.println("---- Electronics ----");
        DisplayUtil.displayAllItems(electronicsStorage.getItems());

        System.out.println("---- Groceries ----");
        DisplayUtil.displayAllItems(groceryStorage.getItems());

        System.out.println("---- Furniture ----");
        DisplayUtil.displayAllItems(furnitureStorage.getItems());
    }
}
