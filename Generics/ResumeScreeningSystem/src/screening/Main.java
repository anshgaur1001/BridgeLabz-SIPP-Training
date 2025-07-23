package screening;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>(new SoftwareEngineer("Aryan Bansal"));
        Resume<DataScientist> r2 = new Resume<>(new DataScientist("Priya Sharma"));
        Resume<ProductManager> r3 = new Resume<>(new ProductManager("Rahul Verma"));

        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();
        resumeList.add(r1);
        resumeList.add(r2);
        resumeList.add(r3);

        ScreeningUtil.processResumes(resumeList);
    }
}
