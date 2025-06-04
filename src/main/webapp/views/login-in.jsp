<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Home.css">
</head>
<body>

<%--メニューバーの中に新規登録ボタンを置きたい --%>

<div class="menu-bar">

	<%--新規会員登録用insertのサーブレットに飛ばす --%>
<form action="registration.jsp" method="post">
	<input type="submit" value="新規会員登録">
</form>

</div>

<%--アクションでメニュー、エラーを判断するサーブレットに情報を送る --%>
<form action="Login" method="post">
	<p>ユーザID</p>
	<input type="text" name="user_id" size="10" required>
	
	<p>パスワード</p>
	<input type="password" name="password" size="32" required><br>
	
	<input type="submit" value="ログイン">
</form>



</body>
</html>