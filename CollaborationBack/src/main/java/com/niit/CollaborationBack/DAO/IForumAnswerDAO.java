package com.niit.CollaborationBack.DAO;

import java.util.ArrayList;

import com.niit.CollaborationBack.Model.Forum;
import com.niit.CollaborationBack.Model.ForumAnswer;

public interface IForumAnswerDAO {

public boolean addForumAnswer(ForumAnswer answer);
	
	public boolean updateForumAnswer(ForumAnswer answer);
	
	public boolean deleteForumAnswer(ForumAnswer answer);
	
    public ArrayList<ForumAnswer>allForumAnswer(Forum forum);
	
	public ForumAnswer selectOneForumAnswer(int forumanswer_Id);

	public ArrayList<ForumAnswer> selectUnapprovedanswer();
	ArrayList<ForumAnswer> selectAllapprovedAnswers();
}
