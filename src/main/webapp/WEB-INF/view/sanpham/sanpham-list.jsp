<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <!-- Thêm các cột khác của sản phẩm -->
    </tr>
    <c:forEach items="${sanphams}" var="sanpham">
        <tr>
            <td>${sanpham.id}</td>
            <td>${sanpham.ten}</td>
            <!-- Thêm các cột khác của sản phẩm -->
            <td><a href="/sanpham/delete/${sanpham.id}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>

<a href="/sanpham/create">Thêm sản phẩm mới</a>
</body>
</html>
