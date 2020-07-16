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
	@GeneratedValue(strategy=GenerationType.AUTO)
	int blogcomment_Id;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Blog blog;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	@Column(nullable = false,columnDefinition="text")
	String comment;
	
	@Column(nullable = false,columnDefinition="date default sysdate()")
	@Temporal(TemporalType.DATE)
	Date comment_Date;

	public int getBlogcomment_Id() {
		return blogcomment_Id;
	}

	public void setBlogcomment_Id(int blogcomment_Id) {
		this.blogcomment_Id = blogcomment_Id;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getComment_Date() {
		return comment_Date;
	}

	public void setComment_Date(Date comment_Date) {
		this.comment_Date = comment_Date;
	}
	
}