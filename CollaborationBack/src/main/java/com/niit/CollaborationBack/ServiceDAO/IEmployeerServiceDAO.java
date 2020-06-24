package com.niit.CollaborationBack.ServiceDAO;
import java.util.ArrayList;

import com.niit.CollaborationBack.Model.AppliedJobs;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.BlogComment;
import com.niit.CollaborationBack.Model.Customer;
import com.niit.CollaborationBack.Model.Forum;
import com.niit.CollaborationBack.Model.ForumAnswer;
import com.niit.CollaborationBack.Model.Jobs;
public interface IEmployeerServiceDAO {
	
	public boolean addBlog(Blog blog);

	public boolean updateBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public ArrayList<Blog> selectAllApprovedBlogs();
	
	ArrayList<Blog> selectAllBlogofOneUser(Customer cust);
	
	

	public boolean addBlogComment(BlogComment b);

	public boolean updateBlogComment(BlogComment b);

	public boolean deleteBlogComment(BlogComment b);
	
	public ArrayList<BlogComment>selectAllComment(Blog blog);
	
    public BlogComment selectOneBlogComment(int blogcommentid);
	
	

    public boolean addForumAnswer(ForumAnswer answer);
	
	public boolean updateForumAnswer(ForumAnswer answer);
	
	public boolean deleteForumAnswer(ForumAnswer answer);
	
    public ArrayList<ForumAnswer>allForumAnswer(Forum forum);
	
	public ForumAnswer selectOneForumAnswer(int forumanswer_Id);
	
	
    public boolean addJobs(Jobs jobs);
		
	public boolean updateJobs(Jobs jobs);
		
	public boolean deleteJobs(Jobs jobs);
	
	public ArrayList<Jobs> selectAllJobOfOneUser(int cust_Id);
	
	
	public ArrayList<AppliedJobs> selectAllAppliedJobs(Jobs jobs);
	
	
    public boolean addCustomer(Customer customer);
	
	public boolean updateCustomer(Customer customer);
	
    public Customer selectCustomer(String emailid);

	

}
