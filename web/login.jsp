<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>高职专升本报名系统 | 登陆</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="dist/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="dist/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="dist/js/html5shiv.min.js"></script>
    <script src="dist/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <h1>高职专升本报名系统</h1>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <div class="login-box-logo"><img src="img/logo.png"/></div>
        <p class="login-box-msg">登陆以继续操作</p>

        <form action="LoginHandle" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="邮箱" name="email">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="密码" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <a href="register.jsp" class="text-center">注册账号</a>
                    <%--<div class="checkbox icheck">--%>
                        <%--<label>--%>
                            <%--<input type="checkbox"> 记住密码--%>
                        <%--</label>--%>
                    <%--</div>--%>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>
                </div>
                <!-- /.col -->
            </div>

        </form>

        <!-- /.social-auth-links -->
        <%
            String message = (String) request.getAttribute("message");
            if(message != null && !message.equals("")) {
                out.print("<p class=\"login-box-msg\" id=\"message\" style=\"color: red;\">" + message + "</p>");
            }
            else {
                out.print("<p class=\"login-box-msg\" id=\"message\" style=\"display: none;\"></p>");
            }
        %>
        <%--<a href="#">忘记密码</a><br>--%>


    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<div class="lockscreen-footer text-center">
    Copyright &copy; 2014-2017 <b><a href="http://github.com/rootming" class="text-black">rootming </a></b><br>
    All rights reserved
</div>
<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script src="dist/js/tool/reg-check.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>
