package ex07;

public class Kingdom {

    private static void showTaxToPay(Resident resident) {
        System.out.println("This " + 
            resident.getClass().getName() + 
            " resident has " + 
            resident.taxes() + " coins to pay!");
    }

    public static void main(String[] args) {
        showTaxToPay( new Resident(32) );
    }
}
