package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Customer;

@WebServlet("/insert")
public class InsertController extends HttpServlet {
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String blood = request.getParameter("blood");
		String gender = request.getParameter("gender");
		int old =Integer.parseInt(request.getParameter("old"));
		String memo= request.getParameter("memo");
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setName(name);
		customer.setGender(gender);
		customer.setBlood(blood);
		customer.setOld(old);
		customer.setMemo(memo);
		request.setAttribute("customer", customer);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "confirm.jsp").forward(request, response);
	}
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String blood = request.getParameter("blood");
		String gender = request.getParameter("gender");
		int old =Integer.parseInt(request.getParameter("old"));
		String memo= request.getParameter("memo");
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setName(name);
		customer.setGender(gender);
		customer.setBlood(blood);
		customer.setOld(old);
		customer.setMemo(memo);
		request.setAttribute("customer", customer);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "insert.jsp").forward(request, response);
	}
}
