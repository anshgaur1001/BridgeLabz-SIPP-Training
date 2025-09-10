class Students {
    private String name;
    private int age;
    private String course;

    @Override
    public String toString() {
        return "Student { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                " }";
    }
}