<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>修改用户信息</h1>
    <form action="${pageContext.request.contextPath}/employee/getAllEmployee" method="post" name="userForm">
        <input value="${employee.id}" name="id" type="hidden"/>
        name:<input type="text" name="name" value="${employee.name}"><br>
        sexy:<input type="text" name="sexy" value="${employee.sexy}"><br>
        age:<input type="text" name="age" value="${employee.age}"><br>
        department:<input type="text" name="department" value="${employee.department}"><br>
        <input type="submit" value="确认修改" onclick="updateEmployee()"> </input>
    </form>
</body>
</html>
<script>
    alert(${user.id});
    function updateEmployee(){
        var form = document.forms[0];
        form.action = "<%=basePath%>employee/updateEmployee";
        form.method = "post";
        form.submit();
    }
</script>
