<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Settings List</title>
</head>
<body>
<h1>List of Settings</h1>
<table border="1">
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spam Filter</th>
        <th>Signature</th>
    </tr>
    <c:forEach var="setting" items="${settingsList}">
        <tr>
            <td>${setting.language}</td>
            <td>${setting.pageSize}</td>
            <td>${setting.spamFilter ? 'Enabled' : 'Disabled'}</td>
            <td>${setting.signature}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
