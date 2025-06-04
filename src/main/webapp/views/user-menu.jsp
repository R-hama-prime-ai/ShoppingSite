<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
</head>
<body>

<%--サーブレットからAttributeで情報取ってきて、表示する --%>
<% String fullName = (String)session.getAttribute("fullname"); %>
	<h1>ようこそ<%= fullName %> さん！</h1>
	
<%--修正ボタン、削除ボタン、ログアウトボタンを作成 --%>
	<form action="update.jsp" method="post">
	<input type="submit" value="修正">
	</form>
	
	
	<form action="deleteConfilm.jsp" method="post">
	<input type="submit" value="削除">
	</form>
	
	
	<form action="Logout" method="post">
	<input type="submit" value="ログアウト">
	</form>

</body>
</html>