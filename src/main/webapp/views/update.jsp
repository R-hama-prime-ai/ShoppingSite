<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報修正画面</title>
</head>
<body>

	<%--エラー検出された時のメッセージ表示 --%>
	<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
	<% if (errorMessage != null){ %>
	<p style="color: red;"><%= errorMessage %></p>
	<%} %>



	<h1>登録情報修正画面</h1>
	<form action="UpdateSession" method="post">
		<p>
			名前（姓）：<input type="text" name="last_name" required>
		</p>
		<p>
			名前（名）：<input type="text" name="first_name" required>
		</p>
		<p>
			メールアドレス：<input type="email" name="mail_address" required>
		</p>

		<input type="submit" value="修正する">
	</form>

</body>
</html>