package com.niit.Collaboration.Impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.IBlogCommentDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.BlogComment;
@Repository("blogcommentdao")
@Transactional
public class BlogCommentDAOImpl implements IBlogCommentDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean addBlogComment(BlogComment blog) {
		try {
			
			sessionfactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBlogComment(BlogComment blog) {
		try {
			
			sessionfactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteBlogComment(BlogComment blog) {
		try {
			
			sessionfactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

	@Override
	public ArrayList<BlogComment> selectAllComments(Blog blog) {
		try {
			 return (ArrayList<BlogComment>)  sessionfactory.getCurrentSession()
					 .createCriteria(BlogComment.class).add(Restrictions.eq("blog",blog)).list();
		
		} catch (Exception e) {
			return null;
			}
	}

	@Override
	public BlogComment selectOneBlogComment(int blogcomment_Id) {
		try {
			 return (BlogComment) sessionfactory.getCurrentSession()
					.createCriteria(BlogComment.class).add(Restrictions.eq("blogcomment_Id",blogcomment_Id)).uniqueResult();
		
		} catch (Exception e) {
			return null;
			}
	}
}
