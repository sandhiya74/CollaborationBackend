package com.niit.CollaborationMiddle.Controller;

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

import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Customer;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	IBlogDAO blogdao;
	
	@GetMapping("/adminapproval")
	ResponseEntity<List<Blog>> selectUnApprovedBlogs(HttpSession session)
	{
		ArrayList<Blog> bloglist=blogdao.selectAllUnapporovedBlogs();
		if(bloglist.isEmpty())
		{
			return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.FOUND);
		}	
	}
	@GetMapping("/allblogs")
	ResponseEntity<List<Blog>> selectApprovedBlogs(HttpSession session)
	{
		ArrayList<Blog> bloglist=blogdao.selectAllApporovedBlogs();
		if(bloglist.isEmpty())
		{
			return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.FOUND);
		}	
	}
	@GetMapping("/myblogs")
	ResponseEntity<List<Blog>> selectMyBlogs(HttpSession session)
	{
		System.out.println("line 1");
		Customer cust=(Customer)session.getAttribute("custdetails");
		ArrayList<Blog> bloglist=blogdao.selectAllBlogOfOneUser(cust);
		if(bloglist.isEmpty())
		{
			System.out.println("line 2");
			return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			System.out.println("line 3");
			return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.FOUND);
		}	
	}
	@GetMapping("/selectoneblog")
	ResponseEntity<Blog> selectOneBlogs(@RequestParam("blogid")int id)
	{
		Blog blog=blogdao.selectOneBlog(id);
		if(blog==null)
		{
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.FOUND);
		}	
	}
	@PostMapping("/addblog")
	ResponseEntity<Void> addMyBlog(@RequestBody Blog blog,HttpSession session)
	{
		Customer cust=(Customer)session.getAttribute("custdetails");
		blog.setCustomer(cust);
		blog.setPosted_Date(new Date());
		if(blogdao.addBlog(blog))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	// is the function the admin is going to work with so overe here is going to approve blog
	@GetMapping("/updatestatus")
	ResponseEntity<Void> addMyBlog(@RequestParam("blogid")int id)
	{
		Blog blog=blogdao.selectOneBlog(id);
		
		blog.setStatus(true);
		if(blogdao.updateBlog(blog))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@PutMapping("/updateblog")
	ResponseEntity<Void> updateMyBlog(@RequestParam("blogid")int blogid,@RequestBody Blog blog)
	{
		Blog newblog=blogdao.selectOneBlog(blogid);
		newblog.setBlog_Title(blog.getBlog_Title());
		newblog.setBlog_Content(blog.getBlog_Content());
		newblog.setStatus(false);
		newblog.setPosted_Date(new Date());
		if(blogdao.updateBlog(newblog))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@DeleteMapping("deleteblog")
	ResponseEntity<Void> deleteMyBlog(@RequestParam("blogid")int blogid)
	{
		Blog blog=blogdao.selectOneBlog(blogid);
		if(blogdao.deleteBlog(blog))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
 }

