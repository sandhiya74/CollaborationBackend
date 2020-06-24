package com.niit.CollaborationBack.DAO;

import java.util.ArrayList;

import com.niit.CollaborationBack.Model.Forum;

public interface IForumDAO {

public boolean addForum(Forum forum);
	
	public boolean updateForum(Forum forum);
	
	public boolean deleteForum(Forum forum);
	
	public ArrayList<Forum> selectAllForum(Forum forum);
	
	public Forum selectOneForum(int forum_Id);
	
}
