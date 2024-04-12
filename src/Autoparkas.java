public class Autoparkas extends Nuoma{

    Autoparkas(){
        super();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("***************************************");
        System.out.println("Automobiliai");
        int i = 1;
        for(Automobilis auto : super.getAutomobiliuNuomosSarasas()){
            stringBuilder.append(    i + " Marke: " + auto.getMarke() + " ** " +
                                    "Modelis: " +auto.getModelis() + " ** " +
                                    "Metai: " +auto.getMetai() + " ** " +
                                    "Nuomos kaina: " +auto.getKaina() + " ** " +
                                    "Tipas: " + (auto instanceof ElektrinisAutomobilis?"Elektra":"Naftos Kuras") + " ** " + "\n"  );
            i++;
        }
        return stringBuilder.toString();
    }
}
