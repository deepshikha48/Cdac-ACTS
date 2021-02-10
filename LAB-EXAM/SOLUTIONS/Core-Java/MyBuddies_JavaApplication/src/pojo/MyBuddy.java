package pojo;

import java.sql.Date;

public class MyBuddy {
	
	private String emailId;
	private String name;
	private String phoneNumber;
	private Date dateOfBirth;
	private String city;
	
	//constructor
	public MyBuddy(String emailId, String name, String phoneNumber, Date dateOfBirth, String city) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
	}
	
	//All getters and setters

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	//to string 
	@Override
	public String toString() {
		return "MyBuddy [emailId=" + emailId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", dateOfBirth="
				+ dateOfBirth + ", city=" + city + "]";
	}
	
	


}
