<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録ページ</title>
</head>
<body>
	<h1>新規会員登録</h1>
	
	<%--エラー検出された時のメッセージ表示 --%>
	<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
	<% if (errorMessage != null){ %>
		<p style="color: red;"><%= errorMessage %></p>
	<%} %>


	<%--セッションで保持するためのサーブレットに送る --%>
	<form action="AddSession" method="post">
		<p>
			ユーザーID：<input type="text" name="user_id" size="10" required>半角英数字
		</p>
		<p>
			パスワード：<input type="text" name="password" size="32" required>半角英数字
		</p>
		<p>
			名前（姓）：<input type="text" name="last_name" required>
		</p>
		<p>
			名前（名）：<input type="text" name="first_name" required>
		</p>
		<p>
			住所：<input type="text" name="address" required>
		</p>
		<p>
			メールアドレス：<input type="email" name="mail_address" required>
		</p>
		<input type="submit" value="確認"> <input type="reset"
			value="リセット">
	</form>

	<a href="login-in.jsp">ログイン画面へ戻る</a>

</body>
</html>