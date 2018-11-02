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
import com.service.AdminOperationsService;
import com.service.AdminOperationsServiceImpl;

/**
 * Servlet implementation class CustomerSearchProduct
 */
@WebServlet("/CustomerSearchProduct")
public class CustomerSearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSearchProduct() {
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
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Customer.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			String searchstr=request.getParameter("search");
			System.out.println(searchstr);
			String product_type=request.getParameter("type");
			System.out.println(product_type);
			if(product_type.equals("hardware"))
			{
				AdminOperationsService adminOperationsService=new AdminOperationsServiceImpl();
				HardwareDetails searchedHardware=adminOperationsService.SearchHardwareByName(searchstr);
				System.out.println(searchedHardware);
				List<HardwareDetails> productlist=new ArrayList<HardwareDetails>();
				productlist.add(searchedHardware);
				
				session.setAttribute("productlist", productlist);
				request.getRequestDispatcher("CustomerShowHardwareDetails.jsp").forward(request, response);
				
			}
			else if(product_type.equals("software"))
			{
				AdminOperationsService adminOperationsService=new AdminOperationsServiceImpl();
				SoftwareDetails searchedSoftware=adminOperationsService.SearchSoftwareByName(searchstr);
				System.out.println(searchedSoftware);
				List<SoftwareDetails> productlist=new ArrayList<SoftwareDetails>();
				productlist.add(searchedSoftware);
				session.setAttribute("productlist", productlist);
				request.getRequestDispatcher("CustomerShowSoftwareDetails.jsp").forward(request, response);	
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
