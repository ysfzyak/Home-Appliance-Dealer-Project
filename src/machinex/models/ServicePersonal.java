package machinex.models;

import java.util.Date;

/**
 *
 * @author ysfzyak
 */
public class ServicePersonal extends Person{
 
    protected String benutzerName;
    private String passwort;
    protected String geschlecht;
    protected int gehalt;
    
    public ServicePersonal(String vorname, String nachname, String tcNummer, Date geburtstag, String telefonnummer, String benutzerName, String passwort, String geschlecht, int gehalt){
        this.vorname = vorname;
        this.nachname = nachname;
        this.tcNummer = tcNummer;
        this.geburtstag = geburtstag;
        this.telefonnummer = telefonnummer;
        this.benutzerName = benutzerName;
        this.passwort = passwort;
        this.geschlecht = geschlecht;
        this.gehalt = gehalt;
    }

    public void setBenutzerName(String benutzerName) {
        this.benutzerName = benutzerName;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public void setGehalt(int gehalt) {
        this.gehalt = gehalt;
    }

    public String getBenutzerName() {
        return benutzerName;
    }

    public String getPasswort() {
        return passwort;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public int getGehalt() {
        return gehalt;
    }
    
}
