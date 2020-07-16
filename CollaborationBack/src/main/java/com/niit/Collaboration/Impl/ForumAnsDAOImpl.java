package com.niit.Collaboration.Impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.IForumAnsDAO;

import com.niit.Collaboration.Model.ForumAnswer;
@Repository("forumansdao")
@Transactional
public class ForumAnsDAOImpl implements IForumAnsDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean addForumAnswer(ForumAnswer forum) {
		
			try {
				
				sessionfactory.getCurrentSession().save(forum);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	@Override
	public boolean updateForumAnswer(ForumAnswer forum) {
		try {
			
			sessionfactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteForumAnswer(ForumAnswer forum) {
try {
			
			sessionfactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//	@Override
//	public ArrayList<ForumAnswer>selectAllForumAnswer(Forum forum) {
//		try {
//			 return (ArrayList<ForumAnswer>)  sessionfactory.getCurrentSession()
//					 .createCriteria(ForumAnswer.class).add(Restrictions.eq("forum",forum)).list();
//		
//		} catch (Exception e) {
//			return null;
//			}
//	}
	@Override
	public ArrayList<ForumAnswer> selectAllUnapporovedForumAnswer() {
		try {
			 return (ArrayList<ForumAnswer>) sessionfactory.getCurrentSession()
					.createCriteria(ForumAnswer.class).add(Restrictions.eq("forum_Status",false)).list();
		
		} catch (Exception e) {
			return null;
			}
	}
	@Override
	public ArrayList<ForumAnswer> selectAllApporovedForumAnswer() {
		try {
			 return (ArrayList<ForumAnswer>) sessionfactory.getCurrentSession()
					.createCriteria(ForumAnswer.class).add(Restrictions.eq("forum_Status",true)).list();
		
		} catch (Exception e) {
			return null;
			}
	}

	@Override
	public ForumAnswer selectOneForumAnswer(int forumans_Id) {
		try {
			 return (ForumAnswer) sessionfactory.getCurrentSession()
					.createCriteria(ForumAnswer.class).add(Restrictions.eq("forumans_Id",forumans_Id)).uniqueResult();
		
		} catch (Exception e) {
			return null;
			}
}
}