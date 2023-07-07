<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Thêm sản phẩm vào giỏ hàng</title>
</head>
<body>
<h1>Thêm sản phẩm vào giỏ hàng</h1>

<h3>Hóa đơn:</h3>
<p>Mã hóa đơn: ${hoaDon.id}</p>
<!-- Hiển thị các thông tin khác của hóa đơn -->

<h3>Danh sách sản phẩm:</h3>
<table>
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Thêm vào giỏ hàng</th>
    </tr>
    <c:forEach items="${chiTietSPList}" var="chiTietSP">
        <tr>
            <td>${chiTietSP.maCTSP}</td>
            <td>${chiTietSP.sanPham.ten}</td>
            <td>${chiTietSP.gia}</td>
            <td>
                <form action="/giohang/luu-san-pham" method="post">
                    <input type="hidden" name="hoaDonId" value="${hoaDon.id}">
                    <input type="hidden" name="chiTietSPId" value="${chiTietSP.id}">
                    <button type="submit">Thêm vào giỏ hàng</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/giohang/danh-sach">Quay lại danh sách hóa đơn</a>
</body>
</html>

