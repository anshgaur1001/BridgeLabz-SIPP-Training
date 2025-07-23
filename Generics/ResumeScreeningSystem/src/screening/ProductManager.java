package screening;

public class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRequiredSkills() {
        return "Roadmapping, Agile, Communication, Market Research";
    }
}
