package com.niit.CollaborationFront.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBack.DAO.IBlogDAO;
import com.niit.CollaborationBack.DAO.ICustomerDAO;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.Customer;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	IBlogDAO blogdao;
	
	@Autowired
	
	ICustomerDAO customerdao;
	
	
	@GetMapping("/adminapproval")
	ResponseEntity<List<Blog>> selectUnApprovedBlogs()
	{
		ArrayList<Blog> bloglist=(ArrayList<Blog>) blogdao.selectAllUnapprovedBlogs();
		if(bloglist.isEmpty())
		{
			return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.FOUND);
		}
		
	}
	

	@GetMapping("/allblogs")
	ResponseEntity<List<Blog>> selectApprovedBlogs()
	{
		ArrayList<Blog> bloglist=(ArrayList<Blog>) blogdao.selectApprovedBlogs();
		if(bloglist.isEmpty())
		{
			return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.FOUND);
		}
		
	}

	@GetMapping("/myblogs")
	ResponseEntity<List<Blog>> selectMyBlogs(HttpSession session)
	{
		Customer cust=(Customer)session.getAttribute("custdetails");
		ArrayList<Blog> bloglist=(ArrayList<Blog>) blogdao.selectAllBlogofOneUser(cust);
		if(bloglist.isEmpty())
		{
			return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.FOUND);
		}
		
	}
	
	@PostMapping("/addblogs")
	ResponseEntity<Void> addMyBlogs(@RequestBody Blog blog,HttpSession session)
	{
		Customer cust=(Customer)session.getAttribute("custdetails");
		blog.setCustomer(cust);
		blog.setPosted_Date(new Date());
		if(blogdao.addBlog(blog))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	}
	@GetMapping("/updatestatus")
	ResponseEntity<Void> addMyBlogs(@RequestParam ("blogid")int blogid)
	{
		
		Blog blog=blogdao.selectOneBlog(blogid);
		
		blog.setBlog_Status(true);
		if(blogdao.updateBlog(blog))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/selectoneblog")
	ResponseEntity<Blog> selectOneBlog(@RequestParam ("blogid")int blogid)
	{
		Blog blog=blogdao.selectOneBlog(blogid);
		
		if(blog==null)
		{
			
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}else
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.FOUND);
		}
	}
	@DeleteMapping("/deleteblog")
	ResponseEntity<Void> deleteMyBlog(@RequestParam ("blogid")int blogid)
	{
		Blog blog=blogdao.selectOneBlog(blogid);
		
		if(blogdao.deleteBlog(blog))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
		
	@PutMapping("/updateblog")
	ResponseEntity<Void> UpdateBlogs(@RequestParam ("blogid")int blogid,@RequestBody Blog blog)
	{
		Blog newblog=blogdao.selectOneBlog(blogid);
		newblog.setBlog_Title(blog.getBlog_Title());
		newblog.setBlog_Content(blog.getBlog_Content());
		newblog.setBlog_Status(false);
		newblog.setPosted_Date(new Date());
		if(blogdao.updateBlog(newblog))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	}	
	
	
	
}
