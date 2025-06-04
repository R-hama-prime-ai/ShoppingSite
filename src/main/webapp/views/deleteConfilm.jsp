<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報削除確認画面</title>
</head>
<body>
<h1>本当に削除しますか？</h1>
<form action="DeleteUser" method="post">
<input type="submit" value="削除">
</form>

<form action="user-menu.jsp" method="post">
<input type="submit" value="戻る">
</form>

</body>
</html>