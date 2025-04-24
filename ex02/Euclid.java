package ex02;

public class Euclid {
    
    public static void main(String[] args) {
        int x = -24;
        int y = 16;

        System.out.print("The GCD of " + x + " and " + y + " is ");        

        if (x < 0) x = -x; // Math.abs(x), aka |x| in real math
        if (y < 0) y = -y;

        if (x == 0) x = y;
        else if (y != 0) {
            while (x != y) {
                if (x > y) x = x - y;
                else y = y - x;
            }
        }
        System.out.println(x);        
    }
}
