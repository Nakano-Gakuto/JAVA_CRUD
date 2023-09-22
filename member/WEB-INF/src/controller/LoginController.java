package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.LoginUser;
import service.LoginService;
//action="login"のloginを合言葉に値を受け取ることができる
@WebServlet("/login")
//クラス画面から値を受け取ったり、渡したりする必要がある役割があるのでextends HttpServletを記述している
public class LoginController extends HttpServlet {
//POST送信された値がdoPostメソッドに送信されます。というサーブレットが用意している。変数requestの中に送信された値が格納されている。
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getParamerer("")でインプットフォームを送ってます
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//loginメソッドにemail,passwordの値を渡し名前を取得
		String nextPage = "";
		LoginService loginService = new LoginService();
		String name = loginService.login(email,password);
		LoginUser loginUser = new LoginUser();
		if("".equals(name)) {
			//名前が取得出来なかった＝ログイン出来なかった時の処理
			nextPage ="error.jsp";
		} else {
			//ログインした時の処理
			loginUser.setEmail(email);
			loginUser.setName(name);
			nextPage ="mypage.jsp";
		}
		request.setAttribute("loginUser", loginUser);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + nextPage).forward(request, response);
	}
}