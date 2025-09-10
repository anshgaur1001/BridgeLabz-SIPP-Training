class Task {
    @Timed
    public void quickTask() {
        System.out.println("Running quick task...");
        for (int i = 0; i < 1000000; i++) {} 
    }

    @Timed
    public void slowTask() {
        System.out.println("Running slow task...");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalTask() {
        System.out.println("This method is not timed.");
    }
}