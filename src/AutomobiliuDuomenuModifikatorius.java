import java.util.Scanner;

public abstract class AutomobiliuDuomenuModifikatorius {

    private Scanner scanner = new Scanner(System.in);
    private static String ERROR = "Ivyko Klaida, bandykite dar karta.";

    public abstract void pakeistiParametrus(Automobilis automobilis);

    public void keistiRida(Automobilis automobilis){
        System.out.println("Ivesikite nauja rida");
        automobilis.setRida(nuskanuotiIntVerte());
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
