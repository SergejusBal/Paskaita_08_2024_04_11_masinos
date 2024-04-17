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
        return  "Automobilis: \n" +
                "marke = " + super.getMarke() + "\n" +
                "modelis = " + super.getModelis() + "\n" +
                "metai = " + super.getMetai() +  "\n" +
                "kaina = " + super.getModelis() + "\n" +
                "Degalu vartojimas = " + degaluVartojimas + "\n" +
                "Rida: " + getRida() + "\n";
    }
}

