package marketplace;

public class ClothingCategory implements Category {
    private String type;

    public ClothingCategory(String type) {
        this.type = type;
    }

    @Override
    public String getCategoryName() {
        return "Clothing - " + type;
    }
}
