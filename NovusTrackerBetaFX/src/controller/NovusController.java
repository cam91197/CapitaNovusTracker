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
import javafx.scene.Node;
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


public class NovusController extends AnchorPane implements Initializable  {
	
	@FXML    private TableView<Novus> novusTable;
    @FXML    private TableColumn<Novus, String> firstNameColumn;
    @FXML    private TableColumn<Novus, String> lastNameColumn;
    @FXML    private TableColumn<Novus, String> novusStreamColumn;
    @FXML    private TableColumn<Novus, String> novusGroupColumn;
    @FXML    private TableColumn<Novus, String> statusColumn;
    
    @FXML 	 private TextField searchField;
    @FXML 	 private Label novusPlacedText;
    @FXML 	 private Label totalNovusText;
    
    @FXML 	 private Label developerCountText;
    @FXML 	 private Label testersCountText;
    @FXML 	 private Label businessAnalystsCountText;
    @FXML 	 private Label novusBenchCountText;
    
    @FXML private Button add1Button;  
    
    @FXML private RadioButton showAllRButton; 
    @FXML private RadioButton developersRButton;
    @FXML private RadioButton testersRButton;
    @FXML private RadioButton businessAnalystsRButton;   
    
    @FXML private ToggleGroup novusSelection;
    
    private int totalNovusCount =0;
    private int developerCount =0;
    private int testerCount =0;
    private int businessAnalystsCount =0;
    private int benchCount =0;
    
    
    private NovusProfileController novusProfile;
       
    private MainApp application;
	 
    public void setApp(MainApp application){
        this.application = application;
        System.out.println("MainAPP set from NOVUS CONTROLLER");
    }
    
	 private ObservableList<Novus> novusData = FXCollections.observableArrayList();
		 
	 public NovusController()
	 {
		 novusProfile = new NovusProfileController();
		 
			loadData();
	        
	      System.out.println("this is 1st");
	   //   novusProfile.setLabels();
	 }
	 
	 @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		 System.out.println("this is 2nd");				
		    
		  novusTable.setEditable(true);	        
	        
	        Callback<TableColumn, TableCell> cellFactory =
	                new Callback<TableColumn, TableCell>() {
	                    public TableCell call(TableColumn p) {
	                        TableCell cell = new TableCell<Novus, String>() {
	                            @Override
	                            public void updateItem(String item, boolean empty) {
	                                super.updateItem(item, empty);
	                                setText(empty ? null : getString());
	                                setGraphic(null);
	                            }

	                            private String getString() {
	                                return getItem() == null ? "" : getItem().toString();
	                            }
	                        };

	                        cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	                            @Override
	                            public void handle(MouseEvent event) {
	                                if (event.getClickCount() > 1) {
	                                    System.out.println("double clicked!");
	                                    TableCell c = (TableCell) event.getSource();
	                                    System.out.println("Cell text: " + c.getText());                  
	                                   
	                                    openProfile();
	                                 
	                                }
	                            }
	                        });
	                        return cell;
	                        
	                    }
	                };
	                
	                setColumns(cellFactory);
		 
				//firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
	            
			//	lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		        novusStreamColumn.setCellValueFactory(cellData -> cellData.getValue().novusStreamProperty());
		        novusGroupColumn.setCellValueFactory(cellData -> cellData.getValue().groupProperty());
		        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		        //novusTable.setItems(novusData);
		        
		        
		        addSearchFilter();
		        addToggleFilter();
		        updateNovusCount();
		        
		        totalNovusText.setText("" +totalNovusCount);	 
			//showTesters();
		}
	 
	 @FXML
	 private void addOne(ActionEvent event)
	 {
		 novusData.add(new Novus("dsfsdfdf", "Kim", "Tester","Group 3"));
		 benchCount ++;
		 novusBenchCountText.setText("" + benchCount);
		 if(benchCount > 5)
		 {
			 novusBenchCountText.setTextFill(Color.RED);
			 novusBenchCountText.setUnderline(true);
		 }
		 updateNovusCount();		 
		 
	 }
	 
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	private void setColumns(Callback cellFactory)
	 {
		
		    firstNameColumn.setCellValueFactory(
		            new PropertyValueFactory<Novus, String>("firstName"));
            firstNameColumn.setCellFactory(cellFactory);
            firstNameColumn.setOnEditCommit(
		            new EventHandler<CellEditEvent<Novus, String>>() {
		                @Override
		                public void handle(CellEditEvent<Novus, String> t) {
		                    ((Novus) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setFirstName(t.getNewValue());
		                }
		             }
		        );
            
            lastNameColumn.setCellValueFactory(
		            new PropertyValueFactory<Novus, String>("lastName"));
            lastNameColumn.setCellFactory(cellFactory);
            lastNameColumn.setOnEditCommit(
		            new EventHandler<CellEditEvent<Novus, String>>() {
		                @Override
		                public void handle(CellEditEvent<Novus, String> t) {
		                    ((Novus) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setFirstName(t.getNewValue());
		                }
		             }
		        );        
	 }
	 
	 
	/*  public void setApp(MainApp application){
	        this.application = application;
	    }
	*/
	
	
	private void showTesters()
	{		
	
		novusData.removeIf(p -> "Developer".equals(p.getNovusStream()));
		novusData.removeIf(p -> "Business Analyst".equals(p.getNovusStream()));
		updateNovusCount();
      
	}
	private void showDevelopers()
	{		
	
		novusData.removeIf(p -> "Tester".equals(p.getNovusStream()));
		novusData.removeIf(p -> "Business Analyst".equals(p.getNovusStream()));
		updateNovusCount();
      
	}
	private void showBusinessAnalysts()
	{		
	
		novusData.removeIf(p -> "Developer".equals(p.getNovusStream()));
		novusData.removeIf(p -> "Tester".equals(p.getNovusStream()));
		updateNovusCount();
      
	}
	private void showAll()
	{
		novusTable.setItems(null);
		loadData();
		novusTable.setItems(novusData);
		
	}
	
	private void loadData()
	{
		novusData.add(new Novus("John", "Kim", "Developer","Group 3"));
        novusData.add(new Novus("James", "Ryan", "Business Analyst","Group 1"));
        novusData.add(new Novus("Kim", "James", "Tester","Group 5"));
        novusData.add(new Novus("Bob", "Wayne", "Developer","Group 9"));
        novusData.add(new Novus("Ryan", "Wayne", "Business Analyst","Group 2"));
        novusData.add(new Novus("Hally", "Mano", "Developer","Group 4"));
        novusData.add(new Novus("Mandy", "Bando", "Tester","Group 22"));
        novusData.add(new Novus("Pete", "Kiolo", "Developer","Group 9"));
        novusData.add(new Novus("Dave", "Lookoe", "Business Analyst","Group 3"));
        novusData.add(new Novus("Steven", "Nook", "Tester","Group 4"));
        novusData.add(new Novus("Lolo", "Booki", "Tester","Group 4"));
        novusData.add(new Novus("Kimolo", "Rooki", "Business Analyst","Group 4"));
        
        //novusTable.setItems(value);
	}
	
	private void updateNovusCount()
	{
		developerCount =0;
		testerCount =0;
		businessAnalystsCount =0;
		for(Novus novus : novusData )
		{
			if(novus.getNovusStream() == "Developer")
			{
				developerCount +=1;
				developerCountText.setText(""+ developerCount);
			}
			else if(novus.getNovusStream() == "Tester")
			{
				testerCount +=1;
				testersCountText.setText(""+ testerCount);
			}
			else if(novus.getNovusStream() == "Business Analyst")
			{
				businessAnalystsCount +=1;
				businessAnalystsCountText.setText(""+ businessAnalystsCount);
			}
			
			totalNovusCount = (developerCount+testerCount+businessAnalystsCount);
			totalNovusText.setText(""+ totalNovusCount);
		}
		
		System.out.println("Developers :" + developerCount);
		System.out.println("Testers :" + testerCount);
		System.out.println("Business Analysts :" + businessAnalystsCount);
	}
	

	
	private void openProfile()
	{
		Parent root = null;
        System.out.println("Double clicked");
        try
        {
        	root = FXMLLoader.load(getClass().getResource("/view/NovusProfile.fxml"));
        }
        catch(Exception ex){}
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
       
        Scene scene = new Scene(root);
        dialog.setScene(scene);
        dialog.setTitle("Novus Profile");
        dialog.show();
	}
	
	private void addToggleFilter()
	{		
		
        novusSelection.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle old_toggle, Toggle new_toggle) {
              if (novusSelection.getSelectedToggle() != null) {
            	  if(developersRButton.isSelected())
            	  {
            		 // showDevelopers();
            		
            	  }
            	  else if(testersRButton.isSelected())
            	  {
            		//  showTesters();
            	
            	  }
            	  else if(businessAnalystsRButton.isSelected())
            	  {
            		//showBusinessAnalysts();
            		
            	  }
            	  else 
            	  {
            		 // showAll();
            	  }
                System.out.println(novusSelection.getSelectedToggle().selectedProperty());
              }
            }
          });
	}

	private void addSearchFilter()
	{
		
		FilteredList<Novus> filteredData = new FilteredList<>(novusData, n -> true);

		searchField.textProperty().addListener((observable, oldValue, newValue) -> 
		{
			filteredData.setPredicate(novus -> 
			{
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) 
				{
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();				
				
				if (novus.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) 
				{
					return true; // Filter matches first name.
				} 
				else if (novus.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1) 
				{
					return true; // Filter matches last name.
				}
				novusTable.setPlaceholder(new Text(newValue + " Not Found"));
				return false; // Does not match.
				  
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Novus> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(novusTable.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		novusTable.setItems(sortedData);
		
	}

}
