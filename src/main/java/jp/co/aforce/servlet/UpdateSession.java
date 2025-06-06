package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateSession
 */
@WebServlet("/views/UpdateSession")
public class UpdateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String errorMessage = null;

		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String mail_address = request.getParameter("mail_address");
		
		//セッション化
				HttpSession session = request.getSession();
				//入力値をセッションで保持
				session.setAttribute("last_name", last_name);
				session.setAttribute("first_name", first_name);
				session.setAttribute("mail_address", mail_address);

		//名前（姓）エラー
		if (last_name == null || last_name.trim().isEmpty()) {
			errorMessage = "姓は必須です。";

			//名前（名）エラー
		} else if (first_name == null || first_name.trim().isEmpty()) {
			errorMessage = "名は必須です。";
		} else if (mail_address == null || mail_address.trim().isEmpty()) {
			errorMessage = "メールアドレスは必須です。";
		}

		// メールアドレスの正規表現
		String emailRegex = "^(?![.-])[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(mail_address);

		if (!matcher.matches()) {
			errorMessage = "メールアドレスが不正です";
		}

		//エラーがあった場合にはメッセージを飛ばす
		if (errorMessage != null) {
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		

		request.getRequestDispatcher("updateConfilm.jsp").forward(request, response);

	}

}
