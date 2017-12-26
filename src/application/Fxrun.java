package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


	public class Fxrun {
		
	public Scene createScene() throws Exception {

			Parent root = FXMLLoader.load(getClass().getResource("Test_1.fxml"));
			Scene scene = new Scene(root,600,300);			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			return scene;
	}
	
	public  void initFX(JFXPanel fxPanel) {
		Scene scene;
		try {
			scene = this.createScene();
			fxPanel.setScene(scene);
			fxPanel.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
//	public static void main(String[] args) {
//		launch(args);
//	}
}