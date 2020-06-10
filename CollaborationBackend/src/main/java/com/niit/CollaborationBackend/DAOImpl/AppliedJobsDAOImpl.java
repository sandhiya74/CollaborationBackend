package com.niit.CollaborationBackend.DAOImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.IAppliedJobsDAO;
import com.niit.Collaboration.Model.AppliedJobs;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.Jobs;

@Repository("appliedjobsdao")
@Transactional
public class AppliedJobsDAOImpl implements IAppliedJobsDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addAppliedJobs(AppliedJobs appliedjobs) {
		try
		{
			sessionfactory.getCurrentSession().save(appliedjobs);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	
	@Override
	public ArrayList<AppliedJobs> allAppliedJObs(Jobs jobs) {
		try {
			ArrayList<AppliedJobs> jobslist = (ArrayList<AppliedJobs>) sessionfactory.getCurrentSession()
					.createCriteria(Jobs.class).add(Restrictions.eq("Jobs",jobs)).list();
			return jobslist;
		} catch (Exception e) {
			return null;
		}
	}
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
