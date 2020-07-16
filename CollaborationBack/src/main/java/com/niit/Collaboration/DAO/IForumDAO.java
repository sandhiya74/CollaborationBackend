package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.Forum;

public interface IForumDAO {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public ArrayList<Forum> selectallForum();
	public Forum selectOneForum(int forum_Id);
}