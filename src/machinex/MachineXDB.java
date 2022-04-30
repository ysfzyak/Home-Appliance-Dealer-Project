package machinex;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import machinex.models.Aussendienstmitarbeiter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

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
            /*Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT * FROM geraete");  //z.B Informationen aus der Geraete-Datenbank auslesen.
           
            while(rs.next()){ 
                System.out.println(rs.getString(1)+"   "+rs.getInt(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getInt(5));  
                con.close();  
            }*/
            
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
    
    public Connection getConnection(){
        if(conn == null){
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MachineXDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url,uname,pass);
            } catch (SQLException ex) {
                Logger.getLogger(MachineXDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
    
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
        }catch(Exception e){
            System.out.println(e);
        }
        return alist;
    }
}

 