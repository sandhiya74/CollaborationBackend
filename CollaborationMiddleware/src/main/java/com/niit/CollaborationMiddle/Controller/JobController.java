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

import com.niit.Collaboration.DAO.IJobDAO;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Job;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
	
	

		@Autowired
		IJobDAO jobdao;
		
		@GetMapping("/adminapproval")
		ResponseEntity<List <Job>> selectUnApprovedJob(HttpSession session)
		{
			ArrayList<Job> joblist=jobdao.selectAllUnapporovedJobs();
			if (joblist.isEmpty())
			{
				return new ResponseEntity<List<Job>>(HttpStatus.NOT_FOUND);
			}
			else
			{
				return new ResponseEntity<List<Job>>(joblist,HttpStatus.FOUND);
			}	
		}
		@GetMapping("/alljobs")
		ResponseEntity<List<Job>> selectApprovedJobs(HttpSession session)
		{
			ArrayList<Job> joblist=jobdao.selectAllApporovedJobs();
			if(joblist.isEmpty())
			{
				return new ResponseEntity<List<Job>>(HttpStatus.NOT_FOUND);
			}
			else
			{
				return new ResponseEntity<List<Job>>(joblist,HttpStatus.FOUND);
			}	
		}
		@GetMapping("/myjobs")
		ResponseEntity<List<Job>> selectMyJobs(HttpSession session)
		{
			System.out.println("line 1");
			Customer cust=(Customer)session.getAttribute("custdetails");
			ArrayList<Job> joblist=jobdao.selectAllJobOfOneUser(cust);
			if(joblist.isEmpty())
			{
				System.out.println("line 2");
				return new ResponseEntity<List<Job>>(HttpStatus.NOT_FOUND);
			}
			else
			{
				System.out.println("line 3");
				return new ResponseEntity<List<Job>>(joblist,HttpStatus.FOUND);
			}	
		}
		@GetMapping("/selectonejob")
		ResponseEntity<Job> selectOneJob(@RequestParam("job_Id")int jobid)
		{
			Job job=jobdao.selectOneJob(jobid);
			if(job==null)
			{
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}
			else
			{
				return new ResponseEntity<Job>(job,HttpStatus.FOUND);
			}	
		}
		@PostMapping("/addjob")
		ResponseEntity<Void> addMyJob(@RequestBody Job job,HttpSession session)
		{
			Customer cust=(Customer)session.getAttribute("custdetails");
			job.setCustomer(cust);
			
			job.setPosted_Date(new Date());
		
			if(jobdao.addJob(job))
			{
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
			}
			else
			{
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
	
		@GetMapping("/updatejobstatus")
		ResponseEntity<Void> addMyJob(@RequestParam("job_Id")int id)
		{
			Job job=jobdao.selectOneJob(id);
			job.setJob_Status(true);
			if(jobdao.updateJob(job))
			{
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
			}
			else
			{
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		@PutMapping("/updatejob")
		ResponseEntity<Void> updateMyJob(@RequestParam("job_Id")int jobid,@RequestBody Job job)
		{
			Job newjob=jobdao.selectOneJob(jobid);
			newjob.setJob_Title(job.getJob_Title());
			newjob.setVacancy(job.getVacancy());
			newjob.setSkillset(job.getSkillset());
			newjob.setSalary(job.getSalary());
			newjob.setJob_Description(job.getJob_Description());
			newjob.setJob_Status(false);
			newjob.setPosted_Date(new Date());
		newjob.setLast_Date(job.getLast_Date());
			if(jobdao.updateJob(newjob))
			{
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
			}
			else
			{
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		@DeleteMapping("deletejob")
		ResponseEntity<Void> deleteMyJob(@RequestParam("job_Id")int jobid)
		{
		Job job=jobdao.selectOneJob(jobid);
			if(jobdao.deleteJob(job))
			{
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);			
			}
			else
			{
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
 }