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
public class AppliedJobs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int applied_Id;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
    Jobs jobs;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	@Column(nullable=false,columnDefinition ="date default sysdate()" )
	 @Temporal(TemporalType.DATE)
	Date applied_Date;

	public int getApplied_Id() {
		return applied_Id;
	}

	public void setApplied_Id(int applied_Id) {
		this.applied_Id = applied_Id;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getApplied_Date() {
		return applied_Date;
	}

	public void setApplied_Date(Date applied_Date) {
		this.applied_Date = applied_Date;
	}

	

}
