package ex06;

public class Main {
    
    public static void main(String[] args) {
        Ratio r1 = new Ratio(1, 2);
        Ratio r2 = new Ratio(1, 3);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println( r1.add(r2) );
    }
}
