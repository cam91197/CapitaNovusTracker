package application;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.HomeController;
import controller.LoginController;
import controller.MainController;
import controller.NovusController;
import controller.NovusProfileController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static Stage stage;
	Scene novusTableScene;
	private final double MINIMUM_WINDOW_WIDTH = 800.0;
    private final double MINIMUM_WINDOW_HEIGHT = 600.0;
	
	public static void main(String[] args) {
		 Application.launch(MainApp.class, (java.lang.String[])null);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		  try {
	            stage = primaryStage;
	            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
	            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
	            stage.setResizable(false);
	            stage.setTitle("Capita Novus Tracker");
	            gotoLogin();
	          //  gotoTabs();
	         //   gotoProfile();
	            
	          
	            
	         	
	            primaryStage.show();
	            HomeController home = (HomeController) initScene("/view/Home.fxml");
	            home.setApp(this);
	        } catch (Exception ex) {
	            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
	        }		
	}
	
	
	  public void gotoLogin() {
	        try {
	            LoginController login = (LoginController) replaceSceneContent("/view/Login.fxml");
	          
	            login.setApp(this);
	        } catch (Exception ex) {
	            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	
	 public void gotoTabs() {
	        try {
	           
				MainController novusTable = (MainController) replaceSceneContent("/view/Main.fxml");
	           // novusTable.setApp(this);
	        } catch (Exception ex) {
	            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
	           
	        }
	    }
	 
	 public void gotoProfile() {
	        try {
	           
				NovusProfileController novusProfile = (NovusProfileController) replaceSceneContent("/view/NovusProfile.fxml");
	           // novusProfile.setApp(this);
	        } catch (Exception ex) {
	            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);	           
	        }
	    }
	 
	 private Node replaceSceneContent(String fxml) throws Exception {
	        FXMLLoader loader = new FXMLLoader();
	        InputStream in = MainApp.class.getResourceAsStream(fxml);
	        loader.setBuilderFactory(new JavaFXBuilderFactory());
	        loader.setLocation(MainApp.class.getResource(fxml));
	        AnchorPane page;
	        try {
	            page = (AnchorPane) loader.load(in);
	        } finally {
	            in.close();
	        }
	        
	        // Store the stage width and height in case the user has resized the window
	        double stageWidth = stage.getWidth();
	        if (!Double.isNaN(stageWidth)) {
	            stageWidth -= (stage.getWidth() - stage.getScene().getWidth());
	        }
	        
	        double stageHeight = stage.getHeight();
	        if (!Double.isNaN(stageHeight)) {
	            stageHeight -= (stage.getHeight() - stage.getScene().getHeight());
	        }
	        
	        Scene scene = new Scene(page);
	        if (!Double.isNaN(stageWidth)) {
	            page.setPrefWidth(stageWidth);
	        }
	        if (!Double.isNaN(stageHeight)) {
	            page.setPrefHeight(stageHeight);
	        }
	        
	        stage.setScene(scene);
	        stage.sizeToScene();
	        return (Node) loader.getController();
	    }
	 
	 private Node initScene(String fxml) throws Exception {
	        FXMLLoader loader = new FXMLLoader();
	        InputStream in = MainApp.class.getResourceAsStream(fxml);
	        loader.setBuilderFactory(new JavaFXBuilderFactory());
	        loader.setLocation(MainApp.class.getResource(fxml));
	        AnchorPane page;
	        try {
	            page = (AnchorPane) loader.load(in);
	        } finally {
	            in.close();
	        }
	        
	      
	        return (Node) loader.getController();
	    }
	 
	
	

	
	 
	
	


	
}
