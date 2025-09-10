class ProjectTasks {

    @Todo(task = "Implement login functionality", assignedTo = "Mayank", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature in progress...");
    }

    @Todo(task = "Add payment gateway", assignedTo = "Prachi")
    public void paymentFeature() {
        System.out.println("Payment feature pending...");
    }

    public void completedFeature() {
        System.out.println("This feature is completed.");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Ravi", priority = "HIGH")
    public void optimizeDB() {
        System.out.println("Optimizing database...");
    }
}