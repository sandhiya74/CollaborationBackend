package com.niit.CollaborationBackend.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Collaboration.DAO.IAppliedJobsDAO;
import com.niit.Collaboration.DAO.IBlogCommentDAO;
import com.niit.Collaboration.DAO.IBlogDAO;
import com.niit.Collaboration.DAO.ICustomerDAO;
import com.niit.Collaboration.DAO.IForumAnswerDAO;
import com.niit.Collaboration.DAO.IForumDAO;
import com.niit.Collaboration.DAO.IJobsDAO;
import com.niit.Collaboration.Model.Blog;
import com.niit.Collaboration.Model.Forum;
import com.niit.Collaboration.Model.ForumAnswer;
import com.niit.Collaboration.Model.Jobs;
import com.niit.CollaborationBackend.ServiceDAO.IAdminServiceDAO;
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
	public ArrayList<Forum> allForum() {
		
		return forumdao.allForum();
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
