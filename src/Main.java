import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //////////////////////////////////////////////////////////////////
        ////////////// Uzduotis nuoma

        Nuoma nuoma = new Nuoma();

        Automobilis elektrinisAutomobilis = new ElektrinisAutomobilis(Marke.BMW, "x5", 2015, 200,10);
        Automobilis naftosKuroAutomobilis = new NaftosKuroAutomobilis(Marke.KIA, "Seltos", 2011, 100,7);
        nuoma.addAutomobilis(elektrinisAutomobilis);
        nuoma.addAutomobilis(naftosKuroAutomobilis);

        nuoma.alfaModeliai(2); // Sugeneruoja atsitiktinius automobilius

        while(true){
            System.out.println("Ar norite prideti automonili i automobiliu parka?(T/N)");
            if(!nuoma.atsakymas()) break;
            nuoma.addAutomobilis();
        }

        while(true){
            System.out.println("Ar norite nuomoti automobili?(T/N)");
            if(!nuoma.atsakymas()) break;
            System.out.println(nuoma.nuomoti());
        }



        Autoparkas autoparkas = new Autoparkas();
        autoparkas.setAutomobiliuNuomosSarasas(nuoma.getAutomobiliuNuomosSarasas());
        System.out.println(autoparkas);

        //////////////////////////////////////////////////////////////////////////////
        ////////////// Uzduotis AutomobiliuDuomenuModifikatorius

        AutomobiliuDuomenuModifikatorius automobiliuDuomenuModifikatorius = new AutomobiliuDuomenuModifikatorius();
        int i = 0;
        Automobilis automobilis;
        while(true){
            System.out.println("Ar norite keisti duomenys?(T/N)");
            if(!nuoma.atsakymas()) break;
            automobilis = nuoma.getAutomobiliuNuomosSarasas().get(i);
            System.out.println(automobilis);
            if(automobilis instanceof ElektrinisAutomobilis)  automobiliuDuomenuModifikatorius.modifikuotiAutomobili((ElektrinisAutomobilis) automobilis);
            else if(automobilis instanceof NaftosKuroAutomobilis)  automobiliuDuomenuModifikatorius.modifikuotiAutomobili((NaftosKuroAutomobilis) automobilis);
            System.out.println(automobilis);
            i++;
        }

        i = 0;
        while(true){
            System.out.println("Ar norite keisti ridas?(T/N)");
            if(!nuoma.atsakymas()) break;
            automobilis = nuoma.getAutomobiliuNuomosSarasas().get(i);
            System.out.println(automobilis);
            System.out.println("Ivesikite nauja rida");
            automobiliuDuomenuModifikatorius.keistiRida(nuoma.getAutomobiliuNuomosSarasas().get(i));
            System.out.println(automobilis);
            i++;
        }

    }
}