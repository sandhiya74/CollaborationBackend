package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;

public interface IForumAnswerDAO {

	public boolean addForumAnswer(ForumAnswer answer);
	
	public boolean updateForumAnswer(ForumAnswer answer);
	
	public boolean deleteForumAnswer(ForumAnswer answer);
	
    public ArrayList<ForumAnswer>allForumAnswer(Forum forum);
	
	public ForumAnswer selectOneForumAnswer(int forumanswer_Id);
	
}
