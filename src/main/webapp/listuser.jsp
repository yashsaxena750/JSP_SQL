<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%@ page import="org.example.untitled.entity.edata" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>User List</title>
</head>
<body>

<h1>User List:</h1>

<table border="1">
    <caption>user list</caption>
    <thead>

    <th>id</th>
    <th>name</th>
    <th>email</th>
    <th>password</th>

    </thead>

<%


List<edata> listuser = (List)request.getAttribute("udata");
for(edata _edata: listuser){
out.print("<tr>");
out.print("<td>"+_edata.getUserid()+"</td>");
out.print("<td>"+StringEscapeUtils.escapeHtml4(_edata.getUname())+"</td>");
out.print("<td>"+StringEscapeUtils.escapeHtml4(_edata.getUemail())+"</td>");
out.print("<td>"+StringEscapeUtils.escapeHtml4(_edata.getUpassword())+"</td>");
out.print("<tr>");
}

%>
</table>
</body>
</html>
