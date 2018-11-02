package com.servlet;

import java.io.IOException;

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
 * Servlet implementation class AdminDeleteSoftware
 */
@WebServlet("/AdminDeleteSoftware")
public class AdminDeleteSoftware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteSoftware() {
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
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Admin.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			String SrNo = request.getParameter("softwareSrNo");
			int softwareSrNo=Integer.parseInt(SrNo);
			
			SoftwareDetailsService softwareDetailsService=new SoftwareDetailsServiceImpl();
			SoftwareDetails softwareDetails=softwareDetailsService.getSoftwareDetails(softwareSrNo);
			softwareDetailsService.deleteSoftwareDetails(softwareDetails);
			
			response.getWriter().append("Software Deleted");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("DeleteSoftware.jsp");
			requestDispatcher.include(request, response);
			
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
