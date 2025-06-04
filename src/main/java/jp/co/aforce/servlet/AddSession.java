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

import jp.co.aforce.beans.Users;

/**
 * Servlet implementation class AddSession
 */
@WebServlet("/views/AddSession")
public class AddSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSession() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String errorMessage = null;
		
		

		
		
		
		//入力値を取得
		String member_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String address = request.getParameter("address");
		String mail_address = request.getParameter("mail_address");
		
		
		//エラーがあった場合にメッセージを追加
		//IDエラー
		if(member_id == null || member_id.trim().isEmpty()) {
			errorMessage = "会員IDは必須です。";
			
		//パスワードエラー
		} else if(password == null || password.trim().isEmpty()) {
			errorMessage = "パスワードは必須です。";
		} else if (password.length() <= 7 || password.length() > 10) {
			errorMessage = "パスワードは7文字以上10文字以下で入力してください。";
			
		//名前（姓）エラー
		}else if(last_name == null || last_name.trim().isEmpty()) {
			errorMessage = "姓は必須です。";
			
		//名前（名）エラー
		} else if(first_name == null || first_name.trim().isEmpty()) {
			errorMessage = "名は必須です。";
			
		//住所エラー
		} else if (address == null || address.trim().isEmpty()) {
			errorMessage = "住所は必須です。";
			
		//メールアドレスエラー
		}else if (mail_address == null || mail_address.trim().isEmpty()) {
			errorMessage = "メールアドレスは必須です。";
		}
		
		// メールアドレスの正規表現
		String emailRegex = "^(?![.-])[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(mail_address);
		
		if(!matcher.matches()) {
			errorMessage = "メールアドレスが不正です";
		}
		
		
		
		//エラーがあった場合にはメッセージを飛ばす
		if (errorMessage != null) {
	        request.setAttribute("errorMessage", errorMessage);
	        request.getRequestDispatcher("registration.jsp").forward(request, response);
	        return;
	    }
		
		
		
		//以上のエラーチェックを抜けたらBeanの型に詰め込んでセッション化
		Users userBean = new Users();
        userBean.setMember_id(member_id);
        userBean.setPassword(password);
        userBean.setLast_name(last_name);
        userBean.setFirst_name(first_name);
        userBean.setAddress(address);
        userBean.setMail_address(mail_address);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("userBean", userBean);
        
        request.getRequestDispatcher("registrationConfirm.jsp").forward(request, response);

		
		
	}

}
