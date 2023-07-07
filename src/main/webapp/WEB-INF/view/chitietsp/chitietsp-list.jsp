<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1>Danh sách chi tiết sản phẩm</h1>

<table class="table">
    <thead>
    <tr>

        <th scope="col">ID</th>
        <th scope="col">Mã Chi Tiết Sản Phẩm</th>
        <th scope="col">ID Sản Phẩm</th>
        <th scope="col">ID Đồng Sản Phẩm</th>
        <th scope="col">ID Màu Sắc</th>
        <th scope="col">ID Chất Liệu</th>
        <th scope="col">ID Size</th>
        <th scope="col">ID Nhà Sản Xuất</th>
        <!-- Thêm các cột khác của chi tiết sản phẩm -->
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${chitietspList}" var="chitietsp">
        <tr>
            <td>${chitietsp.id}</td>
            <td>${chitietsp.maCTSP}</td>
            <td>${chitietsp.sanPham.id}</td>
            <td>${chitietsp.dongSP.id}</td>
            <td>${chitietsp.mauSac.id}</td>
            <td>${chitietsp.chatLieu.id}</td>
            <td>${chitietsp.size.id}</td>
            <td>${chitietsp.nsx.id}</td>
            <!-- Thêm các cột khác của chi tiết sản phẩm -->
                <%--            <td><a href="/chitietsp/edit/${chitietsp.id}">Sửa</a></td>--%>
            <td><a href="/chitietsp/delete/${chitietsp.id}">Xóa</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<a href="/chitietsp/add">Thêm chi tiết sản phẩm mới</a>
</body>
</html>
