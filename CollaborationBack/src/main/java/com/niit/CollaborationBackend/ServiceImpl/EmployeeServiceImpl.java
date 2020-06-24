package com.niit.CollaborationBackend.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Collaboration.DAO.IAppliedJobsDAO;
import com.niit.Collaboration.DAO.IBlogCommentDAO;
import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.DAO.ICustomerDAO;
import com.niit.Collaboration.DAO.IForumAnswerDAO;
import com.niit.Collaboration.DAO.IForumDAO;
import com.niit.Collaboration.DAO.IJobsDAO;
import com.niit.Collaboration.Model.AppliedJobs;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Jobs;
import com.niit.CollaborationBackend.ServiceDAO.IEmployeeServiceDAO;
@Service
public class EmployeeServiceImpl implements IEmployeeServiceDAO {

	@Autowired
	IBlogDAO blogdao;
	
	@Autowired
	IBlogCommentDAO blogcommentdao;
	
	@Autowired
	IForumAnswerDAO forumanswerdao;
	
	@Autowired
	IJobsDAO jobsdao;
	
	@Autowired
	IAppliedJobsDAO appliedjobsdao;
	
	@Autowired
	IForumDAO forumdao;
	
	ICustomerDAO customerdao;
	
	@Override
	public Blog selectOneBlog(int blogid) {
	
		return blogdao.selectOneBlog(blogid);
	}

	@Override
	public ArrayList<Blog> selectApprovedBlogs() {
		
		return blogdao.selectApprovedBlogs();
	}

	@Override
	public Forum selectOneForum(int forum_Id) {
		
		return forumdao.selectOneForum(forum_Id);
	}

	@Override
	public boolean addBlogComment(BlogComment b) {
		
		return blogcommentdao.addBlogComment(b);
	}

	@Override
	public boolean updateBlogComment(BlogComment b) {
		
		return blogcommentdao.updateBlogComment(b);
	}

	@Override
	public boolean deleteBlogComment(BlogComment b) {
		
		return blogcommentdao.deleteBlogComment(b);
	}

	@Override
	public ArrayList<BlogComment> selectAllComment(Blog blog) {
		
		return blogcommentdao.selectAllComment(blog);
	}

	@Override
	public BlogComment selectOneBlogComment(int blogcommentid) {
		
		return blogcommentdao.selectOneBlogComment(blogcommentid);
	}

	@Override
	public boolean addForumAnswer(ForumAnswer answer) {
		
		return forumanswerdao.addForumAnswer(answer);
	}

	@Override
	public boolean updateForumAnswer(ForumAnswer answer) {
		
		return forumanswerdao.updateForumAnswer(answer);
	}

	@Override
	public boolean deleteForumAnswer(ForumAnswer answer) {
		
		return forumanswerdao.deleteForumAnswer(answer);
	}

	@Override
	public ArrayList<ForumAnswer> allForumAnswer(Forum forum) {
		
		return forumanswerdao.allForumAnswer(forum);
	}

	@Override
	public ForumAnswer selectOneForumAnswer(int forumanswer_Id) {
		
		return forumanswerdao.selectOneForumAnswer(forumanswer_Id);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		
		return customerdao.addCustomer(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		
		return customerdao.updateCustomer(customer);
	}

	@Override
	public Customer selectCustomer(String emailid) {
		
		return customerdao.selectCustomer(emailid);
	}

	@Override
	public Jobs selectOneJobs(int Job_Id) {
		
		return jobsdao.selectOneJobs(Job_Id);
	}

	@Override
	public ArrayList<Jobs> selectApprovedJobs() {
		
		return jobsdao. selectApprovedJobs();
	}

	@Override
	public boolean AppliedJobs(AppliedJobs appliedjobs) {
		
		return appliedjobsdao.AppliedJobs(appliedjobs);
	}

	@Override
	public ArrayList<Jobs> selectAllJobOfOneUser(int cust_Id) {
		
		return jobsdao.selectAllJobsofOneUser(cust_Id);
	}

	@Override
	public ArrayList<AppliedJobs> myAppliedJobs(Customer customer) {
		
		return appliedjobsdao.myAppliedJobs(customer);
	}

}
