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
import com.niit.Collaboration.DAO.IForumAnsDAO;
import com.niit.Collaboration.DAO.IForumDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;

@RestController
@RequestMapping("/forumans")
public class ForumAnsController {
	@Autowired
	IForumAnsDAO forumansdao;
	@Autowired
	IForumDAO forumdao;
	@PostMapping("/addforumans")
	ResponseEntity<Void> addMyForumAns(@RequestParam("forumid")int forumid,@RequestBody ForumAnswer forumans,HttpSession session)
	{
		Forum forum=forumdao.selectOneForum(forumid);
		Customer cust=(Customer)session.getAttribute("custdetails");
		forumans.setCustomer(cust);
		forumans.setPosted_Date(new Date());
		forumans.setForum(forum);
		if(forumansdao.addForumAnswer(forumans))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/updateforumans")
	ResponseEntity<Void> updateMyForumAns(@RequestParam("forumansid")int forumansid,@RequestBody ForumAnswer forumans)
	{
		ForumAnswer newforumans=forumansdao.selectOneForumAnswer(forumansid);
		newforumans.setForumans(forumans.getForumans());
	newforumans.setForum_Status(false);
	newforumans.setForum(newforumans.getForum());
		newforumans.setPosted_Date(new Date());
		if(forumansdao.updateForumAnswer(newforumans))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@DeleteMapping("deleteforumans")
	ResponseEntity<Void> deleteMyForumAns(@RequestParam("forumansid")int forumansid)
	{
		ForumAnswer forumans=forumansdao.selectOneForumAnswer(forumansid);
		if(forumansdao.deleteForumAnswer(forumans))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/selectoneforumans")
	ResponseEntity<ForumAnswer> selectOneForumAnswer(@RequestParam("forumansid")int id)
	{
		ForumAnswer forumans=forumansdao.selectOneForumAnswer(id);
		if(forumans==null)
		{
			return new ResponseEntity<ForumAnswer>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<ForumAnswer>(forumans,HttpStatus.FOUND);
		}	
	}
	@GetMapping("/myforumans")
	ResponseEntity<List<ForumAnswer>> selectUnApprovedForumans(HttpSession session)
	{
		ArrayList<ForumAnswer> forumanslist=forumansdao.selectAllUnapporovedForumAnswer();
		if(forumanslist.isEmpty())
		{
			return new ResponseEntity<List<ForumAnswer>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<ForumAnswer>>(forumanslist,HttpStatus.FOUND);
		}	
	}
	@GetMapping("/allapprovedforumans")
	ResponseEntity<List<ForumAnswer>> selectApprovedForumans(@RequestParam("forumid")int id)
	{
		Forum forum=forumdao.selectOneForum(id);
		ArrayList<ForumAnswer> forumanslist=forumansdao.selectAllApporovedForumAnswer();
		if(forumanslist.isEmpty())
		{
			return new ResponseEntity<List<ForumAnswer>>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<ForumAnswer>>(forumanslist,HttpStatus.FOUND);
		}	
	}
	@GetMapping("/updatestatus")
	ResponseEntity<Void> addMyForumanswer(@RequestParam("forumansid")int id)
	{
		ForumAnswer forumans=forumansdao.selectOneForumAnswer(id);
		
		forumans.setForum_Status(true);
		if(forumansdao.updateForumAnswer(forumans))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
