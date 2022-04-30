package machinex;

import com.sun.javafx.logging.PlatformLogger.Level;
import java.lang.System.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
 
/**
 *
 * @author ysfzyak
 */

public class Main extends Application{

    /*@Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
     
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MachineX");
        primaryStage.show();
       
    }*/
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
            Scene scene = new Scene(parent);
            //primaryStage.setTitle("Manager-Optionen");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) throws Exception {
        launch(args);
        MachineXDB x = new MachineXDB();
        x.getConnection();
    }    
}
