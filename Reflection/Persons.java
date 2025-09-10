import java.util.*;

public class Persons {
    private String name;
    private int age;
    private Address address;
    private List<String> hobbies;

    public Persons(String name, int age, Address address, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobbies = hobbies;
    }
}
