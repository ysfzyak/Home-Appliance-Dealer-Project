package machinex;

/**
 *
 * @author ysfzy
 */
public class ServicePersonal extends Person{
 
    protected String benutzerName;
    private String passwort;
    protected String geschlecht;
    protected int gehalt;

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
