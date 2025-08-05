package warehouse;

public class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public String getDetails() {
        return "Furniture: " + getName() + ", Material: " + material;
    }
}
