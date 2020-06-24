package com.niit.CollaborationBack.DAO;

import java.util.List;

import com.niit.CollaborationBack.Model.Customer;


public interface ICustomerDAO {
	
public boolean addCustomer(Customer customer);
	
	public boolean updateCustomer(Customer customer);
	
    public Customer selectCustomer(String emailid);
    
    public List<Customer> selectAllCustomer();
    
    public String checkUser(Customer customer);

}
