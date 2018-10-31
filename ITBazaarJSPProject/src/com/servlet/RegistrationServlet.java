package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dao.CustomerExistsException;
import com.model.Customer;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer=response.getWriter();
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String mobileNo=request.getParameter("mobileNo");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		
		//HttpSession session=request.getSession(true);
		//session.setAttribute("student", student);
		Customer customer=new Customer(mobileNo, name, address, email, userId, password);
		CustomerDao customerDao=new CustomerDaoImpl();
		try {
			customerDao.addCustomer(customer);
		} catch (CustomerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("alertMsg", "Registered sucessfully");
		writer.append("Registered SuccessFully");
		System.out.println(customer);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Register.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
