package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.AppliedJob;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Job;


public interface IAppliedJobDAO {
	public boolean addAppliedJob(AppliedJob Appliedjob);
	public ArrayList<AppliedJob> selectAllAppliedJob(Job job);
	public ArrayList<AppliedJob> selectmyAppliedJob(Customer customer);
	 public AppliedJob selectOneAppliedJob(int appliedjob_Id);
}
