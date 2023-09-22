package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ConfirmService;


@WebServlet("/confirm")
public class CofirmController extends HttpServlet{
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String blood = request.getParameter("blood");
		String gender = request.getParameter("gender");
		String old = request.getParameter("old");
		String memo = request.getParameter("memo");
		ConfirmService confirmservice = new ConfirmService();
		confirmservice.confirmCustomer(email,password,name,gender,blood,old,memo);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "complete.jsp").forward(request, response);
	}
}