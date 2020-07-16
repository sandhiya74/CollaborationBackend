package com.niit.Collaboration.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.ICustomerDAO;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.CustomerCred;

@Repository("customerdao")
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addCustomer(Customer customer) {

		try {
			sessionfactory.getCurrentSession().save(customer);
			CustomerCred cred = new CustomerCred();
			cred.setCust_Email(customer.getCust_Email());
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

	@Override
	public Customer selectCustomer(String cust_email) {
		try {
			Customer customer = (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
					.add(Restrictions.eq("cust_Email", cust_email)).uniqueResult();
			return customer;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Customer> selectAllCustomer() {
		try {
			ArrayList<Customer> customer = (ArrayList<Customer>) sessionfactory.getCurrentSession()
					.createCriteria(Customer.class).list();
			return customer;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Customer checkUser(Customer customer) {
		CustomerCred cred = (CustomerCred) sessionfactory.getCurrentSession().createCriteria(CustomerCred.class)
				.add(Restrictions.eq("cust_Email", customer.getCust_Email())).uniqueResult();
		 if (cred.getCust_Password().equals(customer.getCust_Password())) {
			 Customer cust=selectCustomer(customer.getCust_Email());
			 cust.setCust_Role(cred.getCust_Role());
			 return cust;
		 }
			else
				
			{
				return null;
			}
	}

}