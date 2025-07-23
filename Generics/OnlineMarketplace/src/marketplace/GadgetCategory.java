package marketplace;

public class GadgetCategory implements Category {
    private String deviceType;

    public GadgetCategory(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String getCategoryName() {
        return "Gadget - " + deviceType;
    }
}
