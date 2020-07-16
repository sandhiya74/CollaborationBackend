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
		
		@Column(nullable = false, unique = true)
		String cust_Name;
		
		@Column(nullable = false, unique = true)
		String cust_Email;
		
		@Column(nullable = false, unique = true)
		String cust_Phno;
		
		@Transient
		@Column(nullable = false)
		String cust_Password;
		
		@Transient
		@Column(nullable = false)
		String cust_Role;
		
		public String getCust_Role() {
			return cust_Role;
		}
		public void setCust_Role(String cust_Role) {
			this.cust_Role = cust_Role;
		}
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
		public String getCust_Email() {
			return cust_Email;
		}
		public void setCust_Email(String cust_Email) {
			this.cust_Email = cust_Email;
		}
		public String getCust_Phno() {
			return cust_Phno;
		}
		public void setCust_Phno(String cust_Phno) {
			this.cust_Phno = cust_Phno;
		}
		public String getCust_Password() {
			return cust_Password;
		}
		public void setCust_Password(String cust_Password) {
			this.cust_Password = cust_Password;
		}
		
}