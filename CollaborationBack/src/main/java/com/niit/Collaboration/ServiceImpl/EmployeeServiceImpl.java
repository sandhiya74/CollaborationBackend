package com.niit.Collaboration.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Collaboration.DAO.IAppliedJobDAO;
import com.niit.Collaboration.DAO.IBlogCommentDAO;
import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.DAO.ICustomerDAO;
import com.niit.Collaboration.DAO.IForumAnsDAO;
import com.niit.Collaboration.DAO.IForumDAO;
import com.niit.Collaboration.DAO.IJobDAO;
import com.niit.Collaboration.Model.AppliedJob;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Job;
import com.niit.Collaboration.Service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	IBlogDAO blogdao;
	IForumDAO forumdao;
	IForumAnsDAO forumansdao;
	IBlogCommentDAO blogcommentdao;
	IJobDAO jobdao;
	IAppliedJobDAO appliedjobdao;
	ICustomerDAO customerdao;
	@Override
	public ArrayList<Blog> selectAllApporovedBlogs() {
		
		return blogdao.selectAllApporovedBlogs();
	}

	@Override
	public Blog selectOneBlog(int blog_id) {
		
		return blogdao.selectOneBlog(blog_id);
	}

	@Override
	public Forum selectOneForum(int forum_Id) {
	
		return forumdao.selectOneForum(forum_Id);
	}

	@Override
	public boolean addBlogComment(BlogComment blog) {
		
		return blogcommentdao.addBlogComment(blog);
	}

	@Override
	public boolean updateBlogComment(BlogComment blog) {
		
		return blogcommentdao.updateBlogComment(blog) ;
	}

	@Override
	public boolean deleteBlogComment(BlogComment blog) {
		
		return blogcommentdao.deleteBlogComment(blog);
	}

	@Override
	public ArrayList<BlogComment> selectAllComments(Blog blog) {
		
		return blogcommentdao.selectAllComments(blog);
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
	public ArrayList<Job> selectAllApporovedJobs() {
		
		return jobdao.selectAllApporovedJobs();
	}

	@Override
	public Job selectOneJob(int jobid) {
		
		return jobdao.selectOneJob(jobid);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		
		return customerdao.addCustomer(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		
		return  customerdao.updateCustomer(customer);
	}

	@Override
	public Customer selectCustomer(String cust_email) {
		
		return customerdao.selectCustomer(cust_email);
	}

	@Override
	public boolean addAppliedJob(AppliedJob Appliedjob) {
		
		return appliedjobdao.addAppliedJob(Appliedjob);
	}

	@Override
	public ArrayList<AppliedJob> selectmyAppliedJob(Customer customer) {
		
		return  appliedjobdao.selectmyAppliedJob(customer);
	}

	@Override
	public AppliedJob selectOneAppliedJob(int appliedjob_Id) {
		
		return  appliedjobdao.selectOneAppliedJob(appliedjob_Id);
	}

	@Override
	public ArrayList<ForumAnswer> selectAllForumAnswer(Forum forum) {
		// TODO Auto-generated method stub
		return null;
	}

}
