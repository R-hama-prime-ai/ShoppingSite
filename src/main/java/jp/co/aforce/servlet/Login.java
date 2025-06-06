package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Users;
import jp.co.aforce.dao.ShoppingSiteDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/views/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String member_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		//System.out.println("ログイン中");
		
		ShoppingSiteDao checkDao = new ShoppingSiteDao();
		try {
			List<Users> users = checkDao.getAllUsers();
			
			boolean checkedUser = false;
			
			if(users != null) {
				for(Users user : users) {
					if(user.getMember_id().equals(member_id) && user.getPassword().equals(password)) {
						checkedUser = true;
						break;
					}
				}
			}
			
			if(checkedUser) {
				HttpSession session = request.getSession();
				session.setAttribute("user_id", member_id);
				
				String Name = checkDao.getInfo(member_id);
				session.setAttribute("fullname", Name);
				
				response.sendRedirect("user-menu.jsp"); //フォワードのほうが良き？
				
				//確認用 System.out.println(session.getAttribute("user_id"));
				
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login-error.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
		
		
	}

}
