<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="post">
  <input type="checkbox" id="lettuce" name="condiment" value="lettuce">
  <label for="lettuce" style="font-size: xx-large">Lettice</label>
  <input type="checkbox" id="tomato" name="condiment" value="tomato">
  <label for="tomato" style="font-size: xx-large">Tomato</label>
  <input type="checkbox" id="mustard" name="condiment" value="mustard">
  <label for="mustard" style="font-size: xx-large">Mustard</label>
  <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
  <label for="sprouts" style="font-size: xx-large">Sprouts</label>
  <button type="submit" >Save</button>
</form>
<c:forEach var="s" items="${condiment}">
  ${s}
</c:forEach>
</body>
</html>