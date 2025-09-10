class Client {
    @Inject
    private ServiceA serviceA;

    @Inject
    private ServiceB serviceB;

    public void start() {
        serviceA.doWork();
        serviceB.performTask();
    }
}