package ex05;

public class Person {
    private String name;
    private int age;
    private char gender;

    // standard ctor
    public Person(String name, int age, char gender) {
        this.name = name;
        setAge(age);
        this.gender = gender;
    }

    // overloaded ctor
    public Person(String name) {
        this(name, 0, 'm');
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            this.age = 0;
    }

    @Override
    public String toString() {
        return this.name + 
            " (" + 
            this.gender + 
            "," + 
            this.age + 
            ")";
    }
}
