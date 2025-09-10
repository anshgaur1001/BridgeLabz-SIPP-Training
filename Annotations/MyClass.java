class MyClass {

    @ImportantMethod 
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM") 
    public void moderateTask() {
        System.out.println("Executing moderate task...");
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}