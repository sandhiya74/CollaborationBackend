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
public class BlogComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int blog_Commentid;

	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Blog bolg;
	
	@Column(nullable=false,columnDefinition = "text")
	String blog_Comment;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	@Column(nullable=false,columnDefinition ="date default sysdate()" )
	 @Temporal(TemporalType.DATE)
	Date posted_Date;

	public int getBlog_Commentid() {
		return blog_Commentid;
	}

	public void setBlog_Commentid(int blog_Commentid) {
		this.blog_Commentid = blog_Commentid;
	}

	public Blog getBolg() {
		return bolg;
	}

	public void setBolg(Blog bolg) {
		this.bolg = bolg;
	}

	public String getBlog_Comment() {
		return blog_Comment;
	}

	public void setBlog_Comment(String blog_Comment) {
		this.blog_Comment = blog_Comment;
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
	
	
}
