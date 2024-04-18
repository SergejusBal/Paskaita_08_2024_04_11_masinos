import java.util.InputMismatchException;
import java.util.Scanner;

public class AutomobiliuDuomenuModifikatorius extends Automobilis {

    private Scanner scanner = new Scanner(System.in);
    private static String ERROR = "Ivyko Klaida, bandykite dar karta.";

    public void modifikuotiAutomobili (ElektrinisAutomobilis automobilis) {
        System.out.println("Iveskite baterijos talpa:");
        automobilis.setKrovimoLaikash(nuskanuotiIntVerte());
    }

    public void modifikuotiAutomobili (NaftosKuroAutomobilis automobilis) {
        System.out.println("Iveskite kuro vartojima 100 km:");
        automobilis.setDegaluVartojimas(nuskanuotiIntVerte());
    }


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
