package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Novus 
{
	private IntegerProperty id;
	private StringProperty firstName;
	private StringProperty lastName;	
	private StringProperty novusStream;
	private StringProperty group;
	private StringProperty status;
	private IntegerProperty contactNumber;
	private StringProperty email;
	private StringProperty currentlyPlaceAt;
	private IntegerProperty changeOfContractRenewal;
	
	public Novus(String newFirstName, String newLastName, String newNovusStream, String newGroup)
	{
		this.firstName = new SimpleStringProperty(newFirstName);
		this.lastName = new SimpleStringProperty(newLastName);
		this.novusStream = new SimpleStringProperty(newNovusStream);
		this.group = new SimpleStringProperty(newGroup);
		
	}
	
	public Novus()
	{
		 this(null, null, null, null);
	}
	
	//////////////////////////////////////////////////////////
	public void setFirstName(String newFirstName)
	{
		this.firstName.set(newFirstName);
	}
	public String getFirstName()
	{
		return firstName.get();
	}
	public StringProperty firstNameProperty()
	{
		return firstName;
	}
//////////////////////////////////////////////////////////
	public void setLastName(String newLastName)
	{
		this.lastName.set(newLastName);
	}
	public String getLastName()
	{
		return lastName.get();
	}
	public StringProperty lastNameProperty()
	{
		return lastName;
	}
//////////////////////////////////////////////////////////
	public void setNovusStream(String newNovusStream)
	{
		this.novusStream.set(newNovusStream);
	}
	public String getNovusStream()
	{
		return novusStream.get();
	}	
	public StringProperty novusStreamProperty()
	{
		return novusStream;
	}
//////////////////////////////////////////////////////////
	public void setGroup(String newGroup)
	{
		this.group.set(newGroup);
	}
	public String getGroup()
	{
		return group.get();
	}
	public StringProperty groupProperty()
	{
		return group;
	}
//////////////////////////////////////////////////////////
	public void setStatus(String newStatus)
	{
		this.status.set(newStatus);
	}
	public String getStatus()
	{
		return status.get();
	}
	public StringProperty statusProperty()
	{
		return status;
	}
	/////////////////////////////////////////////////
	public void setContactNumber(int newContactNumber)
	{
		this.contactNumber.set(newContactNumber);
	}
	public int getContactNumber()
	{
		return contactNumber.get();
	}
	public IntegerProperty contactNumberProperty()
	{
		return contactNumber;
	}
//////////////////////////////////////////////////////////
	public void setEmail(String newEmail)
	{
		this.email.set(newEmail);
	}
	public String getEmail()
	{
		return email.get();
	}
	public StringProperty emailProperty()
	{
		return email;
	}
//////////////////////////////////////////////////////////
	
	
	

}
