<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process form</title>
</head>
<jsp:useBean id="book" class="beans.BookBean" scope="session"/>
<jsp:setProperty property="*" name="book"/>
<body>
<c:redirect url="${sessionScope.book.addBook()}.jsp"/>
</body>
</html>