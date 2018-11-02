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
import com.model.Order;
import com.model.SoftwareDetails;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import com.service.SoftwareDetailsService;
import com.service.SoftwareDetailsServiceImpl;

/**
 * Servlet implementation class ShowAllOrdersForParticularCustomerController
 */
@WebServlet("/ShowAllOrdersForParticularCustomer")
public class ShowAllOrdersForParticularCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllOrdersForParticularCustomerController() {
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
			Customer customer=(Customer) session.getAttribute("customer");
			int customer_id=customer.getCid();
			System.out.println(customer_id);
			OrderService orderService=new OrderServiceImpl();
			List<Order> orderlist=new ArrayList<Order>();
			orderlist=orderService.getAllOrderDetailsForParticularCustomer(customer_id);
			for(Order o:orderlist)
			{
				System.out.println(o);
			}
			
			
			session.setAttribute("orderlist", orderlist);
			request.getRequestDispatcher("CustomerViewAllOrders.jsp").forward(request, response);
			
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
