package com.niit.CollaborationBack.DAO;
import java.util.ArrayList;

import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.Customer;

public interface IBlogDAO {
	
    public boolean addBlog(Blog blog);
	
	public boolean updateBlog(Blog blog);
	
	public boolean deleteBlog(Blog blog);
	 
	public ArrayList<Blog>selectApprovedBlogs();
	
	public ArrayList<Blog>selectAllBlogofOneUser(Customer cust);
	
	public ArrayList<Blog>selectAllUnapprovedBlogs();
	
	public Blog selectOneBlog(int blogid);

	public ArrayList<Blog> selectAllBlog();
}
