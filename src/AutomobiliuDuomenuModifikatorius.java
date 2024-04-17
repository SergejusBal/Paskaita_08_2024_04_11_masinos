import java.util.InputMismatchException;
import java.util.Scanner;

public class AutomobiliuDuomenuModifikatorius extends Automobilis {

    private Scanner scanner = new Scanner(System.in);
    private static String ERROR = "Ivyko klaida";

    public void modifikuotiAutomobili (ElektrinisAutomobilis automobilis) {
                    int t = 0;
            System.out.println("Iveskite kvovimo laika");
            try {
                t = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(ERROR);
                modifikuotiAutomobili(automobilis);
                return;
            }
             automobilis.setKrovimoLaikash(t);
    }

    public void modifikuotiAutomobili (NaftosKuroAutomobilis automobilis) {

        int t = 0;
        System.out.println("Iveskite kuro sanaudas");
        try {
            t = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ERROR);
            modifikuotiAutomobili(automobilis);
            return;
        }
         automobilis.setDegaluVartojimas(t);
    }


    public void keistiRida(Automobilis automobilis){
        int t = 0;
        try {
            t = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ERROR);
            keistiRida(automobilis);
            return;
        }
        automobilis.setRida(t);
    }

}
