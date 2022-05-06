/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinex;

import java.awt.HeadlessException;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author ysfzyak
 */

public class LoginController implements Initializable {

    @FXML
    private TextField usernamefield;
    @FXML
    private Button buttonlogin;
    @FXML
    private PasswordField passwortfield;
    

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    Connection con = null;
    PreparedStatement pst1 = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst3 = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    
    
    public void switchToManagerScene(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
    public void switchToMitarbeiterScene(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("MitarbeiterScreen.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
    public void login(ActionEvent event){
        
        String username = usernamefield.getText();
        String passwort = passwortfield.getText();
    
        if(username.equals("") && passwort.equals("")){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Login nicht möglich!");
            alert.setContentText("Bitte geben Sie einen Benutzername und ein Passwort");
            alert.showAndWait();
            
        }else{
            try{
                con = MachineXDB.connect();
                pst1 = con.prepareStatement("SELECT * FROM haendlermanager WHERE benutzername=? AND passwort=? ");
                pst2 = con.prepareStatement("SELECT * FROM aussendienstmitarbeiter WHERE benutzername=? AND passwort=? ");
                pst3 = con.prepareStatement("SELECT * FROM servicepersonal WHERE benutzername=? AND passwort=? ");
                
                pst1.setString(1, username);
                pst1.setString(2, passwort);
                
                pst2.setString(1, username);
                pst2.setString(2, passwort);
                
                pst3.setString(1, username);
                pst3.setString(2, passwort);
                
                rs1 = pst1.executeQuery();
                rs2 = pst2.executeQuery();
                rs3 = pst3.executeQuery();
                
                if(rs1.next()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login");
                    alert.setHeaderText("Als Manager eingeloggt.");
                    alert.setContentText("Willkommen Sie " + usernamefield.getText() + "!");
                    alert.showAndWait();
                    switchToManagerScene(event);
                }else if(rs2.next()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login");
                    alert.setHeaderText("Als Mitarbeiter eingeloggt.");
                    alert.setContentText("Willkommen Sie " + usernamefield.getText() + "!");
                    alert.showAndWait();
                    switchToMitarbeiterScene(event);
                }else if(rs3.next()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login");
                    alert.setHeaderText("Als Servicepersonal eingeloggt.");
                    alert.setContentText("Willkommen Sie " + usernamefield.getText() + "!");
                    alert.showAndWait();
                    switchToManagerScene(event);
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Login nicht möglich!");
                    alert.setContentText("Login ist fehlgeschlagen");
                    alert.showAndWait();
                
                    usernamefield.setText("");
                    passwortfield.setText("");
                    usernamefield.requestFocus();
                }
                
            }catch(HeadlessException | IOException | SQLException e){
               System.out.println(e);
            }
        }
    }
}
