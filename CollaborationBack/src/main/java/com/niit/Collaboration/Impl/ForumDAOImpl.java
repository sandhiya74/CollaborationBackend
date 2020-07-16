package com.niit.Collaboration.Impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.IForumDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Forum;
@Repository("forumdao")
@Transactional
public class ForumDAOImpl implements IForumDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean addForum(Forum forum) {
		try {
			
			sessionfactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
try {
			
			sessionfactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean deleteForum(Forum forum) {
try {
			
			sessionfactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Forum> selectallForum() {
		try {
			 return (ArrayList<Forum>)  sessionfactory.getCurrentSession()
					.createQuery("from Forum").list();
		
		} catch (Exception e) { 
			return null;
			}
	}

	@Override
	public Forum selectOneForum(int forum_Id) {
		try {
			 return ( Forum) sessionfactory.getCurrentSession()
					.createCriteria(Forum.class).add(Restrictions.eq("forum_Id", forum_Id)).uniqueResult();
		
		} catch (Exception e) {
			return null;
			}

}
}