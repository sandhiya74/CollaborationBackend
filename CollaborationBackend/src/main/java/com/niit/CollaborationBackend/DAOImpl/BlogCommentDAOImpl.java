package com.niit.CollaborationBackend.DAOImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Collaboration.DAO.IBlogCommentDAO;
import com.niit.Collaboration.Model.AppliedJobs;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
import com.niit.Collaboration.Model.Jobs;


@Repository("blogcommentdao")
@Transactional
public class BlogCommentDAOImpl implements IBlogCommentDAO {

	
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addBlogComment(BlogComment b) {
		try
		{
			sessionfactory.getCurrentSession().save(b);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateBlogComment(BlogComment b) {
		try
		{
			sessionfactory.getCurrentSession().update(b);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteBlogComment(BlogComment b) {
		 try
		{
			sessionfactory.getCurrentSession().delete(b);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	  public ArrayList<BlogComment>selectAllComment(Blog blog){
		try {
			ArrayList<BlogComment> jobslist = (ArrayList<BlogComment>) sessionfactory.getCurrentSession()
					.createCriteria(BlogComment.class).add(Restrictions.eq("Blog",blog)).list();
			return jobslist;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public BlogComment selectOneBlogComment(int blogcommentid) {
		try
		{
			return (BlogComment) sessionfactory.getCurrentSession().createCriteria(BlogComment.class)
					.add(Restrictions.eq("blogcomment_Id",blogcommentid)).list();
		}
		catch(Exception e)
		{
		return null;
		}
		
	}

}
