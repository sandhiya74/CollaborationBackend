package com.niit.Collaboration.Service;

import java.util.ArrayList;

import com.niit.Collaboration.Model.AppliedJob;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Job;

public interface IEmployerService {
	public boolean addBlog(Blog blog);

	public boolean updateBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public ArrayList<Blog> selectAllApporovedBlogs();

	public ArrayList<Blog> selectAllBlogOfOneUser(Customer cust);

	public boolean addBlogComment(BlogComment blog);

	public boolean updateBlogComment(BlogComment blog);

	public boolean deleteBlogComment(BlogComment blog);

	public ArrayList<BlogComment> selectAllComments(Blog blog);

	public BlogComment selectOneBlogComment(int blogcomment_Id);

	public boolean addForumAnswer(ForumAnswer forum);

	public boolean updateForumAnswer(ForumAnswer forum);

	public boolean deleteForumAnswer(ForumAnswer forum);

	public ArrayList<ForumAnswer> selectAllForumAnswer(Forum forum);

	public ForumAnswer selectOneForumAnswer(int forumans_Id);

	public boolean addJob(Job job);

	public boolean updateJob(Job job);

	public boolean deleteJob(Job job);

	public ArrayList<Job> selectAllJobOfOneUser(Customer cust);

	public ArrayList<AppliedJob> selectAllAppliedJob(Job job);

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public Customer selectCustomer(String cust_email);

}
