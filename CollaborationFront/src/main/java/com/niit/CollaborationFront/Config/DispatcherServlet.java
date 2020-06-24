package com.niit.CollaborationFront.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.CollaborationBack.Config.DbConfig;

public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {DbConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String[] {"/"};
	}

	
}
