package com.niit.CollaborationBack.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerCred {

	@Id
	String cust_Emailid;
	
	@Column(nullable=false)
	String cust_Role;
	
	@Column(nullable=false)
	String cust_Password;
	
	
	public String getCust_Emailid() {
		return cust_Emailid;
	}

	public void setCust_Emailid(String cust_Emailid) {
		this.cust_Emailid = cust_Emailid;
	}

	public String getCust_Role() {
		return cust_Role;
	}

	public void setCust_Role(String cust_Role) {
		this.cust_Role = cust_Role;
	}

	public String getCust_Password() {
		return cust_Password;
	}

	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}

	

}
