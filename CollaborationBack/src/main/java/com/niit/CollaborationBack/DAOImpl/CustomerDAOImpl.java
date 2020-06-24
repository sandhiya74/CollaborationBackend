package com.niit.CollaborationBack.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBack.DAO.ICustomerDAO;
import com.niit.CollaborationBack.Model.Customer;
import com.niit.CollaborationBack.Model.CustomerCred;

@Repository("customerdao")
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().save(customer);
			CustomerCred cred=new CustomerCred();
			cred.setCust_Emailid(customer.getCust_Emailid());
			cred.setCust_Password(customer.getCust_Password());
			
			cred.setCust_Role(customer.getCust_Role());
			sessionfactory.getCurrentSession().save(cred);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Customer selectCustomer(String emailid) {
		try {
			Customer customer= (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
					.add(Restrictions.eq("cust_Emailid",emailid)).uniqueResult();
			return customer;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Customer> selectAllCustomer() {
		try
		  {
			  ArrayList<Customer> customer= (ArrayList<Customer>)sessionfactory.getCurrentSession()
					  .createCriteria(Customer.class).list();
			  return customer;
		  }
		  catch(Exception e) {
			  
		  
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public String checkUser(Customer customer) {
		CustomerCred cred=(CustomerCred) sessionfactory.getCurrentSession().createCriteria(CustomerCred.class)
				.add(Restrictions.eq("cust_Emailid",customer.getCust_Emailid())).uniqueResult();
		if(cred==null)
		{
			return "User Does not Exists";
		}
		else if(cred.getCust_Password().equals(customer.getCust_Password()))
		{
			if(cred.getCust_Role().equals("Employee"))
			
				return "Employee";
				else if(cred.getCust_Role().equals("Employer"))
				
					return "Employer";
				else
					return "Admin";
				
			
		}
		else
		{
			return "Password Incorrect";
		}
		
	}

}
