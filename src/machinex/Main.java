package machinex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
 
/**
 *
 * @author ysfzyak
 */

public class Main extends Application{
   
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
            //Parent parent = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
            //Parent parent = FXMLLoader.load(getClass().getResource("MitarbeiterScreen.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setTitle("MachineX");
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
