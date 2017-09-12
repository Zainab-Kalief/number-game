package com.wura.web.controllers;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer randomValue = ThreadLocalRandom.current().nextInt(1, 100);
		session.setAttribute("randomValue", randomValue);
		
		request.setAttribute("message", "");
		RequestDispatcher view = request.getRequestDispatcher("HomeFile.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer randomValue = (Integer) session.getAttribute("randomValue");
		String guess =  request.getParameter("guess");
		Integer result = Integer.parseInt(guess);
		if(result  > randomValue) {
			request.setAttribute("message", "Too High, try again");
		} else if (result  < randomValue) {
			request.setAttribute("message", "Too Low, try harder baby");
		} else {
			request.setAttribute("message", "Perfect");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("HomeFile.jsp");
		view.forward(request, response);
	}

}
