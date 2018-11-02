package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDao;
import com.model.Customer;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;

/**
 * Servlet implementation class LoginCheker
 */
@WebServlet("/LoginCheker")
public class LoginCheker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String adminId="admin";
		String adminPassword="admin123";
		String type=request.getParameter("type");
		
		 if(type.equals("admin"))
		 {
			
			if(userId.equals(adminId) && password.equals(adminPassword))
			 {
				
				 System.out.println("in admin if");
				 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Admin.jsp");
				 requestDispatcher.forward(request, response);
			 }
			else  //send it to index.html
		      { //
		    	  //response.sendRedirect("index.html");
				 HttpSession session=request.getSession(true);
				 session.setAttribute(adminId, adminId);
		    	  RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
		    	  response.getWriter().append("Wrong user id OR password");
		    	  requestDispatcher.include(request, response);
		      }
			
		 }else if(type.equals("customer"))
		 {
			CustomerService customerService=new CustomerServiceImpl();
			List<Customer> allcustomers=customerService.getAllCustomers();
			for (Customer customer: allcustomers)
			{
				String userid=customer.getUserId();
				String pwd=customer.getPassword();
				
			
				 if(userId.equals(userid) && password.equals(pwd))
				 {
					  HttpSession session=request.getSession(true);
			    	  session.setAttribute("customer", customer);
			    	  RequestDispatcher requestDispatcher=request.getRequestDispatcher("Customer.jsp");
			    	  requestDispatcher.forward(request, response);
			      }
			}
		 }
		else  //send it to index.html
	      { //
	    	  //response.sendRedirect("index.html");
	    	  RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
	    	  response.getWriter().append("Wrong user id OR password");
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
