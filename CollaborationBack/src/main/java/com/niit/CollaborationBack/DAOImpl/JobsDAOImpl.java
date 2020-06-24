package com.niit.CollaborationBack.DAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBack.DAO.IJobsDAO;
import com.niit.CollaborationBack.Model.Jobs;

@Repository("jobsdao")
@Transactional
public class JobsDAOImpl implements IJobsDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addJobs(Jobs jobs) {
		try
		{
			sessionfactory.getCurrentSession().save(jobs);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean updateJobs(Jobs jobs) {
		try
		{
			sessionfactory.getCurrentSession().update(jobs);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean deleteJobs(Jobs jobs) {
		try
		{
			sessionfactory.getCurrentSession().delete(jobs);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<Jobs> selectApprovedJobs() {
		try
		{
			return (ArrayList<Jobs>) sessionfactory.getCurrentSession().createCriteria(Jobs.class)
					.add(Restrictions.eq("status",true)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<Jobs> selectAllJobsofOneUser(int cust_Id) {
		try
		{
			return (ArrayList<Jobs>) sessionfactory.getCurrentSession().createCriteria(Jobs.class)
					.add(Restrictions.eq("customer",cust_Id)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<Jobs> selectUnApprovedJobs() {
		try
		{
			return (ArrayList<Jobs>) sessionfactory.getCurrentSession().createCriteria(Jobs.class)
					.add(Restrictions.eq("status",false)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Jobs selectOneJobs(int Job_Id) {
		try
		{
			return (Jobs) sessionfactory.getCurrentSession().createCriteria(Jobs.class)
					.add(Restrictions.eq("job_Id",Job_Id)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

}
