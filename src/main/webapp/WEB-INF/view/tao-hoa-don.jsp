<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo hóa đơn</title>
</head>
<body>
<h1>Tạo hóa đơn</h1>
<%--<form action="/giohang/luu-hoa-don" method="post">--%>
<%--    Mã hóa đơn: <input type="text" name="maHoaDon" /><br/><br/>--%>
<%--    Ngày tạo: <input type="date" name="ngayTao" /><br/><br/>--%>
<%--    <input type="submit" value="Tạo" />--%>
<%--</form>--%>
<form action="/giohang/luu-hoa-don" method="post">
    Mã hóa đơn: <input type="text" name="maHoaDon" /><br/><br/>
    Ngày tạo: <input type="date" name="ngayTao" id="ngayTaoInput" readonly /><br/><br/>
    <input type="submit" value="Tạo" />
</form>

<script>
    // Lấy ngày hiện tại
    var currentDate = new Date().toISOString().slice(0, 10);

    // Thiết lập giá trị mặc định cho trường ngày tạo
    document.getElementById("ngayTaoInput").value = currentDate;
</script>
</body>
</html>
