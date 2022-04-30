/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinex;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import machinex.models.Aussendienstmitarbeiter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ysfzy
 */
public class ManagerScreenController implements Initializable {
    @FXML
    private TableView<Aussendienstmitarbeiter> mitarbeiterTable;
    @FXML
    private Tab mitarbeiterTab;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,String> aVornameCol;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,String> aNachnameCol;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,String> aTcNrCol;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,Date> aGeburtstagCol;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,String> aTelefonnummerCol;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,String> aBenutzernameCol;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,String> aPasswortCol;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,String> aGeschlectCol;
    @FXML
    private TableColumn<Aussendienstmitarbeiter,Integer> aGehaltCol;
    @FXML
    private Button addMitarbeiterBtn;
    @FXML
    private Button mitarbeiterRefreshBtn;
    @FXML
    private Button mitarbeiterlöschenBtn;
    @FXML 
    private TextField txt_vorname;
    @FXML 
    private TextField txt_nachname;
    @FXML 
    private TextField txt_tcnummer;
    @FXML 
    private TextField txt_geburtstag;
    @FXML 
    private TextField txt_telefonnummer;
    @FXML 
    private TextField txt_geschlecht;
    @FXML 
    private TextField txt_gehalt;
    @FXML 
    private TextField txt_benutzername;
    @FXML 
    private TextField txt_passwort;
    
    
    ObservableList<Aussendienstmitarbeiter> listA;
    
    int index = -1;
    Connection con1 = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void addMitarbeiter(){
        con1 = MachineXDB.connect();
        String sql = "INSERT INTO aussendienstmitarbeiter(vorname,nachname,tcnummer,geburtstag,telefonnummer,benutzername,passwort,geschlecht,gehalt)values(?,?,?,?,?,?,?,?,?)";
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_vorname.getText());
            pst.setString(2, txt_nachname.getText());
            pst.setString(3, txt_tcnummer.getText());
            pst.setString(4, txt_geburtstag.getText());
            pst.setString(5, txt_telefonnummer.getText());
            pst.setString(6, txt_benutzername.getText());
            pst.setString(7, txt_passwort.getText());
            pst.setString(8, txt_geschlecht.getText());
            pst.setString(9, txt_gehalt.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Aussendienstmitarbeiter wird hinzugefügt!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        aVornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        aNachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        aTcNrCol.setCellValueFactory(new PropertyValueFactory<>("tcNummer"));
        aGeburtstagCol.setCellValueFactory(new PropertyValueFactory<>("geburtstag"));
        aTelefonnummerCol.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        aBenutzernameCol.setCellValueFactory(new PropertyValueFactory<>("benutzerName"));
        aPasswortCol.setCellValueFactory(new PropertyValueFactory<>("passwort"));
        aGeschlectCol.setCellValueFactory(new PropertyValueFactory<>("geschlecht"));
        aGehaltCol.setCellValueFactory(new PropertyValueFactory<>("gehalt"));
        
        listA = MachineXDB.getDataMitarbeiter();
        mitarbeiterTable.setItems(listA);
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    String query = null;
    Connection con = null;
    PreparedStatement prst = null;
    ResultSet rset = null;
    Aussendienstmitarbeiter mtr = null;
    
    ObservableList<Aussendienstmitarbeiter> MitarbeiterList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
    } 
    
    @FXML
    private void refreshTable(){
        try {
            MitarbeiterList.clear();
            query = "SELECT * FROM `aussendienstmitarbeiter`";
            prst = con.prepareStatement(query);
            rset = prst.executeQuery();
            
            while(rset.next()){
                MitarbeiterList.add(new Aussendienstmitarbeiter(
                        rset.getString("vorname"),
                        rset.getString("nachname"),
                        rset.getString("tcnummer"),
                        rset.getDate("geburtstag"),
                        rset.getString("telefonnummer"),
                        rset.getString("geschlecht"),
                        rset.getInt("gehalt"),
                        rset.getString("benutzername"),
                        rset.getString("passwort")));
                mitarbeiterTable.setItems(MitarbeiterList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loadDate(){
    
        con = MachineXDB.getConnection();
        refreshTable();
        
        aVornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        aNachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        aTcNrCol.setCellValueFactory(new PropertyValueFactory<>("tcNummer"));
        aGeburtstagCol.setCellValueFactory(new PropertyValueFactory<>("geburtstag"));
        aTelefonnummerCol.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        aBenutzernameCol.setCellValueFactory(new PropertyValueFactory<>("benutzername"));
        aPasswortCol.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        aGeschlechtCol.setCellValueFactory(new PropertyValueFactory<>("geschlecht"));
        aGehaltCol.setCellValueFactory(new PropertyValueFactory<>("gehalt"));
    }
    */
}
