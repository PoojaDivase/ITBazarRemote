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
import com.model.SoftwareDetails;
import com.service.CombinationOrderService;
import com.service.CombinationOrderServiceImpl;
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;
import com.service.SoftwareDetailsService;
import com.service.SoftwareDetailsServiceImpl;

/**
 * Servlet implementation class OfferDiscountServlet
 */
@WebServlet("/OfferDiscountServlet")
public class OfferDiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferDiscountServlet() {
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
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Customer.jsp");
			 requestDispatcher.include(request, response);
		}
		else
		{
			Customer customer=(Customer) session.getAttribute("customer");
			int customer_id=customer.getCid();
		
			List<HardwareDetails> orderedlist=new ArrayList<HardwareDetails>();
			List<HardwareDetails> neworderedlist=new ArrayList<HardwareDetails>();
			List<SoftwareDetails> orderedlistSoftware=new ArrayList<SoftwareDetails>();
			List<SoftwareDetails> neworderedlistSoftware=new ArrayList<SoftwareDetails>();
			
			String[] selectedHardwareProduct=request.getParameterValues("checkboxGroupForHardware");
			String[] selectedSoftwareProduct=request.getParameterValues("checkboxGroupForSoftware");
		//	String[] selectedquantity=request.getParameterValues("quantity1");
			for(int i=0;i<selectedHardwareProduct.length;i++)
			{
				System.out.println(selectedHardwareProduct[i]);
				int srNo=Integer.parseInt(selectedHardwareProduct[i]);
				HardwareDetailsService hardwareDetailsService=new HardwareDetailsServiceImpl();
				HardwareDetails hardwareDetails=hardwareDetailsService.getHardwareDetails(srNo);
				orderedlist.add(hardwareDetails);
			}
			for(int i=0;i<selectedSoftwareProduct.length;i++)
			{
				System.out.println(selectedSoftwareProduct[i]);
				int srNo=Integer.parseInt(selectedSoftwareProduct[i]);
				SoftwareDetailsService softwareDetailsService=new SoftwareDetailsServiceImpl();
				SoftwareDetails softwareDetails=softwareDetailsService.getSoftwareDetails(srNo);
				orderedlistSoftware.add(softwareDetails);
			}
		//	for(int i=0;i<selectedquantity.length;i++)
			{
			//	System.out.println(selectedquantity[i]);
				for(int j=0;j<orderedlist.size();j++)
				{
					//if(i==j)
					{
						HardwareDetails hardwareDetails1=orderedlist.get(j);
						hardwareDetails1.setHardwareQuantity(1);
						neworderedlist.add(hardwareDetails1);
					}
				}
			}
//			for(int i=0;i<selectedquantity.length;i++)
					{
					//	System.out.println(selectedquantity[i]);
						for(int j=0;j<orderedlistSoftware.size();j++)
						{
							//if(i==j)
							{
								SoftwareDetails softwareDetails1=orderedlistSoftware.get(j);
								softwareDetails1.setSoftwareQuantity(1);
								neworderedlistSoftware.add(softwareDetails1);
							}
						}
					}
				
			for(HardwareDetails hardware:neworderedlist)
			{
				System.out.println(hardware);
				CombinationOrderService customerPlaceOrder=new CombinationOrderServiceImpl();
				Order order=new Order();
				order=customerPlaceOrder.PlaceHardwareOrder(hardware, customer_id);
				System.out.println("***********************");
				System.out.println(order);
				currentorder.add(order);
			}
			
			for(SoftwareDetails software:neworderedlistSoftware)
			{
				System.out.println(software);
				CombinationOrderService customerPlaceOrder=new CombinationOrderServiceImpl();
				Order order=new Order();
				order=customerPlaceOrder.PlaceSoftwareOrder(software,customer_id);
				System.out.println("***********************");
				System.out.println(order);
				currentorder.add(order);
			}
			System.out.println("****************");
			for(Order o:currentorder)
			{
				System.out.println(o);
			}
			
			session.setAttribute("currentorder",currentorder);
			request.getRequestDispatcher("ViewCurrentOrderDetails.jsp").forward(request, response);
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
