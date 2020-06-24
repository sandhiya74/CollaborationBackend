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
import com.niit.CollaborationBack.DAO.IForumAnswerDAO;
import com.niit.CollaborationBack.DAO.IForumDAO;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.BlogComment;
import com.niit.CollaborationBack.Model.Customer;
import com.niit.CollaborationBack.Model.Forum;
import com.niit.CollaborationBack.Model.ForumAnswer;

@RestController
@RequestMapping("/forumanswer")
public class ForumAnswerController {

	@Autowired
	IForumAnswerDAO forumanswerdao;
	
	@Autowired
	ICustomerDAO customerdao;
	
	@Autowired
	IForumDAO forumdao;
	

	@GetMapping("/adminapproval")
	ResponseEntity<List<ForumAnswer>> selectallUnApprovedanswers(HttpSession session) 
	{
		ArrayList<ForumAnswer> fanswerlist = forumanswerdao.selectUnapprovedanswer();
		if (fanswerlist.isEmpty()) {
			System.out.println("Error in if line");
			return new ResponseEntity<List<ForumAnswer>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<ForumAnswer>>(fanswerlist, HttpStatus.FOUND);
		}

	}
	@GetMapping("/updatestatus")
	ResponseEntity<Void> addMyForumAnswer(@RequestParam("forumanswers_Id")int id)
	{
		ForumAnswer forumanswer =forumanswerdao.selectOneForumAnswer(id);
		forumanswer.setForum_Status(true);
		
		if(forumanswerdao.updateForumAnswer(forumanswer))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PostMapping("/addforumanswer")
	ResponseEntity<Void> addForumAnswer(@RequestParam("forum_Id") int id, @RequestBody ForumAnswer forumanswer,
			HttpSession session) {
		Forum forum = forumdao.selectOneForum(id);
		Customer cust = (Customer) session.getAttribute("custdetails");
		forumanswer.setCustomer(cust);
		forumanswer.setPosted_Date(new Date());
		
		
		if (forumanswerdao.addForumAnswer(forumanswer)) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} 
		else {
			
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@PutMapping("/updateforumanswer")
	ResponseEntity<Void> updateForumAnswer(@RequestParam("forum_Id") int forumid,
			@RequestBody ForumAnswer forumanswer,HttpSession session) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		Forum forum = forumdao.selectOneForum(forumid);
		ForumAnswer newforumanswer = forumanswerdao.selectOneForumAnswer(forumid);
		newforumanswer.setForum(forum);
		newforumanswer.setForum_Status(false);
		newforumanswer.setCustomer(cust);
		newforumanswer.setForum_Answer(newforumanswer.getForum_Answer());
		newforumanswer.setPosted_Date(new Date());
		
		
		if (forumanswerdao.updateForumAnswer(newforumanswer)) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/allforumanswers")
	ResponseEntity<List<ForumAnswer>> selectallanswers(@RequestParam("forum_Id")int id) {
		Forum forumanswer= forumdao.selectOneForum(id);
	
		ArrayList<ForumAnswer> forumanswertlist = forumanswerdao.selectAllapprovedAnswers();

		if (forumanswertlist.isEmpty()) {
			
			return new ResponseEntity<List<ForumAnswer>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<ForumAnswer>>(forumanswertlist, HttpStatus.FOUND);
		}
	}

	@GetMapping("/selectoneanswer")
	ResponseEntity<ForumAnswer> selectOneanswer(@RequestParam("forumanswers_Id") int id) {
		
		ForumAnswer forumanswer =forumanswerdao.selectOneForumAnswer(id);
		if (forumanswer == null) {
		return new ResponseEntity<ForumAnswer>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ForumAnswer>(forumanswer, HttpStatus.FOUND);
	}
	}
	@DeleteMapping("/deleteforumanswer")
	ResponseEntity<Void> deleteanswer(@RequestParam("forumanswers_Id")int id)
	{
		
		ForumAnswer forumanswer =forumanswerdao.selectOneForumAnswer(id);
		if(forumanswerdao.deleteForumAnswer(forumanswer))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
