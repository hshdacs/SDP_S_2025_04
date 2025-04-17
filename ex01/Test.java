package ex01;

public class Test {

    public static void main(String[] args) {

        // playing with some data types
        byte b = -128;
        b--;
        System.out.println(b);

        int secondsPerYear = 100;
        secondsPerYear *= 365*24*60*60;
        System.out.println(secondsPerYear);

        double f = 1.0 / 2;
        System.out.println(f);

        float x1 = (float)0.1; // using cast operator
        float x2 = 0.1f;    // DANGER!!
        float sum = 0L;        // a long fits into float
        for (int i=0; i<10_000_000; i++) {
            sum += x2;
        }
        System.out.println(sum);

        double x = 0.1;
        double sum2 = 0;
        for (int i=0; i<10_000_000; i++) {
            sum2 += x;
        }
        System.out.println(sum2);

    }
}
