package machinex.models;

import java.util.ArrayList;

/**
 *
 * @author ysfzyak
 */
public class Rechnung {
    
    protected String rechnungNo;
    protected ArrayList < Kunde > besteller_list = new ArrayList();
    protected ArrayList < Geraete > verkauft_list = new ArrayList();

    public void setRechnungNo(String rechnungNo) {
        this.rechnungNo = rechnungNo;
    }

    public void setBesteller_list(ArrayList<Kunde> besteller_list) {
        this.besteller_list = besteller_list;
    }

    public void setVerkauft_list(ArrayList<Geraete> verkauft_list) {
        this.verkauft_list = verkauft_list;
    }

    public String getRechnungNo() {
        return rechnungNo;
    }

    public ArrayList<Kunde> getBesteller_list() {
        return besteller_list;
    }

    public ArrayList<Geraete> getVerkauft_list() {
        return verkauft_list;
    }
    
    
    
}
