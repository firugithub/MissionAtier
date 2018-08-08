package com.listenerTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListenerTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		ServletContext context = getServletContext();

		Dog dog = (Dog) context.getAttribute("type");

		PrintWriter out = response.getWriter();
		out.println(dog.getDogName());

	}
}
