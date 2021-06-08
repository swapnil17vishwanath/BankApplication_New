package com.springboot.bankapplication.dto;

public class CustomerResponseDto {

	private String firstName;
	private String lastName;
	private String city;
	private String mobileNo;
	private Long accountNumber;
	private double availableBalence;

	public CustomerResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerResponseDto(String firstName, String lastName, String city, String mobileNo, Long accountNumber,
			double availableBalence) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.mobileNo = mobileNo;
		this.accountNumber = accountNumber;
		this.availableBalence = availableBalence;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAvailableBalence() {
		return availableBalence;
	}

	public void setAvailableBalence(double availableBalence) {
		this.availableBalence = availableBalence;
	}

}
