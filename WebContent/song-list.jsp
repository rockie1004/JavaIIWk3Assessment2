<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style type="text/css">
td
{
    padding:0 15px;
}
</style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song List</title>
</head>
<body>
<table>
<c:forEach items="${requestScope.allSongs}" var="currentitem">
<tr>
<td><input type="radio" name ="id" value="${currentitem.id}"></td>
<td>${currentitem.artist}</td>
<td>${currentitem.title}</td>
</tr>
</c:forEach>
</table>
</body>
</html>