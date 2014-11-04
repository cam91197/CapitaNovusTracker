package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;







import org.controlsfx.dialog.Dialogs;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


@SuppressWarnings("deprecation")
public class LoginController extends AnchorPane implements Initializable  {
	
	@FXML
	private TextField userNameField;
	@FXML
	private PasswordField passwordField;
	
	private String userName = "admin";
	private String password = "admin";
	
	private MainApp application;
	
	private String message = "Please enter your email";
	
	
	  public void setApp(MainApp application){
	        this.application = application;
	    }
	
	
	public void login(ActionEvent event)
	{
		 System.out.println("HFKLDL");
		   if(userNameField.getText().equals(userName)&& passwordField.getText().equals(password))
					{
						 application.gotoTabs();												
					}
					else
					{
						
						Dialogs.create()
				        .title("Incorrect Username/Password")
				        .masthead("Please enter a correct username and password")
				       // .message("I have a great message for you!")
				        .showInformation();
					} 
		
	}
	
	public void forgotPassword()
	{
	
		Optional<String> response = Dialogs.create()		       
		        .title("Forgot Password")		        
		        .message(message)		        
		        .showTextInput("@Capita.com");		

		// One way to get the response value.
		if (response.isPresent()) {
		    System.out.println("Your name: " + response.get());
		    message = "Hello";
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	  

}
