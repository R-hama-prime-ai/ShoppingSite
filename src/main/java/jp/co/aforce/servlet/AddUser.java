package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Users;
import jp.co.aforce.dao.ShoppingSiteDao;

/**
 * Servlet implementation class UserAdd
 */
@WebServlet("/views/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Users userBean = (Users) session.getAttribute("userBean");
		ShoppingSiteDao addUserDao = new ShoppingSiteDao();
		
		try {
			addUserDao.addUser(userBean.getMember_id(), userBean.getPassword(), userBean.getLast_name(), userBean.getFirst_name(), userBean.getAddress(), userBean.getMail_address());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("addUserSuccess.jsp");
		session.invalidate();
		
	}

}
