import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Nuoma nuoma = new Nuoma();

        Automobilis elektrinisAutomobilis = new ElektrinisAutomobilis(Marke.BMW, "x5", 2015, 200,10);
        Automobilis naftosKuroAutomobilis = new NaftosKuroAutomobilis(Marke.KIA, "Seltos", 2011, 100,7);
        nuoma.addAutomobilis(elektrinisAutomobilis);
        nuoma.addAutomobilis(naftosKuroAutomobilis);

        nuoma.alfaModeliai(50); // Sugeneruoja atsitiktinius automobilius

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





    }
}