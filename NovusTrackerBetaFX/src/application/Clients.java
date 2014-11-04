package application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clients 
{
	
	private StringProperty clientName;
	private StringProperty contactName;
	private IntegerProperty contactNumber;
	private StringProperty contactEmail;
	private StringProperty recruiting;
	private BooleanProperty status;

	
	public Clients(String newClientName, String newCurrentHiring, boolean newStatus)
	{
		this.clientName = new SimpleStringProperty(newClientName);
		this.recruiting = new SimpleStringProperty(newCurrentHiring);
		this.status = new SimpleBooleanProperty(newStatus);
				
	}
	
	public Clients()
	{
		 this(null, null, false);
	}
	
	
	public void setClientName(String newClientName)
	{
		this.clientName.set(newClientName);
	}
	public String getClientName()
	{
		return clientName.get();
	}
	public StringProperty clientNameProperty()
	{
		return clientName;
	}
	//////////////////////////////////////////////////////////
	public void setContactName(String newContactName)
	{
		this.contactName.set(newContactName);
	}
	
	public String getContactName()
	{
		return contactName.get();
	}
	public StringProperty contactNameProperty()
	{
		return contactName;
	}
	//////////////////////////////////////////////////////////
	public void setContactNumber(int newContactNumber)
	{
		this.contactNumber.set(newContactNumber);
	}
	public int getContactNumber()
	{
		return contactNumber.get();
	}
	public IntegerProperty getContactNumberProperty()
	{
		return contactNumber;
	}
	//////////////////////////////////////////////////////////
	public void setContactEmail(String newContactEmail)
	{
		this.contactEmail.set(newContactEmail);
	}
	public String getContactEmail()
	{
		return contactEmail.get();
	}
	public StringProperty contactEmailProperty()
	{
		return contactEmail;
	}
	
	//////////////////////////////////////////////////////////
	public void setRecruiting(String newRecruiting)
	{
		this.recruiting.set(newRecruiting);
	}
	public String getRecruiting()
	{
		return recruiting.get();
	}
	public StringProperty recruitingProperty()
	{
		return recruiting;
	}
//////////////////////////////////////////////////////////
	public void setLastName(Boolean newStatus)
	{
		this.status.set(newStatus);
	}
	public Boolean getStatus()
	{
		return status.get();
	}
	public BooleanProperty statusProperty()
	{
		return status;
	}
//////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////
	
	
	

}
