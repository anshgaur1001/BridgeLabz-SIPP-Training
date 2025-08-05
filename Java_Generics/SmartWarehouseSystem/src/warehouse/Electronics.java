package warehouse;

public class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public String getDetails() {
        return "Electronics: " + getName() + ", Brand: " + brand;
    }
}
