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
import com.service.AdminOperationsService;
import com.service.AdminOperationsServiceImpl;
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;

/**
 * Servlet implementation class HardwareCategoryController
 */
@WebServlet("/HardwareCategory")
public class HardwareCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HardwareCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			String selected_hardware=request.getParameter("hardware");
			int category_id=Integer.parseInt(selected_hardware);
			
		
			AdminOperationsService adminOperationService=new AdminOperationsServiceImpl();
			List<HardwareDetails> productlist=new ArrayList<HardwareDetails>();
			productlist=adminOperationService.SortByHardwareName(category_id);
			session.setAttribute("productlist", productlist);
			request.getRequestDispatcher("AdminShowHardwareDetails.jsp").forward(request, response);
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
