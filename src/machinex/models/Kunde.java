package machinex.models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ysfzyak
 */

public class Kunde extends Person{
    
    protected String adresse;
    protected ArrayList < Rechnung > rechnung_list = new ArrayList();
    
    public Kunde(String vorname, String nachname, String tcNummer, Date geburtstag, String telefonnummer, String adresse){
        this.vorname = vorname;
        this.nachname = nachname;
        this.tcNummer = tcNummer;
        this.geburtstag = geburtstag;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
    }

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
