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
import com.model.HardwareDetails;
import com.model.Order;
import com.service.CustomerOrderService;
import com.service.CustomerOrderServiceImpl;
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;

/**
 * Servlet implementation class CustomerPlacedOrder
 */
@WebServlet("/CustomerPlacedOrder")
public class CustomerPlacedOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerPlacedOrder() {
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
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Customer.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			
			try{
				
			Customer customer=(Customer) session.getAttribute("customer");
			int customer_id=customer.getCid();
		
			List<HardwareDetails> orderedlist=new ArrayList<HardwareDetails>();
			List<HardwareDetails> neworderedlist=new ArrayList<HardwareDetails>();
			String[] selectedproduct=request.getParameterValues("checkboxGroup");
			String[] selectedquantity=request.getParameterValues("quantity1");
			for(int i=0;i<selectedproduct.length;i++)
			{
				System.out.println(selectedproduct[i]);
				int srNo=Integer.parseInt(selectedproduct[i]);
				HardwareDetailsService hardwareDetailsService=new HardwareDetailsServiceImpl();
				HardwareDetails hardwareDetails=hardwareDetailsService.getHardwareDetails(srNo);
				orderedlist.add(hardwareDetails);
			}
			for(int i=0;i<selectedquantity.length;i++)
			{
				System.out.println(selectedquantity[i]);
				for(int j=0;j<orderedlist.size();j++)
				{
					if(i==j)
					{
						HardwareDetails hardwareDetails1=orderedlist.get(j);
						hardwareDetails1.setHardwareQuantity(Integer.parseInt(selectedquantity[i]));
						neworderedlist.add(hardwareDetails1);
					}
				}
			}
			for(HardwareDetails hardware:neworderedlist)
			{
				System.out.println(hardware);
				CustomerOrderService customerPlaceOrder=new CustomerOrderServiceImpl();
				Order order=new Order();
				order=customerPlaceOrder.PlaceHardwareOrder(hardware,customer_id);
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
