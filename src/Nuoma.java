import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Nuoma {

    Scanner scanner;

    private ArrayList<Automobilis> automobiliuNuomosSarasas;
    Nuoma(){
        automobiliuNuomosSarasas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public ArrayList<Automobilis> getAutomobiliuNuomosSarasas() {
        return automobiliuNuomosSarasas;
    }

    public void setAutomobiliuNuomosSarasas(ArrayList<Automobilis> automobiliuNuomosSarasas) {
        this.automobiliuNuomosSarasas = automobiliuNuomosSarasas;
    }

    public Automobilis irasytiAuto(){
        int tipas;
        Automobilis automobilis = null;
        try{
            System.out.println("Pasirintike automobilio tipa: Ekektromobilis 1 Naftos kuro 2");
            tipas = scanner.nextInt();
            switch (tipas){
                case 1:
                    System.out.println("Iveskite krovimo laika (val)");
                    automobilis = new ElektrinisAutomobilis();
                    ((ElektrinisAutomobilis) automobilis).setKrovimoLaikash(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Iveskite kuro suvartojima 100 km");
                    automobilis = new NaftosKuroAutomobilis();
                    ((NaftosKuroAutomobilis) automobilis).setDegaluVartojimas(scanner.nextInt());
                    break;
                default:
                    System.out.println("Ivyko klaida bandykite dar karta");
                    irasytiAuto();
                    return automobilis;
            }
            scanner.nextLine(); // kodel reikia suvalgyti cia?

            System.out.println("Pasirinkite marke: (galimos markes:  AUDI, BMW, FORD, TOYOTA, SUBARU, BENTLEY, NISSAN, KIA, JEEP, PORSCHE;");
            automobilis.setMarke(Marke.valueOf(scanner.nextLine()));
            System.out.println("Iveskite modeli:");
            automobilis.setModelis(scanner.nextLine());
            System.out.println("Iveskite Nuomos kaina");
            automobilis.setKaina(scanner.nextDouble());
            System.out.println("Iveskite metus");
            automobilis.setMetai(scanner.nextInt());
        }catch(InputMismatchException | IllegalArgumentException e){
            System.out.println("Ivyko klaida bandykite dar karta");
            scanner.nextLine();
            irasytiAuto();
            return automobilis;
        }

        return automobilis;
    }

    public void addAutomobilis(){
        automobiliuNuomosSarasas.add(irasytiAuto());
    }
    public void addAutomobilis(Automobilis automobilis){
        automobiliuNuomosSarasas.add(automobilis);
    }

    public Automobilis nuomoti(){
        int dienu = 0;
        System.out.println("Kokiam laikotarpiui norite nuomoti(dienos)");
        try {
             dienu = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("Ivyko klaida");
            return nuomoti();
        }

        System.out.println("Koki Automobili nuorite isnuomoti? ");
        Automobilis automobilis = irasytiAuto();
        int index = -1;
        for(int i = 0; i < automobiliuNuomosSarasas.size();i++){
            if(automobilis.equals(automobiliuNuomosSarasas.get(i)) &&  automobiliuNuomosSarasas.get(i) instanceof ElektrinisAutomobilis) {
                index = i;
                break;
            }else if (automobilis.equals(automobiliuNuomosSarasas.get(i)) &&  automobiliuNuomosSarasas.get(i) instanceof NaftosKuroAutomobilis) {
                index = i;
                break;
            }
        }

        if (index == -1){
            System.out.println("Tokio Automobilio nera");
            return null;
        } else if (automobilis.getKaina() < automobiliuNuomosSarasas.get(index).getKaina()) {
            System.out.println("Uz tokia kaina automobilio nenuomojame");
            return null;
        }
        System.out.println("Nuomos kaina yra: " + ( automobiliuNuomosSarasas.get(index).getKaina() * dienu ));
        System.out.println("**************");
        automobiliuNuomosSarasas.remove(index);
        return automobilis;
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
