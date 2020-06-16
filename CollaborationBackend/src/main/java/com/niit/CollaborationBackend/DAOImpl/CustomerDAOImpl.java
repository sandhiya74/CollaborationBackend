package com.niit.CollaborationBackend.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.ICustomerDAO;
import com.niit.Collaboration.Model.Customer;

@Repository("customerdao")
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().save(customer);
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

}
