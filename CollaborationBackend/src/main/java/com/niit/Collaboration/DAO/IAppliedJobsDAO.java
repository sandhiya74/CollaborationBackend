package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.AppliedJobs;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Jobs;

public interface IAppliedJobsDAO {

   public boolean AppliedJobs(AppliedJobs appliedjobs);
	
	public ArrayList<AppliedJobs> allAppliedJobs(Jobs jobs);
	
	public ArrayList<AppliedJobs> myAppliedJobs(Customer customer);
	
	public AppliedJobs selectOneAppliedJobs(int applied_Id);
}
