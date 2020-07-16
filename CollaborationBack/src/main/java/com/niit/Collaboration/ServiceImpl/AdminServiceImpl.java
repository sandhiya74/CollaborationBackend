package com.niit.Collaboration.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.DAO.IForumAnsDAO;
import com.niit.Collaboration.DAO.IForumDAO;
import com.niit.Collaboration.DAO.IJobDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Job;
import com.niit.Collaboration.Service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
@Autowired
IBlogDAO blogdao;
IForumDAO forumdao;
IForumAnsDAO forumansdao;
IJobDAO jobdao;

	@Override
	public ArrayList<Blog> selectAllApporovedBlogs() {
	
		return blogdao.selectAllApporovedBlogs();
	}

	@Override
	
	public ArrayList<Blog> selectAllUnapporovedBlogs() {
		
		return blogdao.selectAllUnapporovedBlogs();
	}

	@Override
	public boolean addForum(Forum forum) {
		
		return forumdao.addForum(forum);
	}

	@Override
	public boolean updateForum(Forum forum) {
		
		return forumdao.updateForum(forum);
	}

	@Override
	public boolean deleteForum(Forum forum) {
		
		return forumdao.deleteForum(forum);
	}

	@Override
	public ArrayList<Forum> selectallForum() {
		
		return forumdao.selectallForum();
	}
	@Override
	public ArrayList<ForumAnswer> selectAllApporovedForumAnswer() {
	
		return forumansdao.selectAllApporovedForumAnswer();
	}

	@Override
	public ArrayList<ForumAnswer> selectAllUnapporovedForumAnswer() {
	
		return forumansdao.selectAllUnapporovedForumAnswer();
	}

//	@Override
//	public ArrayList<ForumAnswer> selectAllForumAnswer(Forum forum) {
//		
//		return forumansdao.selectAllForumAnswer(forum);
//	}

	@Override
	public ArrayList<Job> selectAllApporovedJobs() {
	
		return jobdao.selectAllApporovedJobs();
	}

	@Override
	public ArrayList<Job> selectAllUnapporovedJobs() {
	
		return jobdao.selectAllUnapporovedJobs();
	}

	@Override
	public ArrayList<ForumAnswer> selectAllForumAnswer(Forum forum) {
		// TODO Auto-generated method stub
		return null;
	}

}
