package machinex;

import java.sql.DriverManager; 
import java.sql.SQLException;
import machinex.models.Aussendienstmitarbeiter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import machinex.models.Geraete;
import machinex.models.Kunde;
import machinex.models.Rechnung;
import machinex.models.ServicePersonal;
import machinex.models.Servicebericht;

/**
 *
 * @author ysfzyak
 */

public class MachineXDB {
    
    public static Connection connect(){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/machinex","root","");  
            return con;
            
        }catch(ClassNotFoundException | SQLException e){ 
            System.out.println(e);
            return null;
        }  
    }
    
    static Connection conn;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/machinex";
    static String uname = "root";
    static String pass = "";
    static Connection con1 = connect();
    
    public static ObservableList<Aussendienstmitarbeiter> getDataMitarbeiter(){
        ObservableList<Aussendienstmitarbeiter> alist = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con1.prepareStatement("SELECT * FROM aussendienstmitarbeiter");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                alist.add(new Aussendienstmitarbeiter(rs.getString("vorname"), 
                        rs.getString("nachname"), 
                        rs.getString("tcnummer"), 
                        rs.getDate("geburtstag"), 
                        rs.getString("telefonnummer"),
                        rs.getString("benutzername"),
                        rs.getString("passwort"),
                        rs.getString("geschlecht"),
                        (Integer.parseInt(rs.getString("gehalt")))));               
            }
        }catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
        return alist;
    }
    
    public static ObservableList<ServicePersonal> getDataServicepersonal(){
        ObservableList<ServicePersonal> alist1 = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con1.prepareStatement("SELECT * FROM servicepersonal");
            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()){   
                alist1.add(new ServicePersonal(rs1.getString("vorname"), 
                        rs1.getString("nachname"), 
                        rs1.getString("tcnummer"), 
                        rs1.getDate("geburtstag"), 
                        rs1.getString("telefonnummer"),
                        rs1.getString("benutzername"),
                        rs1.getString("passwort"),
                        rs1.getString("geschlecht"),
                        (Integer.parseInt(rs1.getString("gehalt")))));               
            }
        }catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
        return alist1;
    }
    
    public static ObservableList<Kunde> getDataKunde(){
        ObservableList<Kunde> alist2 = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con1.prepareStatement("SELECT * FROM kunde");
            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()){   
                alist2.add(new Kunde(rs2.getString("vorname"), 
                        rs2.getString("nachname"), 
                        rs2.getString("tcnummer"), 
                        rs2.getDate("geburtstag"), 
                        rs2.getString("telefonnummer"),
                        rs2.getString("adresse")));               
            }
        }catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
        return alist2;
    }
    
    public static ObservableList<Geraete> getDataGeraete(){
        ObservableList<Geraete> alist3 = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con1.prepareStatement("SELECT * FROM geraete");
            ResultSet rs3 = ps.executeQuery();
            while (rs3.next()){   
                alist3.add(new Geraete(rs3.getString("modellname"), 
                        rs3.getInt("preis"), 
                        rs3.getString("farbe"), 
                        rs3.getString("produktcode"), 
                        rs3.getInt("garantie")));               
            }
        }catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
        return alist3;
    }
    
    public static ObservableList<Rechnung> getDataRechnung(){
        ObservableList<Rechnung> alist4 = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con1.prepareStatement("SELECT * FROM rechnung");
            ResultSet rs4 = ps.executeQuery();
            while (rs4.next()){   
                alist4.add(new Rechnung(rs4.getString("rechnungno"), 
                        rs4.getString("produkt"), 
                        rs4.getString("kunde")));               
            }
        }catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
        return alist4;
    }
    
    public static ObservableList<Servicebericht> getDataServicebericht(){
        ObservableList<Servicebericht> alist5 = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con1.prepareStatement("SELECT * FROM servicebericht");
            ResultSet rs5 = ps.executeQuery();
            while (rs5.next()){   
                alist5.add(new Servicebericht(rs5.getString("serviceberichtno"), 
                        rs5.getString("produkt1"), 
                        rs5.getString("kunde1")));               
            }
        }catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
        return alist5;
    }
    
}
