class PerformanceTest {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i; // Simple computation
        }
        System.out.println("fastTask completed.");
    }

    @LogExecutionTime
    public void slowTask() {
        try {
            Thread.sleep(500); // Simulate slower task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("slowTask completed.");
    }

    public void normalTask() {
        System.out.println("Normal task (not timed).");
    }
}