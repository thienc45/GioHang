<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Danh sách hóa đơn</title>
</head>
<body>
<h1>Danh sách hóa đơn</h1>
<script>
    <c:if test="${not empty error}">
    alert('Số tiền không đủ để thanh toán!');
    </c:if>
</script>
<table>
    <tr>
        <th>Mã hóa đơn</th>
        <th>Ngày tạo</th>
        <th>Ma</th>
        <th>Trạng Thái</th>
        <th>Tổng tiền</th>
    </tr>
    <c:forEach items="${hoaDonList}" var="hoaDon">
        <tr>
            <td>${hoaDon.id}</td>
            <td>${hoaDon.ngayTao}</td>
            <td>${hoaDon.maHoaDon}</td>
            <td>${hoaDon.trangThai}</td>
            <td>${hoaDon.tongTien}</td>

            <td>
                <a href="/giohang/chi-tiet/${hoaDon.id}">Xem chi tiết</a>
            </td>
            <td>
                <form method="POST" action="/giohang/thanh-toan/${hoaDon.id}">
                    <input type="hidden" name="hoaDonId" value="${hoaDon.id}">
                    <label for="soTien">Số tiền khách hàng:</label>
                    <input type="number" name="soTien" id="soTien">
                    <button type="submit">Thanh toán</button>
                </form>
            </td>
            <c:if test="${hoaDon.trangThai != 2}">
                <td>
                    <a href="/giohang/them-san-pham/${hoaDon.id}">Thêm sản phẩm</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<td><a href="/giohang/tao-hoa-don">Thêm hóa đơn</a></td>
</body>
</html>
