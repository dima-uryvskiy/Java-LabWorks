<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LabWork5</title>
</head>
<body>
<form action="index.jsp" method="POST">
    <p>Name: <input type="text" name="nameFile"/></p>
    <input type="submit" value="Confirm"/></br>
</form>
<%
    String name = request.getParameter("nameFile");
    System.out.println(name);


%>
</body>
</html>