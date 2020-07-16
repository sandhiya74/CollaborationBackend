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
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int blog_Id;
	@Column(nullable = false, unique = true)
	String blog_Title;
	@Column(nullable = false,columnDefinition="text")
	String blog_Content;
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	@Column(nullable = false,columnDefinition="date default sysdate()")//it will give current date.
	@Temporal(TemporalType.DATE)
	Date posted_Date;
	
	@Column(nullable = false,columnDefinition="boolean default false")
	boolean status;

	public int getBlog_Id() {
		return blog_Id;
	}

	public void setBlog_Id(int blog_Id) {
		this.blog_Id = blog_Id;
	}

	public String getBlog_Title() {
		return blog_Title;
	}

	public void setBlog_Title(String blog_Title) {
		this.blog_Title = blog_Title;
	}

	public String getBlog_Content() {
		return blog_Content;
	}

	public void setBlog_Content(String blog_Content) {
		this.blog_Content = blog_Content;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}