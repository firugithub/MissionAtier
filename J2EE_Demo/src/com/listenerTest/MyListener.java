package com.listenerTest;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext sc = arg0.getServletContext();
		String str = sc.getInitParameter("breed");
		Dog dog = new Dog(str);
		sc.setAttribute("type", dog);
	}

}
