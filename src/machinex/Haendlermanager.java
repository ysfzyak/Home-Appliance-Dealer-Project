package machinex;

/**
 *
 * @author ysfzyak
 */
public class Haendlermanager extends Person{
    
    protected String benutzerName;
    private String passwort;
    protected String geschlecht;

    public void setBenutzerName(String benutzerName) {
        this.benutzerName = benutzerName;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
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
    
    
}
