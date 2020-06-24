package com.niit.CollaborationBack.DAO;

import java.util.ArrayList;

import com.niit.CollaborationBack.Model.Jobs;

public interface IJobsDAO {

    public boolean addJobs(Jobs jobs);
	
	public boolean updateJobs(Jobs jobs);
	
	public boolean deleteJobs(Jobs jobs);
	
	public ArrayList<Jobs>selectApprovedJobs();
	
	public ArrayList<Jobs>selectAllJobsofOneUser(int cust_Id);
	
	public ArrayList<Jobs>selectUnApprovedJobs();
	
	public Jobs selectOneJobs(int Job_Id);
	
}
