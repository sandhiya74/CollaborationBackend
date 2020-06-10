package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.AppliedJobs;
import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Jobs;

public interface IAppliedJobsDAO {

   public boolean addAppliedJobs(AppliedJobs appliedjobs);
	
	public ArrayList<AppliedJobs> allAppliedJObs(Jobs jobs);
	
	public ArrayList<AppliedJobs> myAppliedJobs(Customer customer);
	
	public AppliedJobs selectOneAppliedJobs(int applied_Id);
}
