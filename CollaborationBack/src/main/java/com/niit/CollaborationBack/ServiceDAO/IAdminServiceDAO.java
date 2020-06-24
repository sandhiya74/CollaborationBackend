package com.niit.CollaborationBack.ServiceDAO;

import java.util.ArrayList;

import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.Forum;
import com.niit.CollaborationBack.Model.ForumAnswer;
import com.niit.CollaborationBack.Model.Jobs;
public interface IAdminServiceDAO {

    public ArrayList<Blog>selectApprovedBlogs();
	
	public ArrayList<Blog>selectAllUnapprovedBlogs();
	
	
    public boolean addForum(Forum forum);
	
	public boolean updateForum(Forum forum);
	
	public boolean deleteForum(Forum forum);
	
	public ArrayList<Forum> selectAllForum(Forum forum);
	
	public ArrayList<ForumAnswer>allForumAnswer(Forum forum);
	
	public ArrayList<Jobs>selectApprovedJobs();
	
	public ArrayList<Jobs>selectUnApprovedJobs();

	
}
