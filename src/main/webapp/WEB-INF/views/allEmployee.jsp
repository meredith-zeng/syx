<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>员工管理</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <a class="btn btn-primary" href="/employee/toAddEmployee">新增</a>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <a class="btn btn-primary" href="/loginout">登出</a>
        </div>
    </div>

<%--    <div class="row">--%>
<%--        <div class="col-md-4 col-md-offset-8">--%>
<%--            <a class="btn btn-primary" href="/toImgUpload">文件</a>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover table-striped">
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>sex</th>
                    <th>age</th>
                    <th>department</th>
                    <th>img</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${employeeList}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.sexy}</td>
                        <td>${employee.age}</td>
                        <td>${employee.department}</td>
                        <td><img src="${employee.img}"></td>
                        <td>
                            <a type="button"  href="${path}/employee/toUpdate?id=${employee.id}" class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑</a>
                            <a type="button"  href="${path}/employee/delEmployee?id=${employee.id}" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true" ></span>
                                删除</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>
