package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.dao.ShoppingSiteDao;

/**
 * Servlet implementation class Update
 */
@WebServlet("/views/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String last_name = (String)session.getAttribute("last_name");
		String first_name = (String)session.getAttribute("first_name");
		String mail_address = (String)session.getAttribute("mail_address");

		String member_id = (String)session.getAttribute("user_id");
		
		
		
		ShoppingSiteDao updateDao = new ShoppingSiteDao();
		
		try {
			int updatedRows = updateDao.updateUser(member_id, last_name, first_name, mail_address);
			
			//更新が正しくできたか
			if(updatedRows > 0) {
				String Name = updateDao.getInfo(member_id);
				session.setAttribute("fullname", Name);
				response.sendRedirect("updatedSuccess.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
