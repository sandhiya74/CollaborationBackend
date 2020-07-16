package com.niit.Collaboration.Service;

import java.util.ArrayList;

import com.niit.Collaboration.Model.AppliedJob;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Job;

public interface IEmployeeService {

	public ArrayList<Blog> selectAllApporovedBlogs();

	public Blog selectOneBlog(int blog_id);

	public Forum selectOneForum(int forum_Id);

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

	public ArrayList<Job> selectAllApporovedJobs();

	public Job selectOneJob(int jobid);

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public Customer selectCustomer(String cust_email);

	public boolean addAppliedJob(AppliedJob Appliedjob);

	public ArrayList<AppliedJob> selectmyAppliedJob(Customer customer);

	public AppliedJob selectOneAppliedJob(int appliedjob_Id);

}
