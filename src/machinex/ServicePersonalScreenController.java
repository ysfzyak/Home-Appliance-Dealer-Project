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
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.scene.input.MouseEvent;
import static machinex.MachineXDB.connect;
import machinex.models.Servicebericht;

/**
 * FXML Controller class
 *
 * @author ysfzy
 */
public class ServicePersonalScreenController implements Initializable {

    @FXML
    private TableView<Servicebericht> serviceberichtTable;
    @FXML
    private TableColumn<Servicebericht, String> cServiceberichtNoCol;
    @FXML
    private TableColumn<Servicebericht, String> cProduktcodeCol;
    @FXML
    private TableColumn<Servicebericht, String> cTcnrKundeCol;
    @FXML
    private TextField c_txt_serviceberichtno;
    @FXML
    private TextField c_txt_produktcode;
    @FXML
    private TextField c_txt_tcnrkunde;
    
    ObservableList<Servicebericht> list1;
    
    int index = -1;
    Connection con1 = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    
    public void addServicebericht(){
        
        if(checkKunde() != true || checkProdukt() != true){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Hinzufügen nicht möglich!");
            alert.setContentText("Die TC-Nummer oder der Produktcode wurde möglicherweise falsch eingegeben oder eines der Felder ist leer!");
            alert.showAndWait();
            
        }else{
            
            con1 = MachineXDB.connect();
            String sql = "INSERT INTO servicebericht(serviceberichtno,produkt1,kunde1)values(?,?,?)";
        
            try{
                pst = con1.prepareStatement(sql);
                pst.setString(1, c_txt_serviceberichtno.getText());
                pst.setString(2, c_txt_produktcode.getText());
                pst.setString(3, c_txt_tcnrkunde.getText());
                
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Servicebericht wird hinzugefügt!");
                updateTable();
              
            }catch(HeadlessException | SQLException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Hinzufügen nicht möglich!");
                alert.setContentText("Bitte füllen Sie alle Felder aus");
                alert.showAndWait();
            }
        }
    }
    
    public boolean checkKunde(){
        Connection con = connect();
        String tcnr = c_txt_tcnrkunde.getText();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM kunde WHERE tcnummer='" + tcnr + "'");
            ResultSet rs1 = ps.executeQuery();
            if(rs1.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
    
    public boolean checkProdukt(){
        Connection con = connect();
        String prdktnr = c_txt_produktcode.getText();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM geraete WHERE produktcode='" + prdktnr + "'");
            ResultSet rs2 = ps.executeQuery();
            if(rs2.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
    
    public void updateTable(){
       
        cServiceberichtNoCol.setCellValueFactory(new PropertyValueFactory<>("serviceberichtNo"));
        cProduktcodeCol.setCellValueFactory(new PropertyValueFactory<>("produktCode1"));
        cTcnrKundeCol.setCellValueFactory(new PropertyValueFactory<>("tcNrKunde1"));
        
        list1 = MachineXDB.getDataServicebericht();
        serviceberichtTable.setItems(list1);
    }
    
    public void getSelected(MouseEvent event){
        
        index = serviceberichtTable.getSelectionModel().getSelectedIndex();
        if(index <= -1) return;
        
        c_txt_serviceberichtno.setText(cServiceberichtNoCol.getCellData(index).toString());
        c_txt_produktcode.setText(cProduktcodeCol.getCellData(index).toString());
        c_txt_tcnrkunde.setText(cTcnrKundeCol.getCellData(index).toString());
        
    }
    
    public void deleteServicebericht(){
        con1 = MachineXDB.connect();
        String sql = "DELETE FROM servicebericht WHERE serviceberichtno=?";
        
        try{
            pst = con1.prepareStatement(sql);
            pst.setString(1, c_txt_serviceberichtno.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Servicebericht wird gelöscht");
            updateTable();
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTable();
    }    
    
}
