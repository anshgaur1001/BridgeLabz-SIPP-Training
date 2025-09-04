// Instructor Class
class Instructor {
    private String name;
    private String expertise;
    private double rating;

    public Instructor(String name, String expertise, double rating) {
        this.name = name;
        this.expertise = expertise;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " (" + expertise + ", Rating: " + rating + ")";
    }
}

// Schedule Class
class Schedule {
    private String dayOfWeek;
    private String timeSlot;
    private String mode;

    public Schedule(String dayOfWeek, String timeSlot, String mode) {
        this.dayOfWeek = dayOfWeek;
        this.timeSlot = timeSlot;
        this.mode = mode;
    }

    @Override
    public String toString() {
        return dayOfWeek + " " + timeSlot + " (" + mode + ")";
    }
}

// Abstract Course Class
abstract class Course {
    protected String title;
    protected int duration; // in weeks
    protected double price;
    protected Instructor instructor;
    protected Schedule schedule;

    public Course(String title, int duration, double price, Instructor instructor, Schedule schedule) {
        this.title = title;
        this.duration = duration;
        this.price = price;
        this.instructor = instructor;
        this.schedule = schedule;
    }

    // Abstract method (Polymorphic behavior)
    public abstract void conductAssessment();

    public void displayDetails() {
        System.out.println("Course: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Schedule: " + schedule);
    }
}

// Subclass: ProgrammingCourse
class ProgrammingCourse extends Course {
    public ProgrammingCourse(String title, int duration, double price, Instructor instructor, Schedule schedule) {
        super(title, duration, price, instructor, schedule);
    }

    @Override
    public void conductAssessment() {
        System.out.println("Assessment: Conducting coding challenge on HackerRank...");
    }
}

// Subclass: DesignCourse
class DesignCourse extends Course {
    public DesignCourse(String title, int duration, double price, Instructor instructor, Schedule schedule) {
        super(title, duration, price, instructor, schedule);
    }

    @Override
    public void conductAssessment() {
        System.out.println("Assessment: Submit a portfolio of 3 app designs.");
    }
}

// Subclass: BusinessCourse
class BusinessCourse extends Course {
    public BusinessCourse(String title, int duration, double price, Instructor instructor, Schedule schedule) {
        super(title, duration, price, instructor, schedule);
    }

    @Override
    public void conductAssessment() {
        System.out.println("Assessment: Group case-study presentation scheduled next week.");
    }
}

// Demo Class
public class EduFlexDemo {
    public static void main(String[] args) {
        // Instructors
        Instructor rajeev = new Instructor("Dr. Rajeev", "Java Expert", 4.8);
        Instructor ananya = new Instructor("Ms. Ananya", "UX Designer", 4.7);
        Instructor arvind = new Instructor("Mr. Arvind", "Business Analyst", 4.6);

        // Schedules
        Schedule progSchedule = new Schedule("Monday", "7-9 PM", "Live");
        Schedule designSchedule = new Schedule("Flexible", "Self-paced", "Recorded");
        Schedule businessSchedule = new Schedule("Friday", "6-8 PM", "Live");

        // Courses
        Course javaCourse = new ProgrammingCourse("Java Mastery", 12, 4999, rajeev, progSchedule);
        Course designCourse = new DesignCourse("UX Design Fundamentals", 8, 3999, ananya, designSchedule);
        Course businessCourse = new BusinessCourse("Business Strategy 101", 10, 5999, arvind, businessSchedule);

        // Run Demo
        javaCourse.displayDetails();
        javaCourse.conductAssessment();
        System.out.println();

        designCourse.displayDetails();
        designCourse.conductAssessment();
        System.out.println();

        businessCourse.displayDetails();
        businessCourse.conductAssessment();
    }
}
