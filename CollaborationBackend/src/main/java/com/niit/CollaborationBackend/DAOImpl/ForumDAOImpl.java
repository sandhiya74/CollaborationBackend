package com.niit.CollaborationBackend.DAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.IForumDAO;

import com.niit.Collaboration.Model.Forum;
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

	@Override
	public ArrayList<Forum> allForum() {
		try {
			ArrayList<Forum> forumlist = (ArrayList<Forum>) sessionfactory.getCurrentSession()
					.createQuery("from Forum").list();
			return forumlist;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Forum selectOneForum(int forum_Id) {
		try
		{
			return (Forum) sessionfactory.getCurrentSession().createCriteria(Forum.class)
					.add(Restrictions.eq("forum_Id",forum_Id)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

}
