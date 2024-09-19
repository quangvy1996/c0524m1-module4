<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Setting</title>
</head>
<body>
<form:form modelAttribute="settings" action="${pageContext.request.contextPath}/updateSettings" method="post">
  <table>
    <tr>
      <td>Language:</td>
      <td><form:select path="language">
        <form:option value="English">English</form:option>
        <form:option value="Vietnamese">English</form:option>
        <form:option value="Japanese">English</form:option>
        <form:option value="Chinese">English</form:option>
      </form:select></td>
    </tr>
    <tr>
      <td>Page size:</td>
      <td><form:select path="pageSize">
        <form:option value="5">5</form:option>
        <form:option value="10">10</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
      </form:select></td>
    </tr>
    <tr>
      <td>Spam Filter:</td>
      <td><form:checkbox path="spamFilter"/></td>
    </tr>
    <tr>
      <td>Signature:</td>
      <td><form:textarea path="signature" rows="2" cols="30"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Update"/></td>
      <td><form:button onclick="location.href='${pageContext.request.contextPath}/listSettings'">Cancel</form:button></td>
    </tr>
  </table>
</form:form>
</body>
</html>