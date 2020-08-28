<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <style>
        .container{
            width: 400px;
        }
    </style>
</head>
<body>
123456789
<div class="container">
    <div class="row" >
        <div class="col-md-12">


            <form class="form-horizontal"  method = "post" enctype="multipart/form-data">

                <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">name</label>
                    <div class="col-sm-10">
                        <input type="text"  name="name" class="form-control" id="inputName" placeholder="name">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputSexy" class="col-sm-2 control-label">sexy</label>
                    <div class="col-sm-10">
                        <input type="text"  name="sexy" class="form-control" id="inputSexy" placeholder="性别">
                    </div>
                </div>

                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">age</label>
                    <div class="col-sm-10">
                        <input type="text"  name="age" class="form-control" id="age" placeholder="年龄">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputDepartment" class="col-sm-2 control-label">department</label>
                    <div class="col-sm-10">
                        <input type="text"  name="sex" class="form-control" id="inputDepartment" placeholder="部门">
                    </div>
                </div>

                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">图片上传</label>
                    <div class="col-sm-10">
                        <input type = "file" name = "file"/><br>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button onclick="addEmployee()" type="submit" class="btn btn-success">添加</button>
                    </div>
                </div>
            </form>



        </div>
    </div>
</div>
</body>
</html>
<script>
    function addEmployee(){
        var form = document.forms[0];
        form.action = "addEmployee";
        form.method = "post";
        form.submit();
    }
</script>