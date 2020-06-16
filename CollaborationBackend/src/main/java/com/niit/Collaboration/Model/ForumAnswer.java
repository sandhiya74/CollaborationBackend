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
public class ForumAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int answer_Id;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
    Forum forum;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	@Column(nullable=false,columnDefinition ="date default sysdate()" )
	 @Temporal(TemporalType.DATE)
	Date posted_Date;
	
	@Column(nullable=false,columnDefinition="boolean default false")
	boolean blog_Status;

	public int getAnswer_Id() {
		return answer_Id;
	}

	public void setAnswer_Id(int answer_Id) {
		this.answer_Id = answer_Id;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getPosted_Date() {
		return posted_Date;
	}

	public void setPosted_Date(Date posted_Date) {
		this.posted_Date = posted_Date;
	}

	public boolean isBlog_Status() {
		return blog_Status;
	}

	public void setBlog_Status(boolean blog_Status) {
		this.blog_Status = blog_Status;
	}
	
	
	
}
