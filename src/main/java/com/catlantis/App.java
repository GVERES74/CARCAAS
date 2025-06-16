package com.catlantis;

import Utils.Tools;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.Screen;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
      
    
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("CatMain"), Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
        stage.setScene(scene);
	stage.setTitle("Catlantis - Animal Rescue, Care And Adoptation System");
	stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public class AppServices{
    public void getAppHostServices(String url){
        getHostServices().showDocument(url);
    }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
