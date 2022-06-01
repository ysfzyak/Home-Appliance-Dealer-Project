package machinex.models;

import java.util.ArrayList;

/**
 *
 * @author ysfzyak
 */

public class Rechnung {
    
    protected String rechnungNo;
    protected String tcNrKunde;
    protected String produktCode;
    protected ArrayList < Kunde > besteller_list = new ArrayList();
    protected ArrayList < Geraete > verkauft_list = new ArrayList();
    
    public Rechnung(String rechnungNo, String produktCode, String tcNrKunde) {
        this.rechnungNo = rechnungNo;
        this.produktCode = produktCode;
        this.tcNrKunde = tcNrKunde;
    }

    public String getRechnungNo() {
        return rechnungNo;
    }
    public String getTcNrKunde() {
        return tcNrKunde;
    }
    public String getProduktCode() {
        return produktCode;
    }
    public ArrayList<Kunde> getBesteller_list() {
        return besteller_list;
    }
    public ArrayList<Geraete> getVerkauft_list() {
        return verkauft_list;
    }
    public void setRechnungNo(String rechnungNo) {
        this.rechnungNo = rechnungNo;
    }
    public void setTcNrKunde(String tcNrKunde) {
        this.tcNrKunde = tcNrKunde;
    }
    public void setProduktCode(String produktCode) {
        this.produktCode = produktCode;
    }
}
