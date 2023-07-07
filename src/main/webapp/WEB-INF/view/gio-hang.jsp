<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<h1>Giỏ hàng</h1>
<c:if test="${not empty hoaDon}">
    <h2>Hóa đơn: ${hoaDon.id}</h2>
    <table>
        <tr>
            <th>Sản phẩm</th>
            <th>Giá</th>
        </tr>
        <c:forEach items="${hoaDon.chiTietSPList}" var="chiTietSP">
            <tr>
                <td>${chiTietSP.tenSanPham}</td>
                <td>${chiTietSP.gia}</td>
            </tr>
        </c:forEach>
    </table>
    <p>Tổng tiền: ${hoaDon.tongTien}</p>
</c:if>
</body>
</html>
