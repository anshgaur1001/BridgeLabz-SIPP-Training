package screening;

public class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRequiredSkills() {
        return "Python, Machine Learning, Data Analysis, SQL";
    }
}
