package com.niit.CollaborationBack.Model;
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
	
	@Column(nullable=false,columnDefinition="text")
	String forum_Answer;
	
	@Column(nullable=false,columnDefinition ="date default sysdate()" )
	 @Temporal(TemporalType.DATE)
	Date posted_Date;
	
	@Column(nullable=false,columnDefinition="boolean default false")
	boolean forum_Status;

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

	

	public boolean isForum_Status() {
		return forum_Status;
	}

	public void setForum_Status(boolean forum_Status) {
		this.forum_Status = forum_Status;
	}

	public String getForum_Answer() {
		return forum_Answer;
	}

	public void setForum_Answer(String forum_Answer) {
		this.forum_Answer = forum_Answer;
	}


	
	
	
}
