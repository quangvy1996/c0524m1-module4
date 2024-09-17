<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Currency Converter</title>
</head>
<body>
<h2>Chuyển đổi từ USD sang VNĐ</h2>
<form action="convert" method="post">
    <label for="exchangeRate">Tỉ giá USD -> VNĐ:</label>
    <input type="number" id="exchangeRate" name="exchangeRate" step="0.01" required><br><br>

    <label for="usdAmount">Số lượng USD:</label>
    <input type="number" id="usdAmount" name="usdAmount" step="0.01" required><br><br>

    <input type="submit" value="Chuyển đổi">
</form>
</body>
</html>
