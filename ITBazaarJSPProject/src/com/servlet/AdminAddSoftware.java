package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Hardware;
import com.model.HardwareDetails;
import com.model.Software;
import com.model.SoftwareDetails;
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;
import com.service.SoftwareDetailsService;
import com.service.SoftwareDetailsServiceImpl;
import com.service.SoftwareService;
import com.service.SoftwareServiceImpl;

/**
 * Servlet implementation class AdminAddSoftware
 */
@WebServlet("/AdminAddSoftware")
public class AdminAddSoftware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddSoftware() {
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
			try{
			String SrNo = request.getParameter("softwareSrNo");
			int softwareSrNo=Integer.parseInt(SrNo);
			String softwareName = request.getParameter("softwareName");
			String price = request.getParameter("softwarePrice");
			int softwarePrice=Integer.parseInt(price);
			String quantity=request.getParameter("softwareQuantity");
			int softwareQuantity=Integer.parseInt(quantity);
			String softwareManufacture = request.getParameter("softwareManufacture");
			String discount = request.getParameter("softwareDiscount");
			int softwareDiscount=Integer.parseInt(discount);
			String id=request.getParameter("software_Id");
			int software_Id=Integer.parseInt(id);
			
			SoftwareService software= new SoftwareServiceImpl();
			Software software1=software.getSoftware(software_Id);
			SoftwareDetails softwareDetails=new SoftwareDetails(softwareSrNo, softwarePrice, softwareQuantity, softwareDiscount, software1, softwareName, softwareManufacture);
			SoftwareDetailsService softwareDetailsService=new SoftwareDetailsServiceImpl();
			softwareDetailsService.addSoftwareDetails(softwareDetails);
			response.getWriter().append("Hardware Added");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("AddSoftware.jsp");
			requestDispatcher.include(request, response);
			}
			catch(NumberFormatException e)
			{
				response.getWriter().append("Wrong input");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("AddSoftware.jsp");
				requestDispatcher.include(request, response);
			}
			catch(NullPointerException e)
			{
				response.getWriter().append("Wrong input");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("AddSoftware.jsp");
				requestDispatcher.include(request, response);
			}
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
