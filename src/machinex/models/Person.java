package machinex.models;

import java.util.Date;

/**
 *
 * @author ysfzyak
 */
public class Person {
    
    protected String vorname;
    protected String nachname;
    protected String tcNummer;
    protected Date geburtstag;
    protected String telefonnummer;

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setTcNummer(String tcNummer) {
        this.tcNummer = tcNummer;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getTcNummer() {
        return tcNummer;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }
    
    
    
    
    
}
