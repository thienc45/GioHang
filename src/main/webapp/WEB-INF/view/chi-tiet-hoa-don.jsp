<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chi tiết hóa đơn</title>
</head>
<body>
<h1>Chi tiết hóa đơn: ${hoaDon.maHoaDon}</h1>

<h2>Tổng tiền: ${tongTien}</h2>

<table>
    <tr>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Thành tiền</th>
    </tr>
    <c:forEach items="${chiTietSanPham}" var="chiTiet">
        <tr>
            <td>${chiTiet.key}</td>
            <td>${chiTiet.value}</td>
            <td>${hoaDonChiTietList[0].donGia}</td> <!-- Lấy giá trị đơn giá từ phần tử đầu tiên trong danh sách -->
            <td>${chiTiet.value * hoaDonChiTietList[0].donGia}</td> <!-- Tính tổng tiền -->
        </tr>
    </c:forEach>
</table>
</body>
</html>
