import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //////////////////////////////////////////////////////////////////
        ////////////// Pilna automobilio uzduotis

        Nuoma nuoma = new Nuoma();

        Automobilis elektrinisAutomobilis = new ElektrinisAutomobilis(Marke.BMW, "x5", 2015, 200,10);
        Automobilis naftosKuroAutomobilis = new NaftosKuroAutomobilis(Marke.KIA, "Seltos", 2011, 100,7);
        nuoma.addAutomobilis(elektrinisAutomobilis);
        nuoma.addAutomobilis(naftosKuroAutomobilis);
        nuoma.alfaModeliai(50); // Sugeneruoja atsitiktinius automobilius


        Klientas klientas = new Klientas("Jonas", "Jonaitis");
        klientas.setKlientoID(2);
        nuoma.pridetiKleinta(klientas);


        ValdimoUI valdimoUI = new ValdimoUI(nuoma); // Patogumo deliai klientas tikrinamas, tik pagal ID
        valdimoUI.paleistiUI();
    }


}