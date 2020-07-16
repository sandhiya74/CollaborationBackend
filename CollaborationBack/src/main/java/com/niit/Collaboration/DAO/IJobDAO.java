package com.niit.Collaboration.DAO;

import java.util.ArrayList;

import com.niit.Collaboration.Model.Customer;
import com.niit.Collaboration.Model.Job;

public interface IJobDAO {
	public boolean addJob(Job job);
	public boolean updateJob(Job job);
	public boolean deleteJob(Job job);
	public ArrayList<Job> selectAllApporovedJobs();
	public ArrayList<Job> selectAllJobOfOneUser(Customer cust);
	public ArrayList<Job> selectAllUnapporovedJobs();
	public Job selectOneJob(int jobid);
}