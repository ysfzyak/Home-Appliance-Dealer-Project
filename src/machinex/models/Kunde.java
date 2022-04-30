package machinex.models;

import java.util.ArrayList;

/**
 *
 * @author ysfzyak
 */
public class Kunde extends Person{
    
    protected String adresse;
    protected ArrayList < Rechnung > rechnung_list = new ArrayList();

    public void setRechnung_list(ArrayList<Rechnung> rechnung_list) {
        this.rechnung_list = rechnung_list;
    }

    public ArrayList<Rechnung> getRechnung_list() {
        return rechnung_list;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }
    
}
