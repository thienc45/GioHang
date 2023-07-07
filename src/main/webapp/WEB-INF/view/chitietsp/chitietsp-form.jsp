<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm/Sửa chi tiết sản phẩm</title>
</head>
<body>
<h1>Thêm/Sửa chi tiết sản phẩm</h1>

<form:form action="/chitietsp/save" method="post" modelAttribute="chitietsp">
    <form:hidden path="id" />

    <label>Mã Chi Tiết Sản Phẩm:</label>
    <form:input path="maCTSP" />

    <label>ID Sản Phẩm:</label>
    <form:input path="idsp" />

    <label>ID Đồng Sản Phẩm:</label>
    <form:input path="iddongsp" />

    <label>ID Màu Sắc:</label>
    <form:input path="idmausac" />

    <label>ID Chất Liệu:</label>
    <form:input path="idchatlieu" />

    <label>ID Size:</label>
    <form:input path="idsize" />

    <label>ID Nhà Sản Xuất:</label>
    <form:input path="idnsx" />

    <!-- Thêm các trường khác của chi tiết sản phẩm -->

    <input type="submit" value="Lưu" />
</form:form>
</body>
</html>
