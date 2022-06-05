/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author ysfzy
 */
public class MitarbeiterScreenController implements Initializable {

    @FXML
    private TableView<Kunde> kundeTable2;
    @FXML
    private TableColumn<Kunde, String> bVornameCol;
    @FXML
    private TableColumn<Kunde, String> bNachnameCol;
    @FXML
    private TableColumn<Kunde, String> bTcNrCol;
    @FXML
    private TableColumn<Kunde, Date> bGeburtstagCol;
    @FXML
    private TableColumn<Kunde, String> bTelefonnummerCol;
    @FXML
    private TableColumn<Kunde, String> bAdresseCol;
    @FXML
    private TextField b_txt_vorname;
    @FXML
    private TextField b_txt_nachname;
    @FXML
    private TextField b_txt_tcnummer;
    @FXML
    private TextField b_txt_geburtstag;
    @FXML
    private TextField b_txt_telefonnummer;
    @FXML
    private TextField b_txt_adresse;
    @FXML
    private TextField b_txt_modellname;
    @FXML
    private TextField b_txt_preis;
    @FXML
    private TextField b_txt_farbe;
    @FXML
    private TextField b_txt_produktcode;
    @FXML
    private TextField b_txt_garantie;
    @FXML
    private TableView<Geraete> produktTable2;
    @FXML
    private TableColumn<Geraete, String> bModellnameCol;
    @FXML
    private TableColumn<Geraete, Integer> bPreisCol;
    @FXML
    private TableColumn<Geraete, String> bFarbeCol;
    @FXML
    private TableColumn<Geraete, String> bProduktcodeCol;
    @FXML
    private TableColumn<Geraete, Integer> bGarantieCol;
    @FXML
    private TableView<Rechnung> rechnungTable2;
    @FXML
    private TableColumn<Rechnung, String> bRechnungnoCol;
    @FXML
    private TableColumn<Rechnung, String> bTcnrKundeCol;
    @FXML
    private TableColumn<Rechnung, String> bProduktcodeCol1;
    @FXML
    private TextField b_txt_rechnungno;
    @FXML
    private TextField b_txt_produktcode1;
    @FXML
    private TextField b_txt_tcnrkunde;
    
    ObservableList<Kunde> list1;
    ObservableList<Geraete> list2;
    ObservableList<Rechnung> list3;
    
    int index = -1;
    Connection con1 = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void addKunde(){
        con1 = MachineXDB.connect();
        String sql = "INSERT INTO kunde(vorname,nachname,tcnummer,geburtstag,telefonnummer,adresse)values(?,?,?,?,?,?)";
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, b_txt_vorname.getText());
            pst.setString(2, b_txt_nachname.getText());
            pst.setString(3, b_txt_tcnummer.getText());
            pst.setString(4, b_txt_geburtstag.getText());
            pst.setString(5, b_txt_telefonnummer.getText());
            pst.setString(6, b_txt_adresse.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Kunde wird hinzugefügt!");
            updateTable1();
            
        }catch(HeadlessException | SQLException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
        }
    }
    
    public void updateTable1(){
       
        bVornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        bNachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        bTcNrCol.setCellValueFactory(new PropertyValueFactory<>("tcNummer"));
        bGeburtstagCol.setCellValueFactory(new PropertyValueFactory<>("geburtstag"));
        bTelefonnummerCol.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        bAdresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
        list1 = MachineXDB.getDataKunde();
        kundeTable2.setItems(list1);
    }
    
    public void editData1(){
        if(checkEmpty1()){
        try{
            con1 = MachineXDB.connect();
            String value1 = b_txt_vorname.getText();
            String value2 = b_txt_nachname.getText();
            String value3 = b_txt_tcnummer.getText();
            String value4 = b_txt_geburtstag.getText();
            String value5 = b_txt_telefonnummer.getText();
            String value6 = b_txt_adresse.getText();
            
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
                updateTable1();
                
                
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }}
    }
    
    private boolean checkEmpty1(){
        
        if(b_txt_vorname.getText().isEmpty() |
                b_txt_nachname.getText().isEmpty() |
                b_txt_tcnummer.getText().isEmpty() |
                b_txt_geburtstag.getText().isEmpty() |
                b_txt_telefonnummer.getText().isEmpty() |
                b_txt_adresse.getText().isEmpty()){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Aktualisieren nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
            
            return false;
        }
        return true;
    }
    
    public void getSelected1(MouseEvent event){
        index = kundeTable2.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        b_txt_vorname.setText(bVornameCol.getCellData(index).toString());
        b_txt_nachname.setText(bNachnameCol.getCellData(index).toString());
        b_txt_tcnummer.setText(bTcNrCol.getCellData(index).toString());
        b_txt_geburtstag.setText(bGeburtstagCol.getCellData(index).toString());
        b_txt_telefonnummer.setText(bTelefonnummerCol.getCellData(index).toString());
        b_txt_adresse.setText(bAdresseCol.getCellData(index).toString());
        
    }
    
    public void deleteKunde(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM kunde WHERE tcnummer=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, b_txt_tcnummer.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Kunde wird gelöscht");
            updateTable1();
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }
    
    public void addGeraete(){
        con1 = MachineXDB.connect();
        String sql = "INSERT INTO geraete(modellname,preis,farbe,produktcode,garantie)values(?,?,?,?,?)";
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, b_txt_modellname.getText());
            pst.setString(2, b_txt_preis.getText());
            pst.setString(3, b_txt_farbe.getText());
            pst.setString(4, b_txt_produktcode.getText());
            pst.setString(5, b_txt_garantie.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Produkt wird hinzugefügt!");
            updateTable2();
            
        }catch(HeadlessException | SQLException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
        }
    }
    
    public void updateTable2(){
       
        bModellnameCol.setCellValueFactory(new PropertyValueFactory<>("modellName"));
        bPreisCol.setCellValueFactory(new PropertyValueFactory<>("preis"));
        bFarbeCol.setCellValueFactory(new PropertyValueFactory<>("farbe"));
        bProduktcodeCol.setCellValueFactory(new PropertyValueFactory<>("produktCode"));
        bGarantieCol.setCellValueFactory(new PropertyValueFactory<>("garantie"));
        
        list2 = MachineXDB.getDataGeraete();
        produktTable2.setItems(list2);
    }
    
    public void getSelected2(MouseEvent event){
        index = produktTable2.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        b_txt_modellname.setText(bModellnameCol.getCellData(index).toString());
        b_txt_preis.setText(bPreisCol.getCellData(index).toString());
        b_txt_farbe.setText(bFarbeCol.getCellData(index).toString());
        b_txt_produktcode.setText(bProduktcodeCol.getCellData(index).toString());
        b_txt_garantie.setText(bGarantieCol.getCellData(index).toString());
        
    }
    
    public void editData2(){
        if(checkEmpty2()){
        try{
            con1 = MachineXDB.connect();
            String value1 = b_txt_modellname.getText();
            String value2 = b_txt_preis.getText();
            String value3 = b_txt_farbe.getText();
            String value4 = b_txt_produktcode.getText();
            String value5 = b_txt_garantie.getText();
            
            String sql = "UPDATE geraete SET modellname='"+value1+"', "
                    + "preis='"+value2+"', "
                    + "farbe='"+value3+"', "
                    + "produktcode='"+value4+"', "
                    + "garantie='"+value5+"' "
                    + "WHERE produktcode='"+value4+"' ";
            
                pst = con1.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Produkt wird aktualisiert");
                updateTable2();
                
                
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }}
    }
    
    private boolean checkEmpty2(){
        
        if(b_txt_modellname.getText().isEmpty() |
                b_txt_preis.getText().isEmpty() |
                b_txt_farbe.getText().isEmpty() |
                b_txt_produktcode.getText().isEmpty() |
                b_txt_preis.getText().isEmpty()){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Aktualisieren nicht möglich!");
            alert.setContentText("Bitte füllen Sie alle Felder aus");
            alert.showAndWait();
            
            return false;
        }
        return true;
    }
    
    public void deleteGeraete(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM geraete WHERE produktcode=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, b_txt_produktcode.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produkt wird gelöscht");
            updateTable2();
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }
    
    public void addRechnung(){
        
        if(checkKunde() != true || checkProdukt() != true){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Produktcode oder TC Nummer ist falsch!");
            alert.showAndWait();
            
        }else{
            
            con1 = MachineXDB.connect();
            String sql = "INSERT INTO rechnung(rechnungno,produkt,kunde)values(?,?,?)";
        
            try{
                pst = con1.prepareStatement(sql);
                pst.setString(1, b_txt_rechnungno.getText());
                pst.setString(2, b_txt_produktcode1.getText());
                pst.setString(3, b_txt_tcnrkunde.getText());
                
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Rechnung wird hinzugefügt!");
                updateTable3();
              
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
        String tcnr = b_txt_tcnrkunde.getText();
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
        String prdktnr = b_txt_produktcode1.getText();
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
    
    public void updateTable3(){
       
        bRechnungnoCol.setCellValueFactory(new PropertyValueFactory<>("rechnungNo"));
        bProduktcodeCol1.setCellValueFactory(new PropertyValueFactory<>("produktCode"));
        bTcnrKundeCol.setCellValueFactory(new PropertyValueFactory<>("tcNrKunde"));
        
        list3 = MachineXDB.getDataRechnung();
        rechnungTable2.setItems(list3);
    }
    
    public void getSelected3(MouseEvent event){
        
        index = rechnungTable2.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        b_txt_rechnungno.setText(bRechnungnoCol.getCellData(index).toString());
        b_txt_produktcode1.setText(bProduktcodeCol1.getCellData(index).toString());
        b_txt_tcnrkunde.setText(bTcnrKundeCol.getCellData(index).toString());
        
    }
    
    public void deleteRechnung(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM rechnung WHERE rechnungno=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, b_txt_rechnungno.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Rechnung wird gelöscht");
            updateTable3();
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTable1();
        updateTable2();
        updateTable3();
        
    }    
    
}
