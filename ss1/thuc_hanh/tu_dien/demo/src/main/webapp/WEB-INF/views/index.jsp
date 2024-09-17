<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Từ điển Anh-Việt</h1>
<form action="translate" method="post">
  <label for="words">Nhập từ</label>
  <input type="text" id="words" name="words">
  <button type="submit">Dịch</button>
</form>
<h3>Kết quả</h3>
<p>Nghĩa tiếng Việt: ${meaning}</p>
</body>
</html>