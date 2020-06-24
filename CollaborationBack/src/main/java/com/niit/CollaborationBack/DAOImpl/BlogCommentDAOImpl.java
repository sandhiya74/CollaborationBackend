package com.niit.CollaborationBack.DAOImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBack.DAO.IBlogCommentDAO;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.BlogComment;

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

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	  public ArrayList<BlogComment>selectAllComment(Blog blog){
		try {
			ArrayList<BlogComment> commentlist = (ArrayList<BlogComment>) sessionfactory.getCurrentSession()
					.createCriteria(BlogComment.class).add(Restrictions.eq("Blog",blog)).list();
			return commentlist;
		} catch (Exception e) {
			return null;
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlogComment selectOneBlogComment(int blogcommentid) {
		try
		{
			return (BlogComment) sessionfactory.getCurrentSession().createCriteria(BlogComment.class)
					.add(Restrictions.eq("blog_Commentid",blogcommentid)).uniqueResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		return null;
		}
		
	}

}
