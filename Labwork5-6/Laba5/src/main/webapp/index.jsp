<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LabWork5</title>
</head>
<body>
<form action="/MainServlet" method="GET">
    <p>Name: <input type="text" name="nameFile"/></p>
    <input type="submit" value="Confirm"/></br>
</form>
<img src="data:image/jpg;base64,${encodedString}" onError="this.style.display='none'" />
<p>${errorMessage}</p>
</body>
</html>