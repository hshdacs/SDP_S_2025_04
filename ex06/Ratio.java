package ex06;

public class Ratio /* extends Object */ {
    // making Ratio objects immutable
    private final int enumarator, denominator;

    public Ratio(int enumarator, int denominator) {
        this.enumarator = enumarator;
        this.denominator = denominator;
    }

    public Ratio(int enumarator) {
        this(enumarator, 1);
    }

    public Ratio add(Ratio that) {
        int myEnumarator = this.enumarator * that.denominator +
            that.enumarator * this.denominator;
        int myDenominator = this.denominator * that.denominator;
        return new Ratio(myEnumarator, myDenominator).reduce();
    }

    public Ratio sub(Ratio that) {
        return add( that.negate() );
    }

    public Ratio mult(Ratio that) {
        return new Ratio(this.enumarator * that.enumarator,
            this.denominator * that.denominator).reduce();
    }

    public Ratio div(Ratio that) {
        return mult( that.reciprocal() );
    }

    public Ratio reciprocal() {
        return new Ratio(denominator, enumarator);
    }

    public Ratio negate() {
        int myEnumarator = -this.enumarator;
        int myDenominator = this.denominator;
        if (myEnumarator < 0 && myDenominator < 0) {
            myEnumarator = -myEnumarator;
            myDenominator = -myDenominator;
        }
        return new Ratio(myEnumarator, myDenominator);
    }

    public Ratio reduce() {
        int divider = findDivider(this.enumarator, this.denominator);
        return new Ratio(this.enumarator/divider, this.denominator/divider);
    }

    private int findDivider(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        if (x == 0) return y;
        else if (y != 0) {
            while (x != y) {
                if (x > y) x = x - y;
                else y = y - x;
            }
        }
        return x;
    }

    public String toString() {
        return this.enumarator + "/" + this.denominator;
    }

    public double toDouble() {
        return (double)this.enumarator / this.denominator;
    }
}
