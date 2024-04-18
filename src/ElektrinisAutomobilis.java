public class ElektrinisAutomobilis extends Automobilis{
    private int krovimoLaikash;
    public ElektrinisAutomobilis(){

    }
    public ElektrinisAutomobilis(Marke marke, String modelis, int metai, double kaina, int krovimoLaikash) {
        super(marke, modelis, metai, kaina);
        this.krovimoLaikash = krovimoLaikash;
    }

    public double getKrovimoLaikash() {
        return krovimoLaikash;
    }

    public void setKrovimoLaikash(int krovimoLaikash) {
        this.krovimoLaikash = krovimoLaikash;
    }
    @Override
    public String toString() {
        return "Elektrinis automobilis: " +
                "marke = " + super.getMarke() + " *** " +
                "modelis = " + super.getModelis() + "  *** " +
                "metai = " + super.getMetai() +  " *** " +
                "kaina = " + super.getKaina() + " *** " +
                "Krovimo laikas = " + krovimoLaikash + " *** " +
                "Rida: " + getRida();
    }
}
