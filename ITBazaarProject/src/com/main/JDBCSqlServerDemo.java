package com.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.*;
import com.model.Customer;
import com.model.Hardware;
import com.model.HardwareDetails;
import com.model.Order;
import com.model.SoftwareDetails;
import com.service.CustomerOrderService;
import com.service.CustomerOrderServiceImpl;

/*jdbc:sqlserver://=name of protocol SQLEXPRESS=server instance*/

public class JDBCSqlServerDemo {

	public static void main(String[] args) {
		
		OrderDao orderDao=new OrderDaoImpl();
		CustomerDao customerDao=new CustomerDaoImpl();
//		List<Order> allorders=orderDao.getAllOrderDetails();
//		for(Order o:allorders)
//		{
//			System.out.println(o);
//		}
//		Customer customer2=customerDao.getCustomer(1);
//		Order order=new Order(10, 566,customer2, "Hp", "incomplete",null);
//		
//			orderDao.addOrderDetails(order);
//		System.out.println("***************");
//		Order order=orderDao.getOrderDetails(500);
//		System.out.println(order);
		//Customer customer2=customerDao.getCustomer(7);
		//System.out.println(customer2);
//		List<Customer> allcustomer=customerDao.getAllCustomers();
//		for(Customer c:allcustomer)
//		{
//			System.out.println(c);
//		}
//		Customer customer=new Customer("657889788", "soham", "satara", "soham@gmail.com", "soham", "soham");
//		try {
//			customerDao.addCustomer(customer);
//		} catch (CustomerExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Customer customer2=customerDao.getCustomer(7);
//		System.out.println(customer2);
//		HardwareDao hardware = new HardwareDaoImpl();
//
//		
//		List<Hardware> allHardware=hardware.getAllHardwares();
//		
//		Hardware hard1=new Hardware(106, "Accessories");
//		try {
//			hardware.addHardware(hard1);
//			System.out.println(hard1);
//		} catch (HardwareExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//		System.out.println("In the JDBC SQL MAIN");
//		for(Hardware hardware1 : allHardware)
//		{
//			System.out.println(hardware1);
//		}
//		
//			//	System.out.println(hard);
//		
//		System.out.println("ALL HArdware Details");
//		HardwareDetailsDao hardwareDetails=new HardwareDetailsDaoImpl();
//		List<HardwareDetails> allHardware1=hardwareDetails.getAllHardwareDetails();
//		
//		HardwareDetails hd=new HardwareDetails(120, 200, 15, 15,new HardwareDaoImpl().getHardware(103), "Sandisk 4GB", "Sandisk", "red");
//		hardwareDetails.addHardwareDetails(hd);
//		System.out.println(hd);
//		
//		for(HardwareDetails hardware1 : allHardware1)
//		{
//			System.out.println(hardware1);
//		}
//		
//		CustomerDao cust=new CustomerDaoImpl();
//		List<Customer> allCust = cust.getAllCustomers();
//		for(Customer c : allCust)
//		{
//			System.out.println(c);
//		}
		
//		StudentServiceimpl studentserviceimpl=new StudentServiceimpl();
//		List<Student> allStudents = studentserviceimpl.getAllStudents();
//		
//		for(Student s:allStudents)
//		{
//			System.out.println(s);
//		}
//		EnrollmentServiceimpl enrollmentserviceimpl=new EnrollmentServiceimpl();
//		int exemptfees = enrollmentserviceimpl.exemptfees(111, 13,"A1101");
//		
//		
//		List<Enrollment>allenrollment=enrollmentserviceimpl.getAllEnrollment();
//		
//		Enrollment enroll=enrollmentserviceimpl.getEnrollment(101, 1);
//		System.out.println(enroll);
		
//		System.out.println("\n \n \n");
//		for(Enrollment e:allenrollment)
//		{
//			System.out.println(e);
//		}
//		
//		
//		
//		
		// List<Course> courselist = enroll.getCourselist(103); //get enrollment
		// for 103
		//
		//
		// //System.out.println(allEnrollment);
		// System.out.println("CourseList");
		// for(Course c:courselist)
		// {
		//
		// System.out.println(c);
		//
		//
		// }
	
//		System.out.println("\n \nCourseList");
//		List<Student> studentlist = enroll.getStudentlist(3);
//		for(Student s:studentlist)
//		{
//			System.out.println(s);
//		
//		}
		
//		Date valueOf = Date.valueOf("2016-08-09");
//
//		Enrollment enrollment = new Enrollment(new StudentDaoimpl().getStudent(101), new CourseDaoimpl().getcourse(3),
//				valueOf, 4000);
//		try {
//			enroll.addEnrollment(enrollment);
//		} catch (EnrollmentExistException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		/*
		 * Enrollment enrollment2 = enroll.getEnrollment(111,2);
		 * enrollment2.setFeespaid(5000); //update paid fees to 5000 of
		 * enrollment(111,2) enroll.updateEnrollment(enrollment2); enrollment2 =
		 * enroll.getEnrollment(111,2);
		 * System.out.println("new added"+enrollment2);
		 * 
		 * enrollment2 = enroll.getEnrollment(101,4);//delete enrollment with
		 * sid=101 and cid=4 enroll.deleteEnrollment(enrollment2); allEnrollment
		 * = enroll.getEnrollmentforStudent(101); //get enrollment for 103
		 */

		/*
		 * allEnrollment=enroll.getEnrollmentforCourse(1);
		 * //System.out.println(allEnrollment);
		 * System.out.println("all enrollment"); for(Enrollment e:allEnrollment)
		 * { System.out.println(e);
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * /*Student student = new StudentDaoimpl().getStudent(104);
		 * 
		 * 
		 * Course course = new CourseDaoimpl().getcourse(1); Enrollment
		 * enrollment=new Enrollment(student,course);
		 * enroll.addEnrollment(enrollment);
		 * 
		 * List<Enrollment> allEnrollment2 = enroll.getAllEnrollment();
		 * 
		 * for(Enrollment e:allEnrollment2) { //System.out.println(e);
		 * System.out.println("\n");
		 * 
		 * System.out.print(e);
		 * 
		 * }
		 * 
		 * Enrollment enrollment2 = enroll.getEnrollment(101, 1);
		 * enroll.deleteEnrollment(enrollment); allEnrollment2 =
		 * enroll.getAllEnrollment(); //System.out.println("AFTER DELETION");
		 * for(Enrollment e:allEnrollment2) { //System.out.println(e);
		 * System.out.println("\n");
		 * 
		 * System.out.print(e);
		 * 
		 * } Enrollment en = enroll.getEnrollment(101,1);//single enrollment
		 * en.getCourse().setCid(3); enroll.updateEnrollment(en); allEnrollment2
		 * = enroll.getAllEnrollment(); //System.out.println("AFTER DELETION");
		 * for(Enrollment e:allEnrollment2) { //System.out.println(e);
		 * System.out.println("\n");
		 * 
		 * System.out.print(e);
		 * 
		 * }
		 * 
		 * 
		 * /* ***********courseDaoMain******
		 * 
		 */

//		CourseDao courseDao = new CourseDaoimpl();
//
//		List<Course> courselist = courseDao.getcoursebyfees(5000);
//
//		// System.out.println(course1);
//
//		// List<Course> allCourseList=CourseDao.getAllCourses();
//
//		for (Course c : courselist) {
//			System.out.println(c);
//		}

		/*
		 * Course cr=new Course(9,"android",40,6000); try {
		 * CourseDao.addCourse(cr); } catch (CourseExistsException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * System.out.println("\n After Insertion");
		 * allCourseList=CourseDao.getAllCourses();
		 * 
		 * for(Course c:allCourseList) { System.out.println(c); }
		 */
		/*
		 * Course toupdatecourse=CourseDao.getcourse(9);
		 * toupdatecourse.setCduration(70);;
		 * CourseDao.updateCourse(toupdatecourse);
		 * 
		 * 
		 * //System.out.println("newly  updated Student"); //
		 * toupdatecourse=CourseDao.getcourse(1);
		 * //System.out.println(toupdatecourse);
		 * 
		 * Course todeleteCourse1=CourseDao.getcourse(7);
		 * CourseDao.deleteCourse(todeleteCourse1);
		 * 
		 * allCourseList=CourseDao.getAllCourses();
		 * 
		 * for(Course c:allCourseList) { System.out.println(c); }
		 */
		/*
		 * Student implemention StudentDao studentdao=new StudentDaoimpl();
		 * List<Student> allStudents = studentdao.getAllStudents();
		 * 
		 * for(Student s:allStudents) { System.out.println(s);
		 * 
		 * }
		 * 
		 * Student student = studentdao.getStudent(111);
		 * System.out.println("Student with id 111"+student);
		 * 
		 * Student stud=new
		 * Student(110,"komal","Sinhgad","komal110@gmail.com","komal@123"); try
		 * { studentdao.addStudent(stud); } catch (StudentExistsException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * System.out.println("\n After Insertion"); allStudents =
		 * studentdao.getAllStudents();
		 * 
		 * for(Student s:allStudents) { System.out.println(s);
		 * 
		 * }
		 * 
		 */
		/*
		 * StudentDao studentdao=new StudentDaoimpl(); Student
		 * toupdateStudent=studentdao.getStudent(103);
		 * toupdateStudent.setSname("Rutuja");
		 * toupdateStudent.setEmail("rutuja103@gmail.com");
		 * toupdateStudent.setInstituteName("pvg");
		 * studentdao.updateStudent(toupdateStudent); Student student =
		 * studentdao.getStudent(103); System.out.println("update"+student);
		 * 
		 * 
		 * /*Student todeleteStudent=studentdao.getStudent(110);
		 * studentdao.deleteStudent(todeleteStudent);
		 * 
		 * allStudents=studentdao.getAllStudents();
		 * 
		 * for(Student s:allStudents) { System.out.println(s); }
		 * 
		 * 
		 */

	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*OrderDao orderDao=new OrderDaoImpl();
		CustomerDao customerDao=new CustomerDaoImpl();*/
		//List<Order> allorders=orderDao.getAllOrderDetails();
		/*for(Order o:allorders)
		{
			System.out.println(o);
		}
		*/
	
		/*
		 * 
		 * KEJAL AND ME
		 * 
		 * CustomerOrderService cos=new CustomerOrderServiceImpl();
		SoftwareDetails searchSoftwareByName = cos.SearchSoftwareByName("MS Office 2016");
		
		System.out.println(searchSoftwareByName);
		cos.PlaceSoftwareOrder(searchSoftwareByName);
		
		List<Order> allOrderDetails = orderDao.getAllOrderDetails();
		
		for(Order orderDao1 : allOrderDetails)
		{
			System.out.println(orderDao1);
			
			}*/
		
			
		//Customer customer2=customerDao.getCustomer(1);
//		Order order=new Order(10, 566,customer2, "Hp", "incomplete",null);
//		
//			orderDao.addOrderDetails(order);
//		System.out.println("***************");
//		Order order=orderDao.getOrderDetails(500);
//		System.out.println(order);
		//Customer customer2=customerDao.getCustomer(7);
		//System.out.println(customer2);
		//try {
//			customerDao.addCustomer(customer);
//		} catch (CustomerExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Customer customer2=customerDao.getCustomer(7);
//		System.out.println(customer2);
//		HardwareDao hardware = new HardwareDaoImpl();
//
//		
//		List<Hardware> allHardware=hardware.getAllHardwares();
//		
//		Hardware hard1=new Hardware(106, "Accessories");
//		try {
//			hardware.addHardware(hard1);
//			System.out.println(hard1);
//		} catch (HardwareExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//		System.out.println("In the JDBC SQL MAIN");
//		for(Hardware hardware1 : allHardware)
//		{
//			System.out.println(hardware1);
//		}
//		
//			//	System.out.println(hard);
//		
//		System.out.println("ALL HArdware Details");
//		HardwareDetailsDao hardwareDetails=new HardwareDetailsDaoImpl();
//		List<HardwareDetails> allHardware1=hardwareDetails.getAllHardwareDetails();
//		
//		HardwareDetails hd=new HardwareDetails(120, 200, 15, 15,new HardwareDaoImpl().getHardware(103), "Sandisk 4GB", "Sandisk", "red");
//		hardwareDetails.addHardwareDetails(hd);
//		System.out.println(hd);
//		
//		for(HardwareDetails hardware1 : allHardware1)
//		{
//			System.out.println(hardware1);
//		}
//		
//		CustomerDao cust=new CustomerDaoImpl();
//		List<Customer> allCust = cust.getAllCustomers();
//		for(Customer c : allCust)
//		{
//			System.out.println(c);
//		}
	
	

		
	}


