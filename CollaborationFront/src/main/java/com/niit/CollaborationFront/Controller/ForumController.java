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

import com.niit.CollaborationBack.DAO.ICustomerDAO;
import com.niit.CollaborationBack.DAO.IForumDAO;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.BlogComment;
import com.niit.CollaborationBack.Model.Customer;
import com.niit.CollaborationBack.Model.Forum;

@RestController
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	IForumDAO forumdao;
	
	@Autowired
	ICustomerDAO customerdao;
	
	@PostMapping("/addforum")
	ResponseEntity<Void> addForum(@RequestBody Forum forum,HttpSession session)
	{
		
		
		if(forumdao.addForum(forum))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	}
	@SuppressWarnings("unused")
	@GetMapping("/selectoneforum")
	ResponseEntity<Forum> selectOneForum(@RequestParam ("forumid")int forumid)
	{
		Forum forum=forumdao.selectOneForum(forumid);
		
		if(forum==null)
		{
			
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}else
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.FOUND);
		}
	}
	@PutMapping("/updateforum")
	ResponseEntity<Void> UpdateForum(@RequestParam ("forumid")int forumid,@RequestBody Forum forum)
	{
		Forum newforum=forumdao.selectOneForum(forumid);
		newforum.setForum_Title(forum.getForum_Title());
		
		if(forumdao.updateForum(newforum))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	}
	@DeleteMapping("/deleteforum")
	ResponseEntity<Void> deleteMyForum(@RequestParam ("forumid")int forumid)
	{
		Forum forum=forumdao.selectOneForum(forumid);
		
		if(forumdao.deleteForum(forum))
		{
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/allforums")
	ResponseEntity<List<Forum>> selectAllForum(@RequestParam("forumid")int forumid)
	{
		Forum forum=forumdao.selectOneForum(forumid);
		ArrayList<Forum> forumlist=forumdao.selectAllForum(forum);
		if(forumlist.isEmpty())
		{
			return new ResponseEntity<List<Forum>>(HttpStatus.NOT_FOUND);
		}
		else {
			
			return new ResponseEntity<List<Forum>>(forumlist,HttpStatus.FOUND);
		}
	}
}
