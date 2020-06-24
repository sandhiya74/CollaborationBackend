package com.niit.CollaborationBack.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.CollaborationBack.DAO.IBlogDAO;
import com.niit.CollaborationBack.DAO.IForumAnswerDAO;
import com.niit.CollaborationBack.DAO.IForumDAO;
import com.niit.CollaborationBack.DAO.IJobsDAO;
import com.niit.CollaborationBack.Model.Blog;
import com.niit.CollaborationBack.Model.Forum;
import com.niit.CollaborationBack.Model.ForumAnswer;
import com.niit.CollaborationBack.Model.Jobs;
import com.niit.CollaborationBack.ServiceDAO.IAdminServiceDAO;

@Service
public class AdminServiceDAOImpl implements IAdminServiceDAO {

	@Autowired
	IBlogDAO blogdao;
	

	
	
	@Autowired
	IJobsDAO jobsdao;
	

	@Autowired
	IForumDAO forumdao;

	IForumAnswerDAO forumanswerdao;
	
	@Override
	public ArrayList<Blog> selectApprovedBlogs() {
		
		return blogdao.selectApprovedBlogs();
	}

	@Override
	public ArrayList<Blog> selectAllUnapprovedBlogs() {
		
		return blogdao.selectAllUnapprovedBlogs();
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
	public ArrayList<Forum> selectAllForum(Forum forum) {
		
		return forumdao.selectAllForum(forum);
	}

	@Override
	public ArrayList<ForumAnswer> allForumAnswer(Forum forum) {
		
		return forumanswerdao.allForumAnswer(forum);
	}

	@Override
	public ArrayList<Jobs> selectApprovedJobs() {
		
		return jobsdao.selectApprovedJobs();
	}

	@Override
	public ArrayList<Jobs> selectUnApprovedJobs() {
		
		return jobsdao.selectUnApprovedJobs();
	}

}
