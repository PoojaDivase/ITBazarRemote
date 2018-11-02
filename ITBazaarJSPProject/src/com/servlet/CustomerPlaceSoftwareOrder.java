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

import com.model.Customer;
import com.model.SoftwareDetails;
import com.model.Order;
import com.service.CustomerOrderService;
import com.service.CustomerOrderServiceImpl;
import com.service.SoftwareDetailsService;
import com.service.SoftwareDetailsServiceImpl;
import com.service.HardwareDetailsServiceImpl;

/**
 * Servlet implementation class CustomerPlaceSoftwareOrder
 */
@WebServlet("/CustomerPlaceSoftwareOrder")
public class CustomerPlaceSoftwareOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerPlaceSoftwareOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Order> currentorder=new ArrayList<Order>();
//		if(!currentorder.isEmpty())
//		{
//			for(Order o:currentorder)
//			{
//				currentorder.remove(o);
//			}
//		}
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			try
			{
			Customer customer=(Customer) session.getAttribute("customer");
			int customer_id=customer.getCid();
		
			List<SoftwareDetails> orderedlist=new ArrayList<SoftwareDetails>();
			List<SoftwareDetails> neworderedlist=new ArrayList<SoftwareDetails>();
			String[] selectedproduct=request.getParameterValues("checkboxGroup");
			String[] selectedquantity=request.getParameterValues("quantity1");
			for(int i=0;i<selectedproduct.length;i++)
			{
				System.out.println(selectedproduct[i]);
				int srNo=Integer.parseInt(selectedproduct[i]);
				SoftwareDetailsService softwareDetailsService=new SoftwareDetailsServiceImpl();
				SoftwareDetails softwareDetails=softwareDetailsService.getSoftwareDetails(srNo);
				orderedlist.add(softwareDetails);
			}
			for(int i=0;i<selectedquantity.length;i++)
			{
				System.out.println(selectedquantity[i]);
				for(int j=0;j<orderedlist.size();j++)
				{
					if(i==j)
					{
						SoftwareDetails softwareDetails1=orderedlist.get(j);
						softwareDetails1.setSoftwareQuantity(Integer.parseInt(selectedquantity[i]));
						neworderedlist.add(softwareDetails1);
					}
				}
			}
			for(SoftwareDetails software:neworderedlist)
			{
				System.out.println(software);
				CustomerOrderService customerPlaceOrder=new CustomerOrderServiceImpl();
				Order order=new Order();
				order=customerPlaceOrder.PlaceSoftwareOrder(software,customer_id);
				System.out.println("***********************");
				System.out.println(order);
				if(order==null)
				{
					continue;
				
				}
				else
				{
					currentorder.add(order);
				}
			}
			System.out.println("****************");
			for(Order o:currentorder)
			{
				System.out.println(o);
			}
			
			if(currentorder.isEmpty())
			{
				
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("ViewCurrentOrderDetails.jsp");
				response.getWriter().append("Out of stock");
				requestDispatcher.include(request, response);
			}
			else
			{
			session.setAttribute("currentorder",currentorder);
			request.getRequestDispatcher("ViewCurrentOrderDetails.jsp").forward(request, response);
			}
			}
			catch(NullPointerException e)
			{
				response.getWriter().append("OUT of stock");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("ViewCurrentOrderDetails.jsp");
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
