package ex05;

public class Main {

    // WARNING: Call-By-Reference!!!
    private static void changeAge(Person p) {
        p.setAge( 18 );
    }

    private static void switchName(Person p1, Person p2) {
        String temp = p1.getName();
        p1.setName(p2.getName());
        p2.setName(temp);
    }

    private static void switchStrings(String s1, String s2) {
        String temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println("in switchStrings: " + s1 + " " + s2);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Bob", 23, 'm');
        Person p2 = new Person("Julia", 22, 'f');

        changeAge(p2);
        switchName(p1, p2);
        System.out.println(p1);
        System.out.println(p2);

        String s1 = "John";
        String s2 = "Doe";
        switchStrings(s1, s2);
        System.out.println(s1 + " " + s2);
    }
}
