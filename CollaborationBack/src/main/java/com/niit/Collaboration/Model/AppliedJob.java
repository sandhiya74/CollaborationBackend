package com.niit.Collaboration.Model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class AppliedJob {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int appliedjob_Id;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Job job;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	@Column(nullable = false,columnDefinition="date default sysdate()")
	@Temporal(TemporalType.DATE)
	 Date appliedjob_Date;

	public int getAppliedjob_Id() {
		return appliedjob_Id;
	}

	public void setAppliedjob_Id(int appliedjob_Id) {
		this.appliedjob_Id = appliedjob_Id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getAppliedjob_Date() {
		return appliedjob_Date;
	}

	public void setAppliedjob_Date(Date appliedjob_Date) {
		this.appliedjob_Date = appliedjob_Date;
	}

	
}