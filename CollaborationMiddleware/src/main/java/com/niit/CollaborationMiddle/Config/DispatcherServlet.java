package com.niit.CollaborationMiddle.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.Collaboration.Config.DbConfig;

public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer{

	//will look for the configuration files--dbconfig
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{DbConfig.class};
	}
      // going to call my servlet over here
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}