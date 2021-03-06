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
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;

/**
 * Servlet implementation class AdminCheckHardwareStock
 */
@WebServlet("/AdminCheckHardwareStock")
public class AdminCheckHardwareStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckHardwareStock() {
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
			try{
				
			
			HardwareDetailsService hardwareDetailsService=new HardwareDetailsServiceImpl();
			List<HardwareDetails> allproducts=new ArrayList<HardwareDetails>();
			allproducts=hardwareDetailsService.getAllHardwareDetails();
			
			List<HardwareDetails> productlist=new ArrayList<HardwareDetails>();
			for(int i=0;i<allproducts.size();i++)
			{
				if(allproducts.get(i).getHardwareQuantity()<=20)
				{
					HardwareDetails hardwareDetails=new HardwareDetails();
					hardwareDetails=allproducts.get(i);
					productlist.add(hardwareDetails);
					
					
				}
			}
			
			session.setAttribute("productlist", productlist);
			request.getRequestDispatcher("AdminShowHardwareDetails.jsp").forward(request, response);
			}
			catch(NullPointerException e)
			{
				response.getWriter().append("Exception Ocurred");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("AdminShowHardwareDetails.jsp");
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
