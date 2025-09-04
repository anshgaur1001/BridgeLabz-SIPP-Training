// Base class
class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to be overridden by subclasses
    public void login() {
        System.out.println("Generic user login validation...");
    }
}

// Student subclass
class Student extends User {
    private boolean enrolled;

    public Student(String username, String password, boolean enrolled) {
        super(username, password);
        this.enrolled = enrolled;
    }

    @Override
    public void login() {
        if (username != null && password != null && enrolled) {
            System.out.println("✅ Student " + username + " logged in successfully. Showing available exams...");
        } else {
            System.out.println("❌ Login failed! Either credentials invalid or student not enrolled.");
        }
    }
}

// Admin subclass
class Admin extends User {
    private boolean hasAdminPrivileges;

    public Admin(String username, String password, boolean hasAdminPrivileges) {
        super(username, password);
        this.hasAdminPrivileges = hasAdminPrivileges;
    }

    @Override
    public void login() {
        if (username != null && password != null && hasAdminPrivileges) {
            System.out.println("✅ Admin " + username + " logged in successfully. Showing exam management tools...");
        } else {
            System.out.println("❌ Login failed! Either credentials invalid or insufficient privileges.");
        }
    }
}

// Demo class
public class ExamPortalDemo {
    public static void main(String[] args) {
        // Polymorphism in action
        User studentUser = new Student("john123", "pass123", true);
        User adminUser = new Admin("admin01", "admin@123", true);

        studentUser.login(); // Student-specific login
        adminUser.login();   // Admin-specific login
    }
}
