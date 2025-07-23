package university;

import java.util.List;

public class CourseDisplayUtil {
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            course.showDetails();
        }
    }
}
