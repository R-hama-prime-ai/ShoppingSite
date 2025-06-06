<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報修正確認画面</title>
</head>
<body>

<h1>修正情報はこちらでよろしいでしょうか</h1>

<%
String last_name = (String) session.getAttribute("last_name");
%>
<%
String first_name = (String) session.getAttribute("first_name");
%>
<%
String mail_address = (String) session.getAttribute("mail_address");
%>


<form action="Update" method="post">

	<p>名前（姓）：<%=last_name%></p>
	<p>名前（名）：<%=first_name%></p>
	<p>メールアドレス：<%=mail_address%></p>

		<input type="submit" value="確認">
	</form>

</body>
</html>