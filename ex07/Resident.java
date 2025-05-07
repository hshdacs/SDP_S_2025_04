package ex07;

public class Resident {
    private int income;

    public Resident(int income) {
        this.income = income;
    }

    public int incomeBeforeTax() {
        return this.income;
    }

    public int taxes() {
        int taxToPay = incomeBeforeTax() / 10;
        if (taxToPay < 1) taxToPay = 1;
        return taxToPay;
    }
}
