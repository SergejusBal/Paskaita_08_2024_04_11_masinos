public class Automobilis {
    private Marke marke;
    private String modelis;
    private int metai;
    private double kaina;
    private int rida;

    public int getRida() {
        return rida;
    }

    public void setRida(int rida) {
        this.rida = rida;
    }

    public Automobilis(){

    }
    public Automobilis(Marke marke, String modelis, int metai, double kaina) {
        this.marke = marke;
        this.modelis = modelis;
        this.metai = metai;
        this.kaina = kaina;
    }

    public void setMarke(Marke marke) {
        this.marke = marke;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    public void setMetai(int metai) {
        this.metai = metai;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public Marke getMarke() {
        return marke;
    }

    public String getModelis() {
        return modelis;
    }

    public int getMetai() {
        return metai;
    }

    public double getKaina() {
        return kaina;
    }

    @Override
    public boolean equals(Object o) {
        Automobilis automoblis = (Automobilis) o;
        if (this.marke.equals(automoblis.marke) && this.getMetai() == automoblis.metai && this.modelis.equals(automoblis.modelis)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Automobilis: \n" +
                "marke = " + marke + "\n" +
                "modelis = " + modelis + "\n" +
                "metai = " + metai +  "\n" +
                "kaina = " + kaina;
    }
}
