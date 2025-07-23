package screening;

public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRequiredSkills() {
        return "Java, Spring Boot, Data Structures, Algorithms";
    }
}
