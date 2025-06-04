<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="jp.co.aforce.beans.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認用画面</title>
</head>

<body>

	<h1>登録する内容はこちらでよろしいですか？</h1>

	<%
	Users userBean = (Users) session.getAttribute("userBean");
	%>
<form action="AddUser" method="post">

	<p>ユーザーID：<%=userBean.getMember_id()%></p>
	<p>パスワード：<%=userBean.getPassword()%></p>
	<p>名前（姓）：<%=userBean.getLast_name()%></p>
	<p>名前（名）：<%=userBean.getFirst_name()%></p>
	<p>住所：<%=userBean.getAddress()%></p>
	<p>メールアドレス：<%=userBean.getMail_address()%></p>

		<input type="submit" value="登録">
	</form>


</body>
</html>