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

import com.niit.Collaboration.DAO.IBlogCommentDAO;
import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;


@RestController
@RequestMapping("/blogcomment")

public class BlogCommentController {
	@Autowired
	IBlogCommentDAO blogcommentdao;
	@Autowired
	IBlogDAO blogdao;
	

	@PostMapping("/addblogcomment")
	ResponseEntity<Void> addMyBlogComment(@RequestParam("blogid")int blogid,@RequestBody BlogComment blogcomment,HttpSession session)
	{
		Blog blog=blogdao.selectOneBlog(blogid);
		
	
		Customer cust=(Customer)session.getAttribute("custdetails");
		blogcomment.setCustomer(cust);
		blogcomment.setComment_Date(new Date());
		blogcomment.setBlog(blog);
		if(blogcommentdao.addBlogComment(blogcomment))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/updateblogcomment")
	ResponseEntity<Void> updateMyBlog(@RequestParam("blogcommentid")int blogcommentid,@RequestBody BlogComment blogcomment)
	{
		BlogComment newblogcomment=blogcommentdao.selectOneBlogComment(blogcommentid);
		
		newblogcomment.setComment(blogcomment.getComment());
		newblogcomment.setComment_Date(new Date());
		if(blogcommentdao.updateBlogComment(newblogcomment))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@DeleteMapping("deleteblogcomment")
	ResponseEntity<Void> deleteMyBlogComment(@RequestParam("blogcommentid")int blogcommentid)
	{
		BlogComment blogcomment=blogcommentdao.selectOneBlogComment(blogcommentid);
		if(blogcommentdao.deleteBlogComment(blogcomment))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/selectoneblogcomment")
	ResponseEntity<BlogComment> selectOneBlogComment(@RequestParam("blogcommentid")int id)
	{
		BlogComment blogcomment=blogcommentdao.selectOneBlogComment(id);
		if(blogcomment==null)
		{
			return new ResponseEntity<BlogComment>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<BlogComment>(blogcomment,HttpStatus.FOUND);
		}	
	}
	@GetMapping("/allblogcomment")
	ResponseEntity<List<BlogComment>> selectAllBlogComments(@RequestParam("blogid")int id)
	{
		Blog blog=blogdao.selectOneBlog(id);
		ArrayList<BlogComment> blogcommentlist=blogcommentdao.selectAllComments(blog);
		if(blogcommentlist.isEmpty())
		{
			return new ResponseEntity<List<BlogComment>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<BlogComment>>(blogcommentlist,HttpStatus.FOUND);
		}	
	}
}
