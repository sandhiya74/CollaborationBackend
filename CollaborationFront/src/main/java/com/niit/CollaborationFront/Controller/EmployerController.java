package com.niit.CollaborationFront.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBack.DAO.IBlogDAO;
import com.niit.CollaborationBack.DAO.ICustomerDAO;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.Customer;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/customer")
public class EmployerController {

	@Autowired
	ICustomerDAO customerdao;
	
	
	
	@GetMapping
	ResponseEntity<List<Customer>> selectAllCustomer()
	{
		ArrayList<Customer> custlist=(ArrayList<Customer>) customerdao.selectAllCustomer();
		if(custlist.isEmpty())
		{
			return new ResponseEntity<List<Customer>>(custlist,HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<List<Customer>>(custlist,HttpStatus.FOUND);
		}
		
	}
	@PostMapping
	ResponseEntity<Void> addCustomer(@RequestBody Customer customer)
	{
		System.out.println("entered add method");
		if(customerdao.addCustomer(customer))
		{
			System.out.println("customer add");
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	}
	@GetMapping("/{fetchone}")
	ResponseEntity<Customer>selectCustomer(@RequestParam("emailid")String emailid)
	{
		
		System.out.println(emailid);
		Customer cust=customerdao.selectCustomer(emailid);
		if(cust==null)
		{
			System.out.println("customer not found");
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		else
		{
			System.out.println("customer found"+cust.getCust_Emailid());
		return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
		}
	}
	
	
}
