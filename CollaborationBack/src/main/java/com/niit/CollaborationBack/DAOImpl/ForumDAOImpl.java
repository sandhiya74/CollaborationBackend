package com.niit.CollaborationBack.DAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBack.DAO.IForumDAO;
import com.niit.CollaborationBack.Model.BlogComment;
import com.niit.CollaborationBack.Model.Forum;
@Repository("forumdao")
@Transactional
public class ForumDAOImpl implements IForumDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addForum(Forum forum) {
		try
		{
			sessionfactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
		try
		{
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try
		{
			sessionfactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Forum> selectAllForum(Forum forum) {
		try {
			ArrayList<Forum> forumlist = (ArrayList<Forum>) sessionfactory.getCurrentSession()
					.createCriteria(Forum.class).add(Restrictions.eq("Forum",forum)).list();
			return forumlist;
		} catch (Exception e) {
			
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Forum selectOneForum(int forum_Id) {
		try
		{
			return (Forum) sessionfactory.getCurrentSession().createCriteria(Forum.class)
					.add(Restrictions.eq("forum_Id",forum_Id)).uniqueResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

}
