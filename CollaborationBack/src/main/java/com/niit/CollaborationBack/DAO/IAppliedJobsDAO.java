package com.niit.CollaborationBack.DAO;

import java.util.ArrayList;

import com.niit.CollaborationBack.Model.AppliedJobs;
import com.niit.CollaborationBack.Model.Customer;
import com.niit.CollaborationBack.Model.Jobs;

public interface IAppliedJobsDAO {

   public boolean AppliedJobs(AppliedJobs appliedjobs);
	
	public ArrayList<AppliedJobs> allAppliedJobs(Jobs jobs);
	
	public ArrayList<AppliedJobs> myAppliedJobs(Customer customer);
	
	public AppliedJobs selectOneAppliedJobs(int applied_Id);
}
