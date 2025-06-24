package Java_Consturctor;
public class Person {
    String name;
    int age;

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void display() {
        System.out.println("Person Name: " + name + ", Age: " + age);
    }
    
    public static void main(String[] args) {
    	Person person1 = new Person("Ansh", 21);
        Person person2 = new Person(person1);
        person1.display();
        person2.display();
    }
}
