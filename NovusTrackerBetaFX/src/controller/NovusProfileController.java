package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApp;
import application.Novus;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;


public class NovusProfileController extends AnchorPane implements Initializable  {
	
	@FXML	private TextField fullNameLabel;
	@FXML	private TextField novusGroupLabel;
	@FXML	private TextField contactNumberLabel;
	@FXML	private TextField emailLabel;

	 public NovusProfileController()
	 {
		// setLabels();
		// fullNameLabel.setText("FDF");
		 //System.out.println(fullNameLabel.getText());
	
	 }
	 
	 @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
		 
		}
	 
	 
		public void setPerson(Novus novus) {
		    if (novus != null) {
		    	System.out.println("novus Not Null");
		        // Fill the labels with info from the person object.
		    	 fullNameLabel.setText(novus.getFirstName());
				 novusGroupLabel.setText(novus.getGroup());
				 contactNumberLabel.setText("" +novus.getContactNumber());
				 emailLabel.setText(novus.getEmail());

		        // TODO: We need a way to convert the birthday into a String! 
		        // birthdayLabel.setText(...);
		    } else {
		        // Person is null, remove all the text.
		    	// Fill the labels with info from the person object.
		    	 fullNameLabel.setText("");
				// novusGroupLabel.setText("");
				// contactNumberLabel.setText("");
				 //emailLabel.setText("");
		    }
		}
	 
	 public void setLabels()
	 {
		 fullNameLabel.setText("dffsd");
		/* novusGroupLabel.setText(novusGroup);
		 contactNumberLabel.setText(contactNumber);
		 emailLabel.setText(email);
		 
		 fullNameLabel.setText("Hohn Jacobs");
		 novusGroupLabel.setText("Hohn Jacobs");
		 contactNumberLabel.setText("Hohn Jacobs");
		 emailLabel.setText("Hohn Jacobs");
		 */
	 }
	
	 




}
