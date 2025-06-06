package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


		@WebFilter("/views/*")
		public class CheckFilter implements Filter{
		    
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
		     HttpServletResponse httpResponse = (HttpServletResponse) response;
		     String uri = httpRequest.getRequestURI();
		     
		     //System.out.println("フィルター前処理");
		     //System.out.println(uri);
		
		     // ログインページやエラーページ、静的リソースへのアクセスはフィルタリングしない
		     if (uri.contains("login-in.jsp") || uri.contains("registration.jsp") || uri.contains("login-error.jsp") || uri.contains("/views/Login") || uri.contains("/css/")) {
		         chain.doFilter(request, response);
		         return;
		     }
		
		     HttpSession session = httpRequest.getSession(false);
		     if (session == null || session.getAttribute("user_id") == null) {
		    	 //System.out.println("フィルター中");
		         // セッションがない場合、ログインページへリダイレクト
		         //httpResponse.sendRedirect(httpRequest.getContextPath() + "login-in.jsp");
		    	 httpResponse.sendRedirect("login-in.jsp");
		    	 
		     } else {
		         // セッションがある場合、リクエストを続行
		         chain.doFilter(request, response);
		     }
		 }
		
		 public void init(FilterConfig filterConfig) throws ServletException {}
		
		 public void destroy() {}
		}