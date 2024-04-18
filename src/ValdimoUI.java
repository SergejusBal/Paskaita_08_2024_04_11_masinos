import java.util.Scanner;

public class ValdimoUI {

    private Nuoma nuomosInfo;
    private Autoparkas autoparkas;
    private AutomobiliuDuomenuModifikatorius automobiliuDuomenuModifikatorius;
    private Scanner scanner;
    private static String ERRORZINUTE = "Ivyko Klaida, bandykite dar karta.";

    public ValdimoUI(Nuoma nuomosInfo) {
        this.nuomosInfo = nuomosInfo;
        scanner = new Scanner(System.in);
        autoparkas = new Autoparkas();
        autoparkas.setAutomobiliuNuomosSarasas(nuomosInfo.getAutomobiliuNuomosSarasas());
        automobiliuDuomenuModifikatorius = new AutomobiliuDuomenuModifikatorius();
    }

    public void paleistiUI(){
        boolean dirbti = true;
        while(dirbti){
            System.out.println("************************Pasirinkite paslauga: ************************");
            System.out.println("Prideti automobili i parka. (1)");
            System.out.println("Prideti klienta i nuomininku sarasa. (2)");
            System.out.println("Keisti automobiliu duomenys. (3)");
            System.out.println("Keisti automobiliu rida. (4)");
            System.out.println("Nuomoti automobili. (5)");
            System.out.println("Grazinti automobili. (6)");
            System.out.println("Patikrinti kliento automobiliu istorija. (7)");
            System.out.println("Spausdinti automobiliu parka. (8)");
            System.out.println("Pabaigti darba .(0)");
            int atsakymas = nuskanuotiIntVerte();
            int pasirinkimas;

            switch (atsakymas){
                case 1:
                    nuomosInfo.addAutomobilis();
                    break;
                case 2:
                    nuomosInfo.pridetiKleinta();
                    break;
                case 3:
                    System.out.println(autoparkas);
                    pasirinkimas = -1;
                    System.out.println("Pasirinkite numeri, kuri automobili norite modifikuoti:");
                    pasirinkimas = nuskanuotiIntVerte();

                    if (0 < pasirinkimas && pasirinkimas < nuomosInfo.getAutomobiliuNuomosSarasas().size()+1) {
                        Automobilis automobilis = nuomosInfo.getAutomobiliuNuomosSarasas().get(pasirinkimas-1);
                        System.out.println("Pasirinktas automobilis");
                        System.out.println(automobilis);
                        if(automobilis instanceof ElektrinisAutomobilis)  automobiliuDuomenuModifikatorius.modifikuotiAutomobili((ElektrinisAutomobilis) automobilis);
                        else if(automobilis instanceof NaftosKuroAutomobilis)  automobiliuDuomenuModifikatorius.modifikuotiAutomobili((NaftosKuroAutomobilis) automobilis);
                        System.out.println("Modifikuotas automobilis");
                        System.out.println(automobilis);
                    } else {
                        System.out.println("Tokio automobilio nera");
                    }
                    break;
                case 4:
                    System.out.println(autoparkas);
                    pasirinkimas = -1;
                    System.out.println("Pasirinkite numeri, kurio automobilio rida norite modifikuoti:");
                    pasirinkimas = nuskanuotiIntVerte();

                    if (0 < pasirinkimas && pasirinkimas < nuomosInfo.getAutomobiliuNuomosSarasas().size()+1) {
                        Automobilis automobilis = nuomosInfo.getAutomobiliuNuomosSarasas().get(pasirinkimas-1);
                        System.out.println("Pasirinktas automobilis");
                        System.out.println(automobilis);
                        automobiliuDuomenuModifikatorius.keistiRida(nuomosInfo.getAutomobiliuNuomosSarasas().get(pasirinkimas-1));
                        System.out.println("Modifikuotas automobilis");
                        System.out.println(automobilis);
                    } else {
                        System.out.println("Tokio automobilio nera");
                    }
                    break;
                case 5:
                    nuomosInfo.nuomoti();
                    break;
                case 6:
                    nuomosInfo.pabaigtiNuoma();
                    break;
                case 7:
                    System.out.println(nuomosInfo.filtruotiKlienta().getAutomobiliuSarasas());
                    break;
                case 8:
                    System.out.println(autoparkas);
                    break;
                case 0:
                    System.out.println("UI uzsidaro");
                    dirbti = false;
                    break;
                default:
                    System.out.println("Tokios operacijos nera");
                    break;
            }

        }

    }



    private int nuskanuotiIntVerte(){
        int i;
        try {
            i = Integer.parseInt(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println(ERRORZINUTE);
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
