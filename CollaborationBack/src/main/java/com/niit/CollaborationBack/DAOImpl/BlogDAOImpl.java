package com.niit.CollaborationBack.DAOImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBack.DAO.IBlogDAO;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.Customer;

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

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<Blog> selectApprovedBlogs() {
		try
		{
			return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("blog_Status",true)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<Blog>selectAllBlogofOneUser(Customer cust) {
		try
		{
			return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("Customer",cust)).list();
		}
		catch(Exception e)
		{
		 System.out.println(e.getMessage());
		return null;
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<Blog> selectAllUnapprovedBlogs() {
		try
		{
			return (ArrayList<Blog>) sessionfactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("blog_Status",false)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Blog selectOneBlog(int blogid) {
		try
		{
			return (Blog) sessionfactory.getCurrentSession().createCriteria(Blog.class)
					.add(Restrictions.eq("blog_Id",blogid)).uniqueResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<Blog> selectAllBlog() {
		try
		  {
			  ArrayList<Blog> blog= (ArrayList<Blog>)sessionfactory.getCurrentSession()
					  .createCriteria(Blog.class).list();
			  return blog;
		  }
		  catch(Exception e) {
			  
		  
			return null;
		}
	}

}
