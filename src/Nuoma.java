import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Nuoma {

    Scanner scanner;
    private static String ERRORZINUTE = "Ivyko Klaida, bandykite dar karta.";
    private ArrayList<Automobilis> automobiliuNuomosSarasas;
    private ArrayList<Klientas> klientuSarasas;

    Nuoma(){
        automobiliuNuomosSarasas = new ArrayList<>();
        klientuSarasas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public ArrayList<Automobilis> getAutomobiliuNuomosSarasas() {
        return automobiliuNuomosSarasas;
    }

    public ArrayList<Klientas> getKlientuSarasas() {
        return klientuSarasas;
    }

    public void setAutomobiliuNuomosSarasas(ArrayList<Automobilis> automobiliuNuomosSarasas) {
        this.automobiliuNuomosSarasas = automobiliuNuomosSarasas;
    }

    public void setKlientuSarasas(ArrayList<Klientas> klientuSarasas) {
        this.klientuSarasas = klientuSarasas;
    }

    public void priskirtiAutomobili(Klientas klientas, Automobilis auto, Integer dienos){
        klientas.setNuomojamasAuto(auto);
        klientas.getAutomobiliuSarasas().put(auto,dienos);
    }
    public void pabaigtiNuoma(){
        Klientas klientas = nuskanuotiKlienta();
        Klientas rastasKlientas = rastiKlienta(klientas);
        if(rastiKlienta(klientas) !=  null) {
            Automobilis auto = rastasKlientas.getNuomojamasAuto();
            addAutomobilis(auto);
            rastasKlientas.setNuomojamasAuto(null);
            rastasKlientas.setPaskutinisNuomotasAuto(auto);
        }
        else {
            System.out.println("Tokio kliento nera");
            pabaigtiNuoma();
        }
    }

    public void addAutomobilis(){
        automobiliuNuomosSarasas.add(irasytiAuto());
    }
    public void addAutomobilis(Automobilis automobilis){
        automobiliuNuomosSarasas.add(automobilis);
    }

    public Automobilis irasytiAuto(){
        Automobilis automobilis = gautiAutomobilioTipa();
        automobilis.setMarke(gautiMarke());
        automobilis.setModelis(gautiAutomobilioModeli());
        automobilis.setKaina(gautiAutomobilioNuomosKaina());
        automobilis.setMetai(gautiAutomobilioMetus());
        return automobilis;
    }

    public Automobilis nuomoti(){
        int dienu = nuskaityriDienuSkaiciu();
        Automobilis nuomojamasAuto = nuskaitytiNuomojamaAuto();
        Klientas nuomininkas = pasirinktiKlienta();
        priskirtiAutomobili(nuomininkas, nuomojamasAuto, dienu);
        System.out.println("Automobilis Isnuomota uz: " + ( nuomojamasAuto.getKaina() * dienu ));
        automobiliuNuomosSarasas.remove(nuomojamasAuto);
        return nuomojamasAuto;
    }

    public Klientas pridetiKleinta(){
        Klientas klientas = nuskanuotiKlienta();
        if(rastiKlienta(klientas) != null){
            System.out.println("Toks klientas jau yra");
        }
        klientuSarasas.add(klientas);
        return klientas;
    }

    private Klientas rastiKlienta(Klientas klientas){
        for(int i = 0; i < klientuSarasas.size(); i ++){
            if(klientas.getKlientoID() == klientuSarasas.get(i).getKlientoID()){
                return klientuSarasas.get(i);
            }
        }
        return null;
    }
    private Automobilis nuskaitytiNuomojamaAuto(){
        System.out.println("Koki norite issinuomoti automobili?");
        Automobilis automobilis = gautiAutomobilioTipa();
        automobilis.setMarke(gautiMarke());
        automobilis.setModelis(gautiAutomobilioModeli());
        automobilis.setMetai(gautiAutomobilioMetus());

        Automobilis rastasAutomobilis = rastiAutomobili(automobilis);
        if(rastasAutomobilis == null) return nuskaitytiNuomojamaAuto();
        return rastasAutomobilis;
    }

    private Klientas pasirinktiKlienta(){
        System.out.println("Prasome pasirinkti: Naujas Klientas (1), Senas Klientas (2)");
        int pasirinkimas = nuskanuotiIntVerte();

        switch (pasirinkimas){
            case 1:
                return pridetiKleinta();
            case 2:
                Klientas klientas = nuskanuotiKlienta();
                Klientas rastasKlientas = rastiKlienta(klientas);
                if(rastiKlienta(klientas) == null){
                    System.out.println("Tokio kliento nera");
                    return pasirinktiKlienta();
                }
                else return rastasKlientas;
        }
        return new Klientas();
    }

    private Klientas nuskanuotiKlienta(){
        Klientas klientas = new Klientas();
        System.out.println("Irasykite varda:");
        klientas.setVardas(nuskanuotiStringVerte());
        System.out.println("Irasykite pavarde:");
        klientas.setPavarde(nuskanuotiStringVerte());
        System.out.println("Iveskite klineto ID");
        klientas.setKlientoID(nuskanuotiIntVerte());
        return klientas;
    }


    private Automobilis rastiAutomobili(Automobilis automobilis){
        int index = -1;
        for(int i = 0; i < automobiliuNuomosSarasas.size(); i++){

            if      (
                    automobilis.getMarke().equals(automobiliuNuomosSarasas.get(i).getMarke()) &&
                    automobilis.getMarke().equals(automobiliuNuomosSarasas.get(i).getMarke()) &&
                    automobilis.getMarke().equals(automobiliuNuomosSarasas.get(i).getMarke()) &&
                    automobiliuNuomosSarasas.get(i) instanceof ElektrinisAutomobilis
            ) {

                index = i;
                break;
            }
            else if (
                    automobilis.getMarke().equals(automobiliuNuomosSarasas.get(i).getMarke()) &&
                    automobilis.getMarke().equals(automobiliuNuomosSarasas.get(i).getMarke()) &&
                    automobilis.getMarke().equals(automobiliuNuomosSarasas.get(i).getMarke()) &&
                    automobiliuNuomosSarasas.get(i) instanceof NaftosKuroAutomobilis
            ) {

                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Tokio Automobilio nera");
            return null;
        }else {

        }  return automobiliuNuomosSarasas.get(index);
    }

    private int gautiAutomobilioMetus(){
        System.out.println("Iveskite metus");
        return nuskanuotiIntVerte();
    }

    private int nuskaityriDienuSkaiciu(){
        System.out.println("Kokiam laikotarpiui norite nuomoti(dienos)");
        return nuskanuotiIntVerte();
    }

    private double gautiAutomobilioNuomosKaina(){
        System.out.println("Iveskite Nuomos kaina");
        return nuskanuotiDoubleVerte();
    }

    private String gautiAutomobilioModeli(){
        System.out.println("Iveskite modeli:");
        return nuskanuotiStringVerte();
    }

    private Automobilis gautiAutomobilioTipa(){
        System.out.println("Pasirintike automobilio tipa: \nEkektromobilis (1) NaftosKuro (2)");
        return nuskanuotiAutomobilioTipa();
    }

    private Automobilis nuskanuotiAutomobilioTipa() {
        int tipas = -1;
        tipas = nuskanuotiIntVerte();

        Automobilis automobilis;
            switch (tipas) {
                case 1:
                    automobilis = new ElektrinisAutomobilis();
                    ((ElektrinisAutomobilis) automobilis).setKrovimoLaikash(gautiKrovimoLaika());
                    break;
                case 2:
                    automobilis = new NaftosKuroAutomobilis();
                    ((NaftosKuroAutomobilis) automobilis).setDegaluVartojimas(gautiDegaluVartojima());
                    break;
                default:
                    System.out.println(ERRORZINUTE);
                    return nuskanuotiAutomobilioTipa();
            }
        return new Automobilis();
    }


    private int gautiKrovimoLaika(){
        System.out.println("Iveskite krovimo laika (val)");
        return nuskanuotiIntVerte();
    }

    private int gautiDegaluVartojima(){
        System.out.println("Iveskite kuro suvartojima 100 km");
        return nuskanuotiIntVerte();
    }


    private Marke gautiMarke() {
        System.out.println("Pasirinkite marrke: \n" +
                "AUDI (1), BMW (2), FORD (3), TOYOTA (4), SUBARU (5), BENTLEY (6), NISSAN (7), KIA (8), JEEP (9), PORSCHE (10)");
        return nuskatuotiMarke();
    }

    private Marke nuskatuotiMarke() {
        int index = nuskanuotiIntVerte()-1;

        if (index > Marke.values().length - 1) {
            System.out.println(ERRORZINUTE);
            return nuskatuotiMarke();
        }
        return Marke.values()[index];
    }


    private String nuskanuotiStringVerte(){
        return nuskaityti();
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

    private double nuskanuotiDoubleVerte(){
        double i;
        try {
            i = Double.parseDouble(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println(ERRORZINUTE);
            return nuskanuotiDoubleVerte();
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

    public void alfaModeliai(int kiekis){
        Automobilis automobilis = null;
        Random random = new Random();
        for(int i = 0 ; i < kiekis; i++){
            if(i/2==0) {
                automobilis = new ElektrinisAutomobilis();
                ((ElektrinisAutomobilis) automobilis).setKrovimoLaikash(random.nextInt(4,10));
            }
            else if(i/2!=0) {
                automobilis = new NaftosKuroAutomobilis();
                ((NaftosKuroAutomobilis) automobilis).setDegaluVartojimas(random.nextInt(4,10));
            }
            automobilis.setMetai(random.nextInt(2000,2015));
            automobilis.setModelis("Alfa");
            BigDecimal kaina = new BigDecimal(random.nextDouble(100,500));
            kaina = kaina.setScale(2, RoundingMode.UP);
            automobilis.setKaina(Double.parseDouble(kaina.toString()));
            automobilis.setMarke(Marke.values()[random.nextInt(0,Marke.values().length)]);
            automobiliuNuomosSarasas.add(automobilis);
        }
    }


    public boolean atsakymas() {
        while(true) {
            String scVerte = scanner.nextLine();
            if(scVerte.toUpperCase().equals("T")) return true;
            else if (scVerte.toUpperCase().equals("N")) return false;
        }
    }



}
