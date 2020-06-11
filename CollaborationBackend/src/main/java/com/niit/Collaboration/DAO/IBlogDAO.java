package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.Blog;

public interface IBlogDAO {
	
    public boolean addBlog(Blog blog);
	
	public boolean updateBlog(Blog blog);
	
	public boolean deleteBlog(Blog blog);
	 
	public ArrayList<Blog>selectApprovedBlogs();
	
	public ArrayList<Blog>selectAllBlogofOneUser(int cust_Id);
	
	public ArrayList<Blog>selectAllUnapprovedBlogs();
	
	public Blog selectOneBlog(int blogid);

}
