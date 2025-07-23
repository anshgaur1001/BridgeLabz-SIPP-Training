package screening;

public class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void displayResume() {
        System.out.println("Candidate: " + jobRole.getCandidateName());
        System.out.println("Applying for: " + jobRole.getClass().getSimpleName());
        System.out.println("Required Skills: " + jobRole.getRequiredSkills());
        System.out.println("-----------------------------");
    }
}
