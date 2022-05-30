package machinex;

import java.sql.DriverManager; 
import java.sql.SQLException;
import machinex.models.Aussendienstmitarbeiter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import machinex.models.ServicePersonal;

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
    
    public static ObservableList<Aussendienstmitarbeiter> getDataMitarbeiter(){
        Connection con1 = connect();
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
        Connection con2 = connect();
        ObservableList<ServicePersonal> alist1 = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con2.prepareStatement("SELECT * FROM servicepersonal");
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
}

 