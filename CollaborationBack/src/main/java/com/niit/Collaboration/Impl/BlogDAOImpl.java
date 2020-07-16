package com.niit.Collaboration.Impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Customer;
@Repository("blogdao")
@Transactional
public class BlogDAOImpl implements IBlogDAO {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addBlog(Blog blog) {
		try {
		
			sessionfactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try {
			
			sessionfactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
		}

	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			
			sessionfactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
		}

	@Override
	public ArrayList<Blog> selectAllApporovedBlogs() {
		try {
			 return (ArrayList<Blog>) sessionfactory.getCurrentSession()
					.createCriteria(Blog.class).add(Restrictions.eq("status",true)).list();
		
		} catch (Exception e) {
			return null;
			}
	}
	

	@Override
	public ArrayList<Blog> selectAllBlogOfOneUser(Customer cust) {
		try {
			 return (ArrayList<Blog>) sessionfactory.getCurrentSession()
					.createCriteria(Blog.class).add(Restrictions.eq("customer",cust)).list();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
			}
		}

	@Override
	public ArrayList<Blog> selectAllUnapporovedBlogs() {
		try {
			 return (ArrayList<Blog>) sessionfactory.getCurrentSession()
					.createCriteria(Blog.class).add(Restrictions.eq("status",false)).list();
		
		} catch (Exception e) {
			return null;
			}
	}

	@Override
	public Blog selectOneBlog(int blog_id) {
		try {
			 return (Blog) sessionfactory.getCurrentSession()
					.createCriteria(Blog.class).add(Restrictions.eq("blog_Id",blog_id)).uniqueResult();
		
		} catch (Exception e) {
			return null;
			}

	}
	}