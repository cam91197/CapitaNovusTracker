package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Person {
	
	private IntegerProperty id;
	private StringProperty firstName;
	private StringProperty lastName;	
	private IntegerProperty contactNumber;
	private StringProperty email;
	
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
	///////////////////////////////////////////
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

}
