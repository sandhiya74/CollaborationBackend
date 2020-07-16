package com.niit.Collaboration.Service;

import java.util.ArrayList;

import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Job;

public interface IAdminService {
	public ArrayList<Blog> selectAllApporovedBlogs();

	public ArrayList<Blog> selectAllUnapporovedBlogs();

	public ArrayList<ForumAnswer> selectAllApporovedForumAnswer();

	public ArrayList<ForumAnswer> selectAllUnapporovedForumAnswer();

	public boolean addForum(Forum forum);

	public boolean updateForum(Forum forum);

	public boolean deleteForum(Forum forum);

	public ArrayList<Forum> selectallForum();

	public ArrayList<ForumAnswer> selectAllForumAnswer(Forum forum);

	public ArrayList<Job> selectAllApporovedJobs();

	public ArrayList<Job> selectAllUnapporovedJobs();

}