package com.niit.Collaboration.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Jobs {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int job_Id;
	
	@Column(nullable=false,unique=true)
	String job_Title;
	
	@Column(nullable=false,columnDefinition = "text")
	String job_Description;
	
	@Column(nullable=false,columnDefinition = "text")
	String skill_Set;
	
	@Column(nullable=false)
	int job_Salary;
	
	@Column(nullable=false)
	 int no_Vacancy;
	
	@Column(nullable=false,columnDefinition ="default getdate()")
	 @Temporal(TemporalType.DATE)
	Date posted_Date;
	
	@Column(nullable=false,columnDefinition ="default adddate(Day,10,getdate())" )
	 @Temporal(TemporalType.DATE)
	Date last_Date;
	
	@Column(nullable=false,columnDefinition = "boolean defalut false")
	boolean job_Status;

	public int getJob_Id() {
		return job_Id;
	}

	public void setJob_Id(int job_Id) {
		this.job_Id = job_Id;
	}

	public String getJob_Title() {
		return job_Title;
	}

	public void setJob_Title(String job_Title) {
		this.job_Title = job_Title;
	}

	public String getJob_Description() {
		return job_Description;
	}

	public void setJob_Description(String job_Description) {
		this.job_Description = job_Description;
	}

	public String getSkill_Set() {
		return skill_Set;
	}

	public void setSkill_Set(String skill_Set) {
		this.skill_Set = skill_Set;
	}

	public int getJob_Salary() {
		return job_Salary;
	}

	public void setJob_Salary(int job_Salary) {
		this.job_Salary = job_Salary;
	}

	public int getNo_Vacancy() {
		return no_Vacancy;
	}

	public void setNo_Vacancy(int no_Vacancy) {
		this.no_Vacancy = no_Vacancy;
	}

	public Date getPosted_Date() {
		return posted_Date;
	}

	public void setPosted_Date(Date posted_Date) {
		this.posted_Date = posted_Date;
	}

	public Date getLast_Date() {
		return last_Date;
	}

	public void setLast_Date(Date last_Date) {
		this.last_Date = last_Date;
	}

	public boolean isJob_Status() {
		return job_Status;
	}

	public void setJob_Status(boolean job_Status) {
		this.job_Status = job_Status;
	}

	
	
	
	
	
	
}
