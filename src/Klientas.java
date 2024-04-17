import java.util.ArrayList;
import java.util.HashMap;

public class Klientas {
    private String vardas;
    private String pavarde;
    private Automobilis nuomojamasAuto;
    private Automobilis paskutinisNuomotasAuto;
    private Integer klientoID;

    private HashMap<Automobilis, Integer> automobiliuSarasas;

    public Klientas(){
        automobiliuSarasas = new HashMap<>();
    }
    public Klientas(String vardas, String pavarde){
        this.vardas = vardas;
        this.pavarde = pavarde;
        automobiliuSarasas = new HashMap<>();

    }


    public Integer getKlientoID() {
        return klientoID;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public Automobilis getNuomojamasAuto() {
        return nuomojamasAuto;
    }

    public Automobilis getPaskutinisNuomotasAuto() {
        return paskutinisNuomotasAuto;
    }

    public HashMap<Automobilis, Integer> getAutomobiliuSarasas() {
        return automobiliuSarasas;
    }
    public void setKlientoID(Integer klientoID) {
        this.klientoID = klientoID;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public void setNuomojamasAuto(Automobilis nuomojamasAuto) {
        this.nuomojamasAuto = nuomojamasAuto;
    }

    public void setPaskutinisNuomotasAuto(Automobilis paskutinisNuomotasAuto) {
        this.paskutinisNuomotasAuto = paskutinisNuomotasAuto;
    }

    public void setAutomobiliuSarasas(HashMap<Automobilis, Integer> automobiliuSarasas) {
        this.automobiliuSarasas = automobiliuSarasas;
    }

}
