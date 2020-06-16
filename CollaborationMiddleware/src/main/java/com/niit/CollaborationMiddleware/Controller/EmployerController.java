package com.niit.CollaborationMiddleware.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration.DAO.ICustomerDAO;
import com.niit.Collaboration.Model.Customer;

@RestController
public class EmployerController {

	@Autowired
	ICustomerDAO customerdao;
	
	ResponseEntity<List<Customer>> selectAllCustomer()
	{
		ArrayList<Customer> custlist=(ArrayList<Customer>)customerdao.selectAllCustomer();
		if(custlist.isEmpty())
		{
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<List<Customer>>(custlist,HttpStatus.FOUND);
		}
		
	}
	   
}
