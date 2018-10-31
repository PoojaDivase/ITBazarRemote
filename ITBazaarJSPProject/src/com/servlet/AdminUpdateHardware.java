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
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;

/**
 * Servlet implementation class AdminUpdateHardware
 */
@WebServlet("/AdminUpdateHardware")
public class AdminUpdateHardware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateHardware() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String SrNo = request.getParameter("hardwareSrNo");
		int hardwareSrNo=Integer.parseInt(SrNo);
		System.out.println(hardwareSrNo);
		String price = request.getParameter("hardwarePrice");
		int newhardwarePrice=Integer.parseInt(price);
		String quantity=request.getParameter("hardwareQuantity");
		int newhardwareQuantity=Integer.parseInt(quantity);
		String discount = request.getParameter("hardwareDiscount");
		int newhardwareDiscount=Integer.parseInt(discount);
		
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Admin.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			
			
			HardwareDetailsService hardwareDetailsService=new HardwareDetailsServiceImpl();
			HardwareDetails hardwareDetails=hardwareDetailsService.getHardwareDetails(hardwareSrNo);
			System.out.println(hardwareDetails);
			hardwareDetails.setHardwareSrNo(hardwareSrNo);
			hardwareDetails.setHardwarePrice(newhardwarePrice);
			hardwareDetails.setHardwareQuantity(newhardwareQuantity);
			hardwareDetails.setHardwareDiscount(newhardwareDiscount);
			hardwareDetailsService.updateHardwareDetails(hardwareDetails);
			System.out.println(hardwareDetails);
			response.getWriter().append("Hardware updated");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("UpdateHardware.jsp");
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
