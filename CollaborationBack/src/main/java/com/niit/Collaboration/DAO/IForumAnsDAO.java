package com.niit.Collaboration.DAO;

import java.util.ArrayList;


import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;

public interface IForumAnsDAO {
	public boolean addForumAnswer(ForumAnswer forum);
	public boolean updateForumAnswer(ForumAnswer forum);
	public boolean deleteForumAnswer(ForumAnswer forum);
	public ArrayList<ForumAnswer> selectAllUnapporovedForumAnswer();
	public ArrayList<ForumAnswer> selectAllApporovedForumAnswer();
	//public ArrayList<ForumAnswer>selectAllForumAnswer(Forum forum);
	 public ForumAnswer selectOneForumAnswer(int forumans_Id);
}