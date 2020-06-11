package com.niit.CollaborationBackend.ServiceDAO;

import java.util.ArrayList;


import com.niit.Collaboration.Model.Blog;

import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Jobs;
public interface IAdminServiceDAO {

    public ArrayList<Blog>selectApprovedBlogs();
	
	public ArrayList<Blog>selectAllUnapprovedBlogs();
	
	
    public boolean addForum(Forum forum);
	
	public boolean updateForum(Forum forum);
	
	public boolean deleteForum(Forum forum);
	
	public ArrayList<Forum> allForum();
	
	public ArrayList<ForumAnswer>allForumAnswer(Forum forum);
	
	public ArrayList<Jobs>selectApprovedJobs();
	
	public ArrayList<Jobs>selectUnApprovedJobs();
}
