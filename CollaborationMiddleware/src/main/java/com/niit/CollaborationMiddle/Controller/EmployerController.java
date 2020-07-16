package com.niit.CollaborationMiddle.Controller;


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

import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.DAO.ICustomerDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Customer;
/*@RestController--->
 * It is given to denote that this class will act as a controller and will have a response to each and every request
 * @ controller+@repository----@RestController(spring version 4)
 * T in the response entity denotes the object returned by the request
 * if it is not going to return any object then we will use the generic return
 * in case a method do return any value
 * void setName()
 * {}
 * void is a primitive datatype
 * now ResponseEntity<T>
 * <T>---Generic Datatype(ReferenceDatatype)---Void
 * int---Integer(WrapperClass)
 * void--Void(WrapperClass) when ever the user is sending ata to the database then we will use void
 * ResponseEntity ---->
 * ResponseEntity will be assigned with one or more values
 * parameter used by ResponseEntity
 * HTTPSTATUS--Enum all the http status are given to us we need to select the correct status that might be used in that particular context.
 *1) if the return type is Void then it will  take only one parameter
 * 2)if the return type is Stringthe it will take
 *       i) is the value to be returned this is optional and can be omitted if the value returned by the database is null
 *       ii) is the http status
 *  ResponseEntity will help me in returning he value in json  format.
 *  return new Responseentity<String>{"my  name is mythreye",HttpStatus,Accepted)
 *  NOTE:try to avoid the use of null for ArrayList as it s a Single Valu
 *  @PostMapping---->
 *  when ever we do a post mapping the result that we expect for the server is successful/not successful
 *  the rest service will only reply with  status and no data
 *  ResponseEntity<Void>
 *  localhost:8080/libroworld/addcustomer---requestheader--we will have the url and mapping type
 *  RequestBody--->
 *  u have the object in which the form details are stored---deserialization--ie--- convert json to java object
 *  more than one value there ll be requestbody...
 *  
 *  it should be followed my the class for which the data is going to be returned
 * @PathVariable---> is the one which fetch data from the database
 *  it always return a web file but here we are returning class so we are using requestparam and getting emailid.
 * it is generaly used when ever u want to maintain the same requeatmapping through out the controller.
 *   wanna  fetch one customer
 *    http://localhost:8080/libroworld/getProduct?pid=12;
 *    ?---Query String and the keyword that comes after the quest mark is requestparameter
 *      http://localhost:8080/libroworld/getProduct/12;
 *    
 *  
 *  i need to get the form details
 *  along with the request
 *  
 *  @RequestMapping is given to map all methods with one common url and above each method we
 *   will say for what type of mapping this particular method must get executed.
 *   put mapping---- mainly used for update and used for partial obects same as postmapping
 *   postmapping-----used for insertion
 */
@RestController
@RequestMapping("/customer")
public class EmployerController {
@Autowired
ICustomerDAO customerdao;

@GetMapping
 ResponseEntity<List<Customer>> selectAllCustomer()
{
	ArrayList<Customer> custlist=(ArrayList<Customer>)customerdao.selectAllCustomer();
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
ResponseEntity<Void>addCustomer(@RequestBody Customer customer)
{
	if(customerdao.addCustomer(customer))
	{
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	else
	{
		return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
}
@GetMapping("/fetchone")
ResponseEntity<Customer>selectOneCustomer(@RequestParam("emailid")String emailid)
{
	//emailid=emailid+".com";
	//System.out.println(emailid);
	Customer cust=customerdao.selectCustomer(emailid);
	if(cust==null)
	{
		System.out.println("customer not found");
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		
	}
	else
	{
		System.out.println("customer found");
		return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
	}
}

}