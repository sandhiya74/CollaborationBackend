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
	@GeneratedValue(strategy=GenerationType.AUTO)
	int forumans_Id;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Forum forum;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Customer customer;
	
	@Column(nullable = false,columnDefinition="text")
	String forumans;
	
	@Column(nullable = false,columnDefinition="date default sysdate()")
	@Temporal(TemporalType.DATE)
	 Date posted_Date;
	
	@Column(nullable = false,columnDefinition="boolean default false")
	boolean forum_Status;

	public int getForumans_Id() {
		return forumans_Id;
	}

	public void setForumans_Id(int forumans_Id) {
		this.forumans_Id = forumans_Id;
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

	public String getForumans() {
		return forumans;
	}

	public void setForumans(String forumans) {
		this.forumans = forumans;
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

	public boolean isForum_Status() {
		return forum_Status;
	}

	public void setForum_Status(boolean forum_Status) {
		this.forum_Status = forum_Status;
	}

	
}