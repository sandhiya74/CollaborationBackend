package com.niit.Collaboration.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cust_Id;
	
	@Column(nullable=false,unique=true)
	String cust_Name;
	
	@Column(nullable=false,unique=true)
	String cust_Emailid;
	
	@Column(nullable=false,unique=true)
	String cust_Phone;
	
	@Transient
	@Column(nullable=false)
	String cust_Password;

	public int getCust_Id() {
		return cust_Id;
	}

	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}

	public String getCust_Emailid() {
		return cust_Emailid;
	}

	public void setCust_Emailid(String cust_Emailid) {
		this.cust_Emailid = cust_Emailid;
	}

	public String getCust_Phone() {
		return cust_Phone;
	}

	public void setCust_Phone(String cust_Phone) {
		this.cust_Phone = cust_Phone;
	}

	public String getCust_Password() {
		return cust_Password;
	}

	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}

	
}
