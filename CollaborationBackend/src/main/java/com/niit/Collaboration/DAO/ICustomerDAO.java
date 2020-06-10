package com.niit.Collaboration.DAO;

import com.niit.Collaboration.Model.Customer;

public interface ICustomerDAO {
	
	public boolean addCustomer(Customer customer);
	
	public boolean updateCustomer(Customer customer);
	
    public Customer selectCustomer(String emailid);

}
