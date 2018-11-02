package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Software;
import com.model.SoftwareDetails;
import com.service.SoftwareDetailsService;
import com.service.SoftwareDetailsServiceImpl;
import com.service.SoftwareService;
import com.service.SoftwareServiceImpl;

/**
 * Servlet implementation class AdminUpdateSoftware
 */
@WebServlet("/AdminUpdateSoftware")
public class AdminUpdateSoftware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateSoftware() {
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
		
			String price = request.getParameter("softwarePrice");
			int softwarePrice=Integer.parseInt(price);
			String quantity=request.getParameter("softwareQuantity");
			int softwareQuantity=Integer.parseInt(quantity);
			
			String discount = request.getParameter("softwareDiscount");
			int softwareDiscount=Integer.parseInt(discount);
		
			SoftwareDetailsService softwareDetailsService=new SoftwareDetailsServiceImpl();
			SoftwareDetails softwareDetails=softwareDetailsService.getSoftwareDetails(softwareSrNo);
			System.out.println(softwareDetails);
			
			softwareDetails.setSoftwarePrice(softwarePrice);
			softwareDetails.setSoftwareQuantity(softwareQuantity);
			softwareDetails.setSoftwareDiscount(softwareDiscount);
			
			softwareDetailsService.updateSoftwareDetails(softwareDetails);
			System.out.println(softwareDetails);
			
			response.getWriter().append("Software Updated");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("UpdateSoftware.jsp");
			requestDispatcher.include(request, response);
			}
			catch (NullPointerException e) {
				// TODO: handle exception
				response.getWriter().append("Wrong input");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("UpdateSoftware.jsp");
				requestDispatcher.include(request, response);
				
			}
			catch (NumberFormatException e) {
				// TODO: handle exception
				response.getWriter().append("Wrong input");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("UpdateSoftware.jsp");
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
