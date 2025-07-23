package university;

public class Course<T extends CourseType> {
    private T courseType;
    private String department;

    public Course(String department, T courseType) {
        this.department = department;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDepartment() {
        return department;
    }

    public void showDetails() {
        System.out.println("Department: " + department);
        System.out.println("Course: " + courseType.getCourseName());
        System.out.println("Evaluation: " + courseType.getEvaluationMethod());
        System.out.println("-----------------------------");
    }
}
