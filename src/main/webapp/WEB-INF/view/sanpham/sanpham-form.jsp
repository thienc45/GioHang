<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm/Sửa sản phẩm</title>
</head>
<body>
<h1>Thêm/Sửa sản phẩm</h1>
<form:form action="/sanpham/create" method="post" modelAttribute="sanpham">
    <form:hidden path="id" />
    <label>Tên:</label>
    <form:input path="ten" />
    <!-- Thêm các trường khác của sản phẩm -->
    <button type="submit">Lưu</button>
</form:form>
</body>
</html>
