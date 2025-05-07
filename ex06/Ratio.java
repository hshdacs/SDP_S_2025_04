package ex06;

public class Ratio /* extends Object */ {
    private int enumarator, denominator;

    public Ratio(int enumarator, int denominator) {
        this.enumarator = enumarator;
        this.denominator = denominator;
    }

    public Ratio add(Ratio that) {
        int myEnumarator = this.enumarator * that.denominator +
            that.enumarator * this.denominator;
        int myDenominator = this.denominator * that.denominator;
        return new Ratio(myEnumarator, myDenominator);
    }

    @Override
    public String toString() {
        return this.enumarator + "/" + this.denominator;
    }
}
