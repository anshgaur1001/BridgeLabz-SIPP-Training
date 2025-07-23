package university;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Course<? extends CourseType>> courseList = new ArrayList<>();

        Course<ExamCourse> math101 = new Course<>("Mathematics", new ExamCourse("Math 101"));
        Course<AssignmentCourse> cs102 = new Course<>("Computer Science", new AssignmentCourse("CS 102"));
        Course<ResearchCourse> phy103 = new Course<>("Physics", new ResearchCourse("Physics 103"));

        courseList.add(math101);
        courseList.add(cs102);
        courseList.add(phy103);

        CourseDisplayUtil.displayAllCourses(courseList);
    }
}
