package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.CustomerDaoImpl;
import com.dao.HardwareDetailsDao;
import com.dao.SoftwareDetailsDao;
import com.dao.HardwareDetailsDaoImpl;
import com.dao.SoftwareDetailsDaoImpl;
import com.model.Customer;
import com.model.HardwareDetails;
import com.model.SoftwareDetails;
import com.model.Order;
import com.model.SoftwareDetails;

public class CombinationOrderServiceImpl implements CombinationOrderService{

	/**
	 * object creation
	 */
	HardwareDetailsServiceImpl hardwareDetailsService=new HardwareDetailsServiceImpl();
	SoftwareDetailsService softwareDetailsService=new SoftwareDetailsServiceImpl();
	

	

	/**
	 * Function to Place Hardware Order
	 */
	@Override
	public Order PlaceHardwareOrder(HardwareDetails hardwareDetails,int customerId) {
		// TODO Auto-generated method stub
	
	
	    int HardwareSrNo=hardwareDetails.getHardwareSrNo();
		HardwareDetailsService hardwareDetailsService = new HardwareDetailsServiceImpl();
		HardwareDetails detailsOfHardwareOrder= hardwareDetailsService.getHardwareDetails(HardwareSrNo);
		String hardwareName = hardwareDetails.getHardwareName();
		int hardwareQuantity = hardwareDetails.getHardwareQuantity();
	    java.sql.Date orderdate = new java.sql.Date((2017-1900), 12, 12);
	    int Hquantity=detailsOfHardwareOrder.getHardwareQuantity(); 
	    /**
	     * condition to check the quantity order and quantity present in the table
	     */
		if(Hquantity>=hardwareQuantity)
		{
	
		    int actualprice,discountedprice;
		    actualprice=hardwareDetails.getHardwareQuantity()*detailsOfHardwareOrder.getHardwarePrice();
		    int discount=15;
		    discountedprice=actualprice-(discount*actualprice)/100;
		    System.out.println("actualprice"+actualprice);
		    System.out.println("discounted price"+discountedprice);
		    Hquantity=Hquantity-hardwareQuantity;
		    detailsOfHardwareOrder.setHardwareQuantity(Hquantity);
		    hardwareDetailsService.updateHardwareDetails(detailsOfHardwareOrder);
		     
		    
		    CustomerDaoImpl customer=new CustomerDaoImpl();
		    Customer customer2 = customer.getCustomer(customerId);
		    Order order=new Order(hardwareQuantity, HardwareSrNo, customer2, hardwareName, "NC", (java.sql.Date) orderdate,actualprice,discountedprice);
		    OrderServiceImpl osi=new OrderServiceImpl();
		    osi.addOrderDetails(order);
		    return order;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Function to place order for software
	 */
	@Override
	public Order PlaceSoftwareOrder(SoftwareDetails softwareDetails,int customerId) {
		int SoftwareSrNo=softwareDetails.getSoftwareSrNo();
		SoftwareDetailsService softwareDetailsService = new SoftwareDetailsServiceImpl();
		SoftwareDetails detailsOfSoftwareOrder= softwareDetailsService.getSoftwareDetails(SoftwareSrNo);
		String softwareName = softwareDetails.getSoftwareName();
		int softwareQuantity = softwareDetails.getSoftwareQuantity();
	    java.sql.Date orderdate = new java.sql.Date((2017-1900), 12, 12);
	    int Squantity=detailsOfSoftwareOrder.getSoftwareQuantity();
	    /**
	     * condition to check the quantity order and quantity present in the table
	     */
		if(Squantity>=softwareQuantity)
		{
	
		    int actualprice,discountedprice;
		    actualprice=softwareDetails.getSoftwareQuantity()*detailsOfSoftwareOrder.getSoftwarePrice();
		    int discount=15;
		    discountedprice=actualprice-(discount*actualprice)/100;
		    System.out.println("actualprice"+actualprice);
		    System.out.println("discounted price"+discountedprice);
		    Squantity=Squantity-softwareQuantity;
		    detailsOfSoftwareOrder.setSoftwareQuantity(Squantity);
		    softwareDetailsService.updateSoftwareDetails(detailsOfSoftwareOrder);
		     
		    
		    CustomerDaoImpl customer=new CustomerDaoImpl();
		    Customer customer2 = customer.getCustomer(customerId);
		    Order order=new Order(softwareQuantity, SoftwareSrNo, customer2, softwareName, "NC", (java.sql.Date) orderdate,actualprice,discountedprice);
		    OrderServiceImpl osi=new OrderServiceImpl();
		    osi.addOrderDetails(order);
		    return order;
		}
		else
		{
			return null;
		}
	//	softwareDetailsDaoImpl.updateSoftwareDetails(softwareDetails);
		
	}
	
	
	/**
	 * Function to calculate bulk order for hardware
	 */
	@Override
	public int bulkDiscountHardware(int SrNo,int quantity)
	{
			int discount = 0;
			int discountedPrice;
			int actual_price=0;
			int discount_flag=0;
			int finalPrice=0;
			HardwareDetails hardwareDetails =new HardwareDetails();
			
			HardwareDetailsDao hardwareDetailsDao =new HardwareDetailsDaoImpl();
			hardwareDetails = hardwareDetailsDao.getHardwareDetails(SrNo);
			int Hquantity=hardwareDetailsDao.getHardwareDetails(SrNo).getHardwareQuantity();
			/**
		     * condition to check the quantity order and quantity present in the table
		     */
			if(Hquantity>quantity)
			{
						if(quantity==1)
						{
							discount_flag=1;
							actual_price=hardwareDetailsDao.getHardwareDetails(SrNo).getHardwarePrice(); //actual price
							discount=hardwareDetailsDao.getHardwareDetails(SrNo).getHardwareDiscount();
							discountedPrice=(discount*actual_price)/100;
							finalPrice=actual_price-discountedPrice;
							quantity=Hquantity-quantity;
							hardwareDetails.setHardwareQuantity(quantity);
							hardwareDetailsDao.updateHardwareDetails(hardwareDetails);
							return finalPrice;
						
						}
						else if(quantity>=2)
						{
							discount_flag=2;
							actual_price=hardwareDetailsDao.getHardwareDetails(SrNo).getHardwarePrice(); //actual price
							discount=30;
							int totalPrice=quantity*actual_price;
							discountedPrice=(discount*totalPrice)/100;
							finalPrice=totalPrice-discountedPrice;
							quantity=Hquantity-quantity;
							hardwareDetails.setHardwareQuantity(quantity);
							hardwareDetailsDao.updateHardwareDetails(hardwareDetails);
							return finalPrice;
							
						}
						else {
							
						}
						quantity=Hquantity-quantity;
						hardwareDetails.setHardwareQuantity(quantity);
						System.out.println("Final Price of the product is : "+finalPrice);
						
			}
					return finalPrice;
	}

	/**
	 * Function for bulk order of Software 
	 * @param SrNo
	 * @param quantity
	 * @return
	 */
public int bulkDiscountSoftware(int SrNo,int quantity)
{
	int discount = 30;
	int discountedPrice;
	int actual_price=0;
	int discount_flag=0;
	int finalPrice=0;
	SoftwareDetails softwareDetails =new SoftwareDetails();
	
	SoftwareDetailsDao softwareDetailsDao =new SoftwareDetailsDaoImpl();
	softwareDetails = softwareDetailsDao.getSoftwareDetails(SrNo);
	int Hquantity=softwareDetailsDao.getSoftwareDetails(SrNo).getSoftwareQuantity();
	/**
     * condition to check the quantity order and quantity present in the table
     */
	if(Hquantity>quantity)
	{
				if(quantity==1)
				{
					discount_flag=1;
					SoftwareDetails softwareDetails2 = softwareDetailsDao.getSoftwareDetails(SrNo);
					actual_price =softwareDetails2.getSoftwarePrice(); //actual price
					
				softwareDetails2=softwareDetailsDao.getSoftwareDetails(SrNo);
				discount = softwareDetails2.getSoftwareDiscount();
				discountedPrice=(discount*actual_price)/100;
				finalPrice=actual_price-discountedPrice;
				Hquantity=Hquantity-quantity;
				softwareDetails.setSoftwareQuantity(Hquantity);
				softwareDetailsDao.updateSoftwareDetails(softwareDetails);
				return finalPrice;
				
				}
				else if(quantity>=2)
				{
					discount_flag=2;
					actual_price=softwareDetailsDao.getSoftwareDetails(SrNo).getSoftwarePrice(); //actual price
					int totalPrice=quantity*actual_price;
					discountedPrice=(discount*totalPrice)/100;
					finalPrice=totalPrice-discountedPrice;
					Hquantity=Hquantity-quantity;
					softwareDetails.setSoftwareQuantity(Hquantity);
					softwareDetailsDao.updateSoftwareDetails(softwareDetails);
					return finalPrice;
				}
				else {
					
				}
				Hquantity=Hquantity-quantity;
				softwareDetails.setSoftwareQuantity(Hquantity);
				System.out.println("Final Price of the product is : "+actual_price);
							
	}
	return finalPrice;	
}


}
	


