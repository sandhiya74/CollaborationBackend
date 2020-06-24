package com.niit.CollaborationBackend.DAOImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.Model.Blog;

@Repository("blogdao")
@Transactional
public class BlogDAOImpl implements IBlogDAO {
	
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean addBlog(Blog blog) {
		try
		{
			sessionfactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		
		try
		{
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		
		try
		{
			sessionfactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Blog> selectApprovedBlogs() {
		try
		{
			return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("status",true)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public ArrayList<Blog> selectAllBlogofOneUser(int cust_Id) {
		try
		{
			return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("customer",cust_Id)).list();
		}
		catch(Exception e)
		{
		return null;
		}
		
	}

	@Override
	public ArrayList<Blog> selectAllUnapprovedBlogs() {
		try
		{
			return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("status",false)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public Blog selectOneBlog(int blogid) {
		try
		{
			return (Blog) sessionfactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("blog_Id",blogid)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

}
