package machinex;

import java.util.ArrayList;

/**
 *
 * @author ysfzyak
 */
public class Geraete {
    
    protected String modellName;
    protected int preis;
    protected String farbe;
    protected String produktCode;
    protected int garantie;
    protected ArrayList < Rechnung > rechnung_list = new ArrayList();

    public void setRechnung_list(ArrayList<Rechnung> rechnung_list) {
        this.rechnung_list = rechnung_list;
    }

    public ArrayList<Rechnung> getRechnung_list() {
        return rechnung_list;
    }

    public void setModellName(String modellName) {
        this.modellName = modellName;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public void setProduktCode(String produktCode) {
        this.produktCode = produktCode;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }

    public String getModellName() {
        return modellName;
    }

    public int getPreis() {
        return preis;
    }

    public String getFarbe() {
        return farbe;
    }

    public String getProduktCode() {
        return produktCode;
    }

    public int getGarantie() {
        return garantie;
    }
    
    
}
