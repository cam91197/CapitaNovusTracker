package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Clients;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientController implements Initializable {

	@FXML    private TableView<Clients> clientTable;
    @FXML    private TableColumn<Clients, String> clientNameColumn;
    @FXML    private TableColumn<Clients, String> recruitingColumn;
    @FXML    private TableColumn<Clients, String> statusColumn;
	
    
    private ObservableList<Clients> clientData = FXCollections.observableArrayList();
    
    
    public ClientController()
    {
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    	clientData.add(new Clients("BAE", "Developers, Testers", false));
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("Client Controller INITIED");
		
		clientNameColumn.setCellValueFactory(cellData -> cellData.getValue().clientNameProperty());
		recruitingColumn.setCellValueFactory(cellData -> cellData.getValue().recruitingProperty());
		//statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		
		
		clientTable.setItems(clientData);
	}
	
	

}
