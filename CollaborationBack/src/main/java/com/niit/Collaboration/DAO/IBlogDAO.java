package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Customer;

public interface IBlogDAO {
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public ArrayList<Blog> selectAllApporovedBlogs();
	public ArrayList<Blog> selectAllBlogOfOneUser(Customer cust);
	public ArrayList<Blog> selectAllUnapporovedBlogs();
	public Blog selectOneBlog(int blog_Id);
}