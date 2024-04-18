public class NaftosKuroAutomobilis extends Automobilis{

    private int degaluVartojimas;

    public NaftosKuroAutomobilis(){

    }
    public NaftosKuroAutomobilis(Marke marke, String modelis, int metai, double kaina, int degaluVartojimas) {
        super(marke, modelis, metai, kaina);
        this.degaluVartojimas = degaluVartojimas;
    }

    public int getDegaluVartojimas() {
        return degaluVartojimas;
    }
    public void setDegaluVartojimas(int degaluVartojimas) {
        this.degaluVartojimas = degaluVartojimas;
    }

    @Override
    public String toString() {
        return  "NaftosKuro automobilis: " +
                "marke = " + super.getMarke() + " *** " +
                "modelis = " + super.getModelis() + " *** " +
                "metai = " + super.getMetai() +  " *** " +
                "kaina = " + super.getModelis() + " *** " +
                "Degalu vartojimas = " + degaluVartojimas + " *** " +
                "Rida: " + getRida() + " \n";
    }
}

