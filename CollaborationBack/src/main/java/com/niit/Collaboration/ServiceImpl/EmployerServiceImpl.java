package com.niit.Collaboration.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Collaboration.DAO.IAppliedJobDAO;
import com.niit.Collaboration.DAO.IBlogCommentDAO;
import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.DAO.ICustomerDAO;
import com.niit.Collaboration.DAO.IForumAnsDAO;
import com.niit.Collaboration.DAO.IJobDAO;
import com.niit.Collaboration.Model.AppliedJob;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Job;
import com.niit.Collaboration.Service.IEmployerService;
@Service
public class EmployerServiceImpl implements IEmployerService {
	@Autowired
	IBlogDAO blogdao;
	
	IForumAnsDAO forumansdao;
	IBlogCommentDAO blogcommentdao;
	IJobDAO jobdao;
	IAppliedJobDAO appliedjobdao;
	ICustomerDAO customerdao;
	@Override
	public boolean addBlog(Blog blog) {

		return blogdao.addBlog(blog);
	}

	@Override
	public boolean updateBlog(Blog blog) {
		
		return blogdao.updateBlog(blog);
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		
		return blogdao.deleteBlog(blog);
	}

	@Override
	public ArrayList<Blog> selectAllApporovedBlogs() {

		return blogdao.selectAllApporovedBlogs();
	}

	@Override
	public ArrayList<Blog> selectAllBlogOfOneUser(Customer cust) {

		return blogdao.selectAllUnapporovedBlogs();
	}

	@Override
	public boolean addBlogComment(BlogComment blog) {

		return blogcommentdao.addBlogComment(blog);
	}

	@Override
	public boolean updateBlogComment(BlogComment blog) {
		
		return blogcommentdao.updateBlogComment(blog);
	}

	@Override
	public boolean deleteBlogComment(BlogComment blog) {
		
		return blogcommentdao.deleteBlogComment(blog);
	}

	@Override
	public ArrayList<BlogComment> selectAllComments(Blog blog) {
		
		return null;
	}

	@Override
	public BlogComment selectOneBlogComment(int blogcomment_Id) {
		
		return blogcommentdao.selectOneBlogComment(blogcomment_Id);
	}

	@Override
	public boolean addForumAnswer(ForumAnswer forum) {
	
		return forumansdao.addForumAnswer(forum);
	}

	@Override
	public boolean updateForumAnswer(ForumAnswer forum) {
		
		return forumansdao.updateForumAnswer(forum);
	}

	@Override
	public boolean deleteForumAnswer(ForumAnswer forum) {
		
		return forumansdao.deleteForumAnswer(forum);
	}

//	@Override
//	public ArrayList<ForumAnswer> selectAllForumAnswer(Forum forum) {
//		
//		return forumansdao.selectAllForumAnswer(forum);
//	}

	@Override
	public ForumAnswer selectOneForumAnswer(int forumans_Id) {
	
		return forumansdao.selectOneForumAnswer(forumans_Id);
	}

	@Override
	public boolean addJob(Job job) {
		
		return jobdao.addJob(job);
	}

	@Override
	public boolean updateJob(Job job) {
	
		return jobdao.updateJob(job);
	}

	@Override
	public boolean deleteJob(Job job) {
		
		return jobdao.deleteJob(job);
	}

	@Override
	public ArrayList<Job> selectAllJobOfOneUser(Customer cust) {
		
		return jobdao.selectAllJobOfOneUser(cust);
	}

	@Override
	public ArrayList<AppliedJob> selectAllAppliedJob(Job job) {
		
		return appliedjobdao.selectAllAppliedJob(job);
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
	public Customer selectCustomer(String cust_email) {
		
		return customerdao.selectCustomer(cust_email);
	}

	@Override
	public ArrayList<ForumAnswer> selectAllForumAnswer(Forum forum) {
		// TODO Auto-generated method stub
		return null;
	}

}
