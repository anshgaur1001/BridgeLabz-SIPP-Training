package screening;

import java.util.List;

public class ScreeningUtil {
    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayResume();
        }
    }
}
