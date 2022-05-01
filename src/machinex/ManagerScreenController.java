package machinex;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import machinex.models.Aussendienstmitarbeiter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ysfzyak
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
            updateTable();
        }catch(HeadlessException | SQLException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
        }
        
    }
    @FXML
    void getSelected(MouseEvent event){
        index = mitarbeiterTable.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        txt_vorname.setText(aVornameCol.getCellData(index).toString());
        txt_nachname.setText(aNachnameCol.getCellData(index).toString());
        txt_tcnummer.setText(aTcNrCol.getCellData(index).toString());
        txt_geburtstag.setText(aGeburtstagCol.getCellData(index).toString());
        txt_telefonnummer.setText(aTelefonnummerCol.getCellData(index).toString());
        txt_benutzername.setText(aBenutzernameCol.getCellData(index).toString());
        txt_passwort.setText(aPasswortCol.getCellData(index).toString());
        txt_geschlecht.setText(aGeschlectCol.getCellData(index).toString());
        txt_gehalt.setText(aGehaltCol.getCellData(index).toString());
        
    }
    
    private boolean checkEmpty(){
        
        if(txt_vorname.getText().isEmpty() |
                txt_nachname.getText().isEmpty() |
                txt_tcnummer.getText().isEmpty() |
                txt_geburtstag.getText().isEmpty() |
                txt_telefonnummer.getText().isEmpty() |
                txt_benutzername.getText().isEmpty() |
                txt_passwort.getText().isEmpty() |
                txt_geschlecht.getText().isEmpty() |
                txt_gehalt.getText().isEmpty()){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Aktualisieren nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
            
            return false;
        }
        return true;
    }
    
    public void deleteMitarbeiter(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM aussendienstmitarbeiter WHERE tcnummer=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_tcnummer.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Mitarbeiter wird gelöscht");
            updateTable();
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }
    
    public void updateTable(){
       
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
    
    public void editData(){
        if(checkEmpty()){
        try{
            con1 = MachineXDB.connect();
            String value1 = txt_vorname.getText();
            String value2 = txt_nachname.getText();
            String value3 = txt_tcnummer.getText();
            String value4 = txt_geburtstag.getText();
            String value5 = txt_telefonnummer.getText();
            String value6 = txt_benutzername.getText();
            String value7 = txt_passwort.getText();
            String value8 = txt_geschlecht.getText();
            String value9 = txt_gehalt.getText();
            
            String sql = "UPDATE aussendienstmitarbeiter SET vorname='"+value1+"', "
                    + "nachname='"+value2+"', "
                    + "tcnummer='"+value3+"', "
                    + "geburtstag='"+value4+"', "
                    + "telefonnummer='"+value5+"', "
                    + "benutzername='"+value6+"', "
                    + "passwort='"+value7+"', "
                    + "geschlecht='"+value8+"', "
                    + "gehalt='"+value9+"' "
                    + "WHERE tcnummer='"+value3+"' ";
            
            pst = con1.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Mitarbeiter wird aktualisiert");
            updateTable();
            
            
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTable();
    }
}
