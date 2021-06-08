package com.springboot.bankapplication.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerRequestDto {

	@NotNull(message = "FirstName should not be null")
	private String firstName;

	@NotNull(message = "LastName should not be null")
	private String lastName;

	@Email(message = "Please provide a valid email address")
	private String emailID;
	
	@NotNull(message = "Mobile number should not be null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid mobile no.")
	private String mobileNo;

	@NotNull(message = "Area should not be null")
	private String area;

	@NotNull(message = "City should not be null")
	private String city;

	@NotNull(message = "State should not be null")
	private String state;

	@Size(max = 6, min = 6, message = "Please put valid pincode")
	private String pincode;

	@NotNull(message = "Account Type should not be null")
	private String accountType;

	public CustomerRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "BankCustomerRequestDto [firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID
				+ ", mobileNo=" + mobileNo + ", area=" + area + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + ", accountType=" + accountType + "]";
	}
	
	
}
