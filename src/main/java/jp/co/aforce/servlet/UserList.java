package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Users;
import jp.co.aforce.dao.ShoppingSiteDao;

@WebServlet("/views/user_list")
public class UserList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ShoppingSiteDao ssDao = new ShoppingSiteDao();
		try {
			List<Users> users = ssDao.getAllUsers();

			request.setAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//管理者画面にuser情報を渡す
		request.getRequestDispatcher("user-menue.jsp").forward(request, response);
	}


}
