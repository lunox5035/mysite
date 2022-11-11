package com.biracademy.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConntextLoadListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		String contextConfigLocation = sc.getInitParameter("contextConfigLocation");

		System.out.println("Application Starts...." + contextConfigLocation);
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
