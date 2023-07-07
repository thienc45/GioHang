<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="<c:url value="/login" />" method="POST">
    <label for="username">MANV:</label>
    <input type="text" id="username" name="username" required/><br/><br/>
    <label for="password">MATKHAU:</label>
    <input type="password" id="password" name="password" required/><br/><br/>
    <input type="submit" value="Đăng nhập"/>
</form>
</body>
</html>
