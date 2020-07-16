package com.niit.Collaboration.DAO;


import java.util.List;

import com.niit.Collaboration.Model.Customer;


public interface ICustomerDAO {
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public Customer selectCustomer(String cust_email);
	public List<Customer> selectAllCustomer();
	public Customer checkUser(Customer customer);

}