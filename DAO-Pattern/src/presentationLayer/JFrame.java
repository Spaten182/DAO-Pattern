/**
 * setting up the application main class and defines the stage and scene.
 */
package presentationLayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Kevin
 */
public class JFrame extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("JFrame.fxml"));
    
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Trainerverwaltung");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
