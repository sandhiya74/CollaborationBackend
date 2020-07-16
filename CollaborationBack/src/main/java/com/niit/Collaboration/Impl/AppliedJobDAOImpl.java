package com.niit.Collaboration.Impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.IAppliedJobDAO;
import com.niit.Collaboration.Model.AppliedJob;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Job;
@Repository("appliedjobdao")
@Transactional
public class AppliedJobDAOImpl implements IAppliedJobDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean addAppliedJob(AppliedJob Appliedjob) {
try {
			
			sessionfactory.getCurrentSession().save(Appliedjob);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<AppliedJob> selectAllAppliedJob(Job job) {
		try {
			 return (ArrayList<AppliedJob>) sessionfactory.getCurrentSession()
					.createCriteria(AppliedJob.class).add(Restrictions.eq("Job",job)).list();
		
		} catch (Exception e) {
			return null;
		}	}

	@Override
	public ArrayList<AppliedJob> selectmyAppliedJob(Customer customer) {
		try {
			 return (ArrayList<AppliedJob>) sessionfactory.getCurrentSession()
					.createCriteria(AppliedJob.class).add(Restrictions.eq("Customer",customer)).list();
		
		} catch (Exception e) {
			return null;
		}	}

	@Override
	public AppliedJob selectOneAppliedJob(int appliedjob_Id) {
		try {
			 return (AppliedJob) sessionfactory.getCurrentSession()
					.createCriteria(AppliedJob.class).add(Restrictions.eq("appliedjob_Id",appliedjob_Id)).list();
		
		} catch (Exception e) {
			return null;
		}	}

}
