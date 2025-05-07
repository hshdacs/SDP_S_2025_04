package ex06;

public class Main {

    private static void showRatioCalculation(Ratio a, Ratio b, char operation) {
        System.out.print(a + " " + operation + " " + b + " = ");
        switch (operation) {
            case '+':
                System.out.println(a.add(b));
                //System.out.println(a.add(b).toDouble());
                break;
            case '-':
                System.out.println(a.sub(b));
                break;
            case '*':
                System.out.println(a.mult(b));
                break;
            case '/':
                System.out.println(a.div(b));
                break;
            default:
                System.out.println("No idea!?");
                break;
        }
    }


    public static void main(String[] args) {
        Ratio r1 = new Ratio(1, 2);
        Ratio r2 = new Ratio(1, 3);
        Ratio r3 = new Ratio(2, 3);
        Ratio r4 = new Ratio(4, 5);

        showRatioCalculation(r1, r2, '+');
        showRatioCalculation(r1, r2, '-');
        showRatioCalculation(r1, r2, '*');
        showRatioCalculation(r3, r4, '*');
        showRatioCalculation(r1, r2, '/');
        showRatioCalculation(r3, r4, '/');
    }
}
