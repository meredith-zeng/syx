<%--
  Created by IntelliJ IDEA.
  User: liuquan
  Date: 2020/8/1
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="/toimgload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"><br><br>
    <input type="submit" value="上传">
</form>
</body>
</html>