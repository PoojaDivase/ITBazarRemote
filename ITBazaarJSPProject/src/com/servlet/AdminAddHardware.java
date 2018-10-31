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
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;
import com.service.HardwareService;
import com.service.HardwareServiceImpl;

/**
 * Servlet implementation class AdminAddHardware
 */
@WebServlet("/AdminAddHardware")
public class AdminAddHardware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddHardware() {
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
			
			String SrNo = request.getParameter("hardwareSrNo");
			int hardwareSrNo=Integer.parseInt(SrNo);
			String hardwareName = request.getParameter("hardwareName");
			String price = request.getParameter("hardwarePrice");
			int hardwarePrice=Integer.parseInt(price);
			String quantity=request.getParameter("hardwareQuantity");
			int hardwareQuantity=Integer.parseInt(quantity);
			String hardwareManufacturer = request.getParameter("hardwareManufacturer");
			String hardwareColor=request.getParameter("hardwareColor");
			String discount = request.getParameter("hardwareDiscount");
			int hardwareDiscount=Integer.parseInt(discount);
			String id=request.getParameter("hardware_ID");
			int hardware_ID=Integer.parseInt(id);
			
			HardwareService hardware= new HardwareServiceImpl();
			Hardware hardware1=hardware.getHardware(hardware_ID);
			
			HardwareDetails hardwareDetails = new HardwareDetails(hardwareSrNo, hardwarePrice, hardwareQuantity, hardwareDiscount, hardware1, hardwareName, hardwareManufacturer, hardwareColor);  
			HardwareDetailsService hardwareDetailsService=new HardwareDetailsServiceImpl();
			hardwareDetailsService.addHardwareDetails(hardwareDetails);
			response.getWriter().append("Hardware Added");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("AddHardware.jsp");
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
