import java.util.Scanner;

public class NKA extends AutomobiliuDuomenuModifikatorius{

    private Scanner scanner = new Scanner(System.in);
    private static String ERROR = "Ivyko Klaida, bandykite dar karta.";

    @Override
    public void pakeistiParametrus(Automobilis automobilis) {
        System.out.println("Iveskite kuro vartojima 100 km:");
        ((NaftosKuroAutomobilis) automobilis).setDegaluVartojimas(nuskanuotiIntVerte());
    }

    private int nuskanuotiIntVerte(){
        int i;
        try {
            i = Integer.parseInt(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println(ERROR);
            return nuskanuotiIntVerte();
        }
        return i;
    }

    private String nuskaityti(){
        String verte = null;
        try {
            verte = scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return verte;
    }

}


