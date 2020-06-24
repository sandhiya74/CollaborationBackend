package com.niit.CollaborationBack.DAOImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBack.DAO.IForumAnswerDAO;
import com.niit.CollaborationBack.Model.Forum;
import com.niit.CollaborationBack.Model.ForumAnswer;

@Repository("forumanswerdao")
@Transactional
public class ForumAnswerDAOImpl implements IForumAnswerDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	
	@Override
	public boolean addForumAnswer(ForumAnswer answer) {
		try
		{
			sessionfactory.getCurrentSession().save(answer);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean updateForumAnswer(ForumAnswer answer) {
		try
		{
			sessionfactory.getCurrentSession().update(answer);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean deleteForumAnswer(ForumAnswer answer) {
		try
		{
			sessionfactory.getCurrentSession().delete(answer);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<ForumAnswer>allForumAnswer(Forum forum) {
		try {
			ArrayList<ForumAnswer> jobslist = (ArrayList<ForumAnswer>) sessionfactory.getCurrentSession()
					.createCriteria(ForumAnswer.class).add(Restrictions.eq("Forum",forum)).list();
			return jobslist;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public ForumAnswer selectOneForumAnswer(int forumanswer_Id) {
		try
		{
			return (ForumAnswer) sessionfactory.getCurrentSession().createCriteria(Forum.class)
					.add(Restrictions.eq("answer_Id",forumanswer_Id)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public ArrayList<ForumAnswer> selectUnapprovedanswer() {
		try
	     {
	     return (ArrayList<ForumAnswer>) sessionfactory.getCurrentSession().createCriteria (ForumAnswer.class).
	    		  add(Restrictions.eq("forum_Status",false)).list();
	     }
		catch(Exception e) {
	      System.out.println(e.getMessage());
	      return null;
	     }
	
	}

	@Override
	public ArrayList<ForumAnswer> selectAllapprovedAnswers() {
		try
	     {
			
	     return (ArrayList<ForumAnswer>) sessionfactory.getCurrentSession().createCriteria (ForumAnswer.class).
	    		  add(Restrictions.eq("forum_Status",true)).list();
	     }
		catch(Exception e) {
			System.out.println(e.getMessage());
	      return null;
	     }
	}

}
