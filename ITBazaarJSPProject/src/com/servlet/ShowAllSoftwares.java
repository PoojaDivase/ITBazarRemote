package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.HardwareDetails;
import com.model.SoftwareDetails;
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;
import com.service.SoftwareDetailsService;
import com.service.SoftwareDetailsServiceImpl;

/**
 * Servlet implementation class ShowAllSoftwares
 */
@WebServlet("/ShowAllSoftwares")
public class ShowAllSoftwares extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllSoftwares() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			SoftwareDetailsService softwareDetailsService=new SoftwareDetailsServiceImpl();
			List<SoftwareDetails> productlist=new ArrayList<SoftwareDetails>();
			productlist=softwareDetailsService.getAllSoftware();
			session.setAttribute("productlist", productlist);
			request.getRequestDispatcher("AdminShowSoftwareDetails.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
