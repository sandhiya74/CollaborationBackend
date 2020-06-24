package com.niit.CollaborationBack.DAOImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBack.DAO.IAppliedJobsDAO;
import com.niit.CollaborationBack.Model.AppliedJobs;
import com.niit.CollaborationBack.Model.Customer;
import com.niit.CollaborationBack.Model.Jobs;

@Repository("appliedjobsdao")
@Transactional
public class AppliedJobsDAOImpl implements IAppliedJobsDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean AppliedJobs(AppliedJobs appliedjobs) {
		try
		{
			sessionfactory.getCurrentSession().save(appliedjobs);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<AppliedJobs> allAppliedJobs(Jobs jobs) {
		try {
			ArrayList<AppliedJobs> jobslist = (ArrayList<AppliedJobs>) sessionfactory.getCurrentSession()
					.createCriteria(Jobs.class).add(Restrictions.eq("Jobs",jobs)).list();
			return jobslist;
		} catch (Exception e) {
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public ArrayList<AppliedJobs> myAppliedJobs(Customer customer){
		
		
		try {
			ArrayList<AppliedJobs> jobslist = (ArrayList<AppliedJobs>) sessionfactory.getCurrentSession()
					.createCriteria(Jobs.class).add(Restrictions.eq("Customer",customer)).list();
			return jobslist;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public AppliedJobs selectOneAppliedJobs(int applied_Id) {
		try
		{
			return (AppliedJobs) sessionfactory.getCurrentSession().createCriteria(AppliedJobs.class)
					.add(Restrictions.eq("applied_Id",applied_Id)).list();
		}
		catch(Exception e)
		{
		return null;
		}
	}

}
