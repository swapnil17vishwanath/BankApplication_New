package com.springboot.bankapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long customerId;
	
	private String firstName;

	private String lastName;

	private String emailID;

	private String mobileNo;

	private String area;

	private String city;

	private String state;

	private String pincode;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private CustomerAccount customerAccount;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Customer(Long customerId, String firstName, String lastName, String emailID, String mobileNo,
			String area, String city, String state, String pincode, CustomerAccount customerAccount) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.mobileNo = mobileNo;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customerAccount = customerAccount;
	}



	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	@Override
	public String toString() {
		return "BankCustomer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailID=" + emailID + ", mobileNo=" + mobileNo + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", customerAccountDetails=" + customerAccount + "]";
	}

}
