package machinex;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import machinex.models.Aussendienstmitarbeiter;
import machinex.models.ServicePersonal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.scene.input.MouseEvent;
import static machinex.MachineXDB.connect;
import machinex.models.Geraete;
import machinex.models.Kunde;
import machinex.models.Rechnung;

/**
 * FXML Controller class
 *
 * @author ysfzyak
 */

public class ManagerScreenController implements Initializable {
    @FXML
    private TableView<Aussendienstmitarbeiter> mitarbeiterTable;
    @FXML
    private TableView<ServicePersonal> personalTable;
    @FXML
    private TableView<Kunde> kundeTable;
    @FXML
    private TableView<Geraete> produktTable;
    @FXML
    private TableView<Rechnung> rechnungTable;
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
    private TableColumn<ServicePersonal,String> aVornameCol1;
    @FXML
    private TableColumn<ServicePersonal,String> aNachnameCol1;
    @FXML
    private TableColumn<ServicePersonal,String> aTcNrCol1;
    @FXML
    private TableColumn<ServicePersonal,Date> aGeburtstagCol1;
    @FXML
    private TableColumn<ServicePersonal,String> aTelefonnummerCol1;
    @FXML
    private TableColumn<ServicePersonal,String> aBenutzernameCol1;
    @FXML
    private TableColumn<ServicePersonal,String> aPasswortCol1;
    @FXML
    private TableColumn<ServicePersonal,String> aGeschlectCol1;
    @FXML
    private TableColumn<ServicePersonal,Integer> aGehaltCol1;
    @FXML
    private TableColumn<Kunde, String> aVornameCol2;
    @FXML
    private TableColumn<Kunde, String> aNachnameCol2;
    @FXML
    private TableColumn<Kunde, String> aTcNrCol2;
    @FXML
    private TableColumn<Kunde, Date> aGeburtstagCol2;
    @FXML
    private TableColumn<Kunde, String> aTelefonnummerCol2;
    @FXML
    private TableColumn<Kunde, String> aAdresseCol;
    @FXML
    private TableColumn<Geraete, String> aModellnameCol;
    @FXML
    private TableColumn<Geraete, Integer> aPreisCol;
    @FXML
    private TableColumn<Geraete, String> aFarbeCol;
    @FXML
    private TableColumn<Geraete, String> aProduktcodeCol;
    @FXML
    private TableColumn<Geraete, Integer> aGarantieCol;
    @FXML
    private TableColumn<Rechnung, String> aRechnungNoCol;
    @FXML
    private TableColumn<Rechnung, String> aProduktCol;
    @FXML
    private TableColumn<Rechnung, String> aKundeCol;
    @FXML
    private Button addMitarbeiterBtn;
    @FXML
    private Button mitarbeiterRefreshBtn;
    @FXML
    private Button mitarbeiterlöschenBtn;
    @FXML 
    private TextField txt_vorname;
    @FXML
    private Tooltip ttvorname;
    @FXML
    private TextField txt_nachname;
    @FXML
    private Tooltip ttnachname;
    @FXML
    private TextField txt_tcnummer;
    @FXML
    private Tooltip tttcnummer;
    @FXML
    private TextField txt_geburtstag;
    @FXML
    private Tooltip ttgeburtstag;
    @FXML
    private TextField txt_telefonnummer;
    @FXML
    private Tooltip tttelefonnummer;
    @FXML
    private TextField txt_benutzername;
    @FXML
    private Tooltip ttbenutzername;
    @FXML
    private TextField txt_passwort;
    @FXML
    private Tooltip ttpasswort;
    @FXML
    private TextField txt_geschlecht;
    @FXML
    private Tooltip ttgeschlecht;
    @FXML
    private TextField txt_gehalt;
    @FXML
    private Tooltip ttgehalt;
    @FXML
    private TextField txt_vorname1;
    @FXML
    private Tooltip ttvorname1;
    @FXML
    private TextField txt_nachname1;
    @FXML
    private Tooltip ttnachname1;
    @FXML
    private TextField txt_tcnummer1;
    @FXML
    private Tooltip tttcnummer1;
    @FXML
    private TextField txt_geburtstag1;
    @FXML
    private Tooltip ttgeburtstag1;
    @FXML
    private TextField txt_telefonnummer1;
    @FXML
    private Tooltip tttelefonnummer1;
    @FXML
    private TextField txt_benutzername1;
    @FXML
    private Tooltip ttbenutzername1;
    @FXML
    private TextField txt_passwort1;
    @FXML
    private Tooltip ttpasswort1;
    @FXML
    private TextField txt_geschlecht1;
    @FXML
    private Tooltip ttgeschlecht1;
    @FXML
    private TextField txt_gehalt1;
    @FXML
    private Tooltip ttgehalt1;
    @FXML
    private TextField txt_vorname2;
    @FXML
    private Tooltip ttvorname2;
    @FXML
    private TextField txt_nachname2;
    @FXML
    private Tooltip ttnachname2;
    @FXML
    private TextField txt_tcnummer2;
    @FXML
    private Tooltip tttcnummer2;
    @FXML
    private TextField txt_geburtstag2;
    @FXML
    private Tooltip ttgeburtstag2;
    @FXML
    private TextField txt_telefonnummer2;
    @FXML
    private Tooltip tttelefonnummer2;
    @FXML
    private TextField txt_adresse;
    @FXML
    private Tooltip ttadresse;
    @FXML
    private TextField txt_modellname;
    @FXML
    private Tooltip ttmodellname;
    @FXML
    private TextField txt_preis;
    @FXML
    private Tooltip ttpreis;
    @FXML
    private TextField txt_farbe;
    @FXML
    private Tooltip ttfarbe;
    @FXML
    private TextField txt_produktcode;
    @FXML
    private Tooltip ttproduktcode;
    @FXML
    private TextField txt_garantie;
    @FXML
    private Tooltip ttgarantie;
    @FXML
    private TextField txt_rechnungno;
    @FXML
    private Tooltip ttrechnungno;
    @FXML
    private TextField txt_produktcode1;
    @FXML
    private Tooltip ttproduktcode1;
    @FXML
    private TextField txt_tcnrkunde;
    @FXML
    private Tooltip tttcnrkunde;

    ObservableList<Aussendienstmitarbeiter> list1;
    ObservableList<ServicePersonal> list2;
    ObservableList<Kunde> list3;
    ObservableList<Geraete> list4;
    ObservableList<Rechnung> list5;
    
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
    
    public void addServicepersonal(){
        con1 = MachineXDB.connect();
        String sql = "INSERT INTO servicepersonal(vorname,nachname,tcnummer,geburtstag,telefonnummer,benutzername,passwort,geschlecht,gehalt)values(?,?,?,?,?,?,?,?,?)";
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_vorname1.getText());
            pst.setString(2, txt_nachname1.getText());
            pst.setString(3, txt_tcnummer1.getText());
            pst.setString(4, txt_geburtstag1.getText());
            pst.setString(5, txt_telefonnummer1.getText());
            pst.setString(6, txt_benutzername1.getText());
            pst.setString(7, txt_passwort1.getText());
            pst.setString(8, txt_geschlecht1.getText());
            pst.setString(9, txt_gehalt1.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Servicepersonal wird hinzugefügt!");
            updateTable2();
            
        }catch(HeadlessException | SQLException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
        }
    }
    
    public void addKunde(){
        con1 = MachineXDB.connect();
        String sql = "INSERT INTO kunde(vorname,nachname,tcnummer,geburtstag,telefonnummer,adresse)values(?,?,?,?,?,?)";
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_vorname2.getText());
            pst.setString(2, txt_nachname2.getText());
            pst.setString(3, txt_tcnummer2.getText());
            pst.setString(4, txt_geburtstag2.getText());
            pst.setString(5, txt_telefonnummer2.getText());
            pst.setString(6, txt_adresse.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Kunde wird hinzugefügt!");
            updateTable3();
            
        }catch(HeadlessException | SQLException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
        }
    }
    
    public void addGeraete(){
        con1 = MachineXDB.connect();
        String sql = "INSERT INTO geraete(modellname,preis,farbe,produktcode,garantie)values(?,?,?,?,?)";
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_modellname.getText());
            pst.setString(2, txt_preis.getText());
            pst.setString(3, txt_farbe.getText());
            pst.setString(4, txt_produktcode.getText());
            pst.setString(5, txt_garantie.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Produkt wird hinzugefügt!");
            updateTable4();
            
        }catch(HeadlessException | SQLException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
        }
    }
    
    public void addRechnung(){
        if(checkKunde() == true && checkProdukt() == true){
            con1 = MachineXDB.connect();
            String sql = "INSERT INTO rechnung(rechnungno,produkt,kunde)values(?,?,?)";
            
            try{
                pst = con1.prepareStatement(sql);
                pst.setString(1, txt_rechnungno.getText());
                pst.setString(2, txt_produktcode1.getText());
                pst.setString(3, txt_tcnrkunde.getText());
                
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Rechnung wird hinzugefügt!");
                updateTable5();
            
        }catch(HeadlessException | SQLException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
        }
        }
    }
    
    public boolean checkKunde(){
        Connection con = connect();
        String tcnr = txt_tcnrkunde.getText();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM kunde WHERE tcnummer='" + tcnr + "'");
            ResultSet rs5 = ps.executeQuery();
            if(rs5.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
    
    public boolean checkProdukt(){
        Connection con = connect();
        String prdktnr = txt_produktcode1.getText();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM geraete WHERE produktcode='" + prdktnr + "'");
            ResultSet rs6 = ps.executeQuery();
            if(rs6.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
     
    public void getSelected1(MouseEvent event){
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

    public void getSelected2(MouseEvent event){
        index = personalTable.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        txt_vorname1.setText(aVornameCol1.getCellData(index).toString());
        txt_nachname1.setText(aNachnameCol1.getCellData(index).toString());
        txt_tcnummer1.setText(aTcNrCol1.getCellData(index).toString());
        txt_geburtstag1.setText(aGeburtstagCol1.getCellData(index).toString());
        txt_telefonnummer1.setText(aTelefonnummerCol1.getCellData(index).toString());
        txt_benutzername1.setText(aBenutzernameCol1.getCellData(index).toString());
        txt_passwort1.setText(aPasswortCol1.getCellData(index).toString());
        txt_geschlecht1.setText(aGeschlectCol1.getCellData(index).toString());
        txt_gehalt1.setText(aGehaltCol1.getCellData(index).toString());
        
    }
    
    public void getSelected3(MouseEvent event){
        index = kundeTable.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        txt_vorname2.setText(aVornameCol2.getCellData(index).toString());
        txt_nachname2.setText(aNachnameCol2.getCellData(index).toString());
        txt_tcnummer2.setText(aTcNrCol2.getCellData(index).toString());
        txt_geburtstag2.setText(aGeburtstagCol2.getCellData(index).toString());
        txt_telefonnummer2.setText(aTelefonnummerCol2.getCellData(index).toString());
        txt_adresse.setText(aAdresseCol.getCellData(index).toString());
        
    }
    
    public void getSelected4(MouseEvent event){
        index = produktTable.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        txt_modellname.setText(aModellnameCol.getCellData(index).toString());
        txt_preis.setText(aPreisCol.getCellData(index).toString());
        txt_farbe.setText(aFarbeCol.getCellData(index).toString());
        txt_produktcode.setText(aProduktcodeCol.getCellData(index).toString());
        txt_garantie.setText(aGarantieCol.getCellData(index).toString());
        
    }
    
    public void getSelected5(MouseEvent event){
        
        index = rechnungTable.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        txt_rechnungno.setText(aRechnungNoCol.getCellData(index).toString());
        txt_produktcode1.setText(aProduktCol.getCellData(index).toString());
        txt_tcnrkunde.setText(aKundeCol.getCellData(index).toString());
        
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
    
    private boolean checkEmpty2(){
        
        if(txt_vorname1.getText().isEmpty() |
                txt_nachname1.getText().isEmpty() |
                txt_tcnummer1.getText().isEmpty() |
                txt_geburtstag1.getText().isEmpty() |
                txt_telefonnummer1.getText().isEmpty() |
                txt_benutzername1.getText().isEmpty() |
                txt_passwort1.getText().isEmpty() |
                txt_geschlecht1.getText().isEmpty() |
                txt_gehalt1.getText().isEmpty()){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Aktualisieren nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
            
            return false;
        }
        return true;
    }
    
    private boolean checkEmpty3(){
        
        if(txt_vorname2.getText().isEmpty() |
                txt_nachname2.getText().isEmpty() |
                txt_tcnummer2.getText().isEmpty() |
                txt_geburtstag2.getText().isEmpty() |
                txt_telefonnummer2.getText().isEmpty() |
                txt_adresse.getText().isEmpty()){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Aktualisieren nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
            
            return false;
        }
        return true;
    }
    
    private boolean checkEmpty4(){
        
        if(txt_modellname.getText().isEmpty() |
                txt_preis.getText().isEmpty() |
                txt_farbe.getText().isEmpty() |
                txt_produktcode.getText().isEmpty() |
                txt_preis.getText().isEmpty()){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Aktualisieren nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
            
            return false;
        }
        return true;
    }
    
    private boolean checkEmpty5(){
        
        if(txt_rechnungno.getText().isEmpty() |
                txt_produktcode1.getText().isEmpty() |
                txt_tcnrkunde.getText().isEmpty()){
            
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
    
    public void deleteServicepersonal(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM servicepersonal WHERE tcnummer=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_tcnummer1.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Servicepersonal wird gelöscht");
            updateTable2();
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }
    
    public void deleteKunde(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM kunde WHERE tcnummer=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_tcnummer2.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Kunde wird gelöscht");
            updateTable3();
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }
    
    public void deleteGeraete(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM geraete WHERE produktcode=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_produktcode.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produkt wird gelöscht");
            updateTable4();
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }
    
    public void deleteRechnung(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM rechnung WHERE rechnungno=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, txt_rechnungno.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Rechnung wird gelöscht");
            updateTable5();
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
        
        list1 = MachineXDB.getDataMitarbeiter();
        mitarbeiterTable.setItems(list1);
        
    }
    
    public void updateTable2(){
       
        aVornameCol1.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        aNachnameCol1.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        aTcNrCol1.setCellValueFactory(new PropertyValueFactory<>("tcNummer"));
        aGeburtstagCol1.setCellValueFactory(new PropertyValueFactory<>("geburtstag"));
        aTelefonnummerCol1.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        aBenutzernameCol1.setCellValueFactory(new PropertyValueFactory<>("benutzerName"));
        aPasswortCol1.setCellValueFactory(new PropertyValueFactory<>("passwort"));
        aGeschlectCol1.setCellValueFactory(new PropertyValueFactory<>("geschlecht"));
        aGehaltCol1.setCellValueFactory(new PropertyValueFactory<>("gehalt"));
        
        list2 = MachineXDB.getDataServicepersonal();
        personalTable.setItems(list2);
        
    }
    
    public void updateTable3(){
       
        aVornameCol2.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        aNachnameCol2.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        aTcNrCol2.setCellValueFactory(new PropertyValueFactory<>("tcNummer"));
        aGeburtstagCol2.setCellValueFactory(new PropertyValueFactory<>("geburtstag"));
        aTelefonnummerCol2.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        aAdresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
        list3 = MachineXDB.getDataKunde();
        kundeTable.setItems(list3);
    }
    
    public void updateTable4(){
       
        aModellnameCol.setCellValueFactory(new PropertyValueFactory<>("modellName"));
        aPreisCol.setCellValueFactory(new PropertyValueFactory<>("preis"));
        aFarbeCol.setCellValueFactory(new PropertyValueFactory<>("farbe"));
        aProduktcodeCol.setCellValueFactory(new PropertyValueFactory<>("produktCode"));
        aGarantieCol.setCellValueFactory(new PropertyValueFactory<>("garantie"));
        
        list4 = MachineXDB.getDataGeraete();
        produktTable.setItems(list4);
    }
    
    public void updateTable5(){
       
        aRechnungNoCol.setCellValueFactory(new PropertyValueFactory<>("rechnungNo"));
        aProduktCol.setCellValueFactory(new PropertyValueFactory<>("produktCode"));
        aKundeCol.setCellValueFactory(new PropertyValueFactory<>("tcNrKunde"));
        
        list5 = MachineXDB.getDataRechnung();
        rechnungTable.setItems(list5);
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
    
    public void editData2(){
        if(checkEmpty2()){
        try{
            con1 = MachineXDB.connect();
            String value1 = txt_vorname1.getText();
            String value2 = txt_nachname1.getText();
            String value3 = txt_tcnummer1.getText();
            String value4 = txt_geburtstag1.getText();
            String value5 = txt_telefonnummer1.getText();
            String value6 = txt_benutzername1.getText();
            String value7 = txt_passwort1.getText();
            String value8 = txt_geschlecht1.getText();
            String value9 = txt_gehalt1.getText();
            
            String sql = "UPDATE servicepersonal SET vorname='"+value1+"', "
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
                JOptionPane.showMessageDialog(null, "Servicepersonal wird aktualisiert");
                updateTable2();
                
                
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }}
    }
    
    public void editData3(){
        if(checkEmpty3()){
        try{
            con1 = MachineXDB.connect();
            String value1 = txt_vorname2.getText();
            String value2 = txt_nachname2.getText();
            String value3 = txt_tcnummer2.getText();
            String value4 = txt_geburtstag2.getText();
            String value5 = txt_telefonnummer2.getText();
            String value6 = txt_adresse.getText();
            
            String sql = "UPDATE kunde SET vorname='"+value1+"', "
                    + "nachname='"+value2+"', "
                    + "tcnummer='"+value3+"', "
                    + "geburtstag='"+value4+"', "
                    + "telefonnummer='"+value5+"', "
                    + "adresse='"+value6+"' "
                    + "WHERE tcnummer='"+value3+"' ";
            
                pst = con1.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Kunde wird aktualisiert");
                updateTable3();
                
                
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }}
    }
    
    public void editData4(){
        if(checkEmpty4()){
        try{
            con1 = MachineXDB.connect();
            String value1 = txt_modellname.getText();
            String value2 = txt_preis.getText();
            String value3 = txt_farbe.getText();
            String value4 = txt_produktcode.getText();
            String value5 = txt_garantie.getText();
            
            String sql = "UPDATE geraete SET modellname='"+value1+"', "
                    + "preis='"+value2+"', "
                    + "farbe='"+value3+"', "
                    + "produktcode='"+value4+"', "
                    + "garantie='"+value5+"' "
                    + "WHERE produktcode='"+value4+"' ";
            
                pst = con1.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Produkt wird aktualisiert");
                updateTable4();
                
                
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }}
    }
    
    public void tooltip(Tooltip t){
        txt_vorname.setTooltip(ttvorname);
        txt_nachname.setTooltip(ttnachname);
        txt_telefonnummer.setTooltip(tttelefonnummer);
        txt_tcnummer.setTooltip(tttcnummer);
        txt_geburtstag.setTooltip(ttgeburtstag);
        txt_benutzername.setTooltip(ttbenutzername);
        txt_passwort.setTooltip(ttpasswort);
        txt_gehalt.setTooltip(ttgehalt);
        txt_geschlecht.setTooltip(ttgeschlecht);
        
        txt_vorname1.setTooltip(ttvorname1);
        txt_nachname1.setTooltip(ttnachname1);
        txt_telefonnummer1.setTooltip(tttelefonnummer1);
        txt_tcnummer1.setTooltip(tttcnummer1);
        txt_geburtstag1.setTooltip(ttgeburtstag1);
        txt_benutzername1.setTooltip(ttbenutzername1);
        txt_passwort1.setTooltip(ttpasswort1);
        txt_gehalt1.setTooltip(ttgehalt1);
        txt_geschlecht1.setTooltip(ttgeschlecht1);
        
        txt_vorname2.setTooltip(ttvorname2);
        txt_nachname2.setTooltip(ttnachname2);
        txt_telefonnummer2.setTooltip(tttelefonnummer2);
        txt_tcnummer2.setTooltip(tttcnummer2);
        txt_geburtstag2.setTooltip(ttgeburtstag2);
        txt_adresse.setTooltip(ttadresse);
        
        txt_modellname.setTooltip(ttmodellname);
        txt_preis.setTooltip(ttpreis);
        txt_garantie.setTooltip(ttgarantie);
        txt_farbe.setTooltip(ttfarbe);
        txt_produktcode.setTooltip(ttproduktcode);
        
        txt_rechnungno.setTooltip(ttrechnungno);
        txt_produktcode1.setTooltip(ttproduktcode1);
        txt_tcnrkunde.setTooltip(tttcnrkunde);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTable();
        updateTable2();
        updateTable3();
        updateTable4();
        updateTable5();
        
        Tooltip t = new Tooltip();
        tooltip(t);
        
    }
}
