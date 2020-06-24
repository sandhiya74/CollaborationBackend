package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;

public interface IBlogCommentDAO {
	
	 public boolean addBlogComment(BlogComment b);
     
	 public boolean updateBlogComment(BlogComment b);
	
	public boolean deleteBlogComment(BlogComment b);
	 
    public ArrayList<BlogComment>selectAllComment(Blog blog);
	
    public BlogComment selectOneBlogComment(int blogcommentid);


}
