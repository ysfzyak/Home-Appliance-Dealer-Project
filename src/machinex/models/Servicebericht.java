/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinex.models;

/**
 *
 * @author ysfzy
 */
public class Servicebericht {
    
    protected String serviceberichtNo;
    protected String produktCode1;
    protected String tcNrKunde1;
    

    public Servicebericht(String serviceberichtNo, String produktCode1, String tcNrKunde1) {
        this.serviceberichtNo = serviceberichtNo;
        this.produktCode1 = produktCode1;
        this.tcNrKunde1 = tcNrKunde1;
        
    }

    public String getServiceberichtNo() {
        return serviceberichtNo;
    }

    public void setServiceberichtNo(String serviceberichtNo) {
        this.serviceberichtNo = serviceberichtNo;
    }

    public String getTcNrKunde1() {
        return tcNrKunde1;
    }

    public void setTcNrKunde1(String tcNrKunde1) {
        this.tcNrKunde1 = tcNrKunde1;
    }

    public String getProduktCode1() {
        return produktCode1;
    }

    public void setProduktCode1(String produktCode1) {
        this.produktCode1 = produktCode1;
    }
    
    
    
    
}
