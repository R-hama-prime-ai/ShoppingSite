<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<%--アクションでメニュー、エラーを判断するサーブレットに情報を送る --%>
<form action="Login" method="post">
	<p>ユーザID</p>
	<input type="text" name="user_id" size="10" required>
	
	<p>パスワード</p>
	<input type="password" name="password" size="32" required><br>
	
	<input type="submit" value="ログイン">
</form>

<%--新規会員登録用insertのサーブレットに飛ばす --%>
<form method="post">
	<input type="submit" value="新規会員登録">
</form>

</body>
</html>