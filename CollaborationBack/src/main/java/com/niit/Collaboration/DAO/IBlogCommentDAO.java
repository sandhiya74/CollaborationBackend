package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;

public interface IBlogCommentDAO {
	public boolean addBlogComment(BlogComment blog);
	public boolean updateBlogComment(BlogComment blog);
	public boolean deleteBlogComment(BlogComment blog);
	public ArrayList<BlogComment> selectAllComments(Blog blog);
	 public BlogComment selectOneBlogComment(int blogcomment_Id);

}