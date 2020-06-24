package com.niit.CollaborationBack.DAO;

import java.util.ArrayList;

import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.BlogComment;

public interface IBlogCommentDAO {

	public boolean addBlogComment(BlogComment b);
    
	 public boolean updateBlogComment(BlogComment b);
	
	public boolean deleteBlogComment(BlogComment b);
	 
   public ArrayList<BlogComment>selectAllComment(Blog blog);
	
   public BlogComment selectOneBlogComment(int blogcommentid);

}
