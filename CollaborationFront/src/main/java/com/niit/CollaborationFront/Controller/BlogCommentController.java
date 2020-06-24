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

import com.niit.CollaborationBack.DAO.IBlogCommentDAO;
import com.niit.CollaborationBack.DAO.IBlogDAO;
import com.niit.CollaborationBack.DAO.ICustomerDAO;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.BlogComment;
import com.niit.CollaborationBack.Model.Customer;

@RestController
@RequestMapping("/blogcomment")
public class BlogCommentController {

	@Autowired
	IBlogCommentDAO blogcommentdao;
	
	@Autowired
	ICustomerDAO customerdao;
	
	@Autowired
	IBlogDAO blogdao;
	
	@PostMapping("/addblogcomment")
	ResponseEntity<Void> addMyBlogComment(@RequestParam("blogid")int blogid,@RequestBody BlogComment blogcomment,HttpSession session)
	{
		Blog blog=blogdao.selectOneBlog(blogid);
		
		Customer cust=(Customer)session.getAttribute("custdetails");
		blogcomment.setCustomer(cust);
		blogcomment.setPosted_Date(new Date());
		blogcomment.setBolg(blog);
		if(blogcommentdao.addBlogComment(blogcomment))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	}
	@SuppressWarnings("unused")
	@GetMapping("/selectoneblogcomment")
	ResponseEntity<BlogComment> selectOneBlog(@RequestParam ("blogcommentid")int blogcommentid)
	{
		BlogComment blogcomment=blogcommentdao.selectOneBlogComment(blogcommentid);
		System.out.println(blogcomment.getBlog_Comment());
		if(blogcomment==null)
		{
			
			return new ResponseEntity<BlogComment>(HttpStatus.NOT_FOUND);
		}else
		{
			return new ResponseEntity<BlogComment>(blogcomment,HttpStatus.FOUND);
		}
	}
	@PutMapping("/updateblogcomment")
	ResponseEntity<Void> UpdateBlogComment(@RequestParam ("blogcommentid")int blogcommentid,@RequestBody BlogComment blogComment)
	{
		BlogComment newblogcomment=blogcommentdao.selectOneBlogComment(blogcommentid);
		newblogcomment.setBlog_Comment(blogComment.getBlog_Comment());
		newblogcomment.setBolg(blogComment.getBolg());
		
		newblogcomment.setPosted_Date(new Date());
		if(blogcommentdao.updateBlogComment(newblogcomment))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	}	
	@DeleteMapping("/deleteblogcomment")
	ResponseEntity<Void> deleteMyBlogComment(@RequestParam ("blogcommentid")int blogcommentid)
	{
		BlogComment b=blogcommentdao.selectOneBlogComment(blogcommentid);
		
		if(blogcommentdao.deleteBlogComment(b))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/allblogcomments")
	ResponseEntity<List<BlogComment>> selectAllComment(@RequestParam("bolgid")int blogid)
	{
		Blog blog=blogdao.selectOneBlog(blogid);
		ArrayList<BlogComment> commentlist=blogcommentdao.selectAllComment(blog);
		if(commentlist.isEmpty())
		{
			return new ResponseEntity<List<BlogComment>>(HttpStatus.NOT_FOUND);
		}
		else {
			
			return new ResponseEntity<List<BlogComment>>(commentlist,HttpStatus.FOUND);
		}
	}
	
}
