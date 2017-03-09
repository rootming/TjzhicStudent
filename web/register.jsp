<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>高职专升本报名系统 | 注册</title>
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
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <h1>高职专升本报名系统</h1>
  </div>

  <div class="register-box-body">
    <div class="login-box-logo"><img src="img/logo.png"/></div>


    <form action="RegisterHandle" method="post">
      <div class="form-group has-feedback">
        <input name="username" id="username" type="text" class="form-control" placeholder="姓名">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input name="email" id="email" type="text" class="form-control" placeholder="邮箱">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input name="password" id="password" type="password" class="form-control" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input name="confirmpassword" id="confirmpassword" type="password" class="form-control" placeholder="确认密码">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div  class="form-group has-feedback">
        <input name="code" id="code" type="text" class="form-control" placeholder="验证码">
      </div>

      <div class="row">
        <div class="col-xs-6">
          <button id="reset" type="reset" class="btn btn-primary btn-block btn-flat">清除</button>
        </div>
        <!-- /.col -->
        <div class="col-xs-6">
          <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
        </div>


        <!-- /.col -->
      </div>
      <a href="login.jsp">登陆已有账号</a>
      <%
        String message = (String) request.getAttribute("message");
        if(message != null && !message.equals("")) {
          out.print("<p class=\"login-box-msg\" id=\"message\" style=\"color: red;\">" + message + "</p>");
        }
        else {
          out.print("<p class=\"login-box-msg\" id=\"message\" style=\"display: none;\"></p>");
        }
      %>
    </form>

  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->
<div class="lockscreen-footer text-center">
  Copyright &copy; 2014-2017 <b><a href="https://github.com/rootming" class="text-black">rootming </a></b><br>
  All rights reserved
</div>
<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="dist/js/tool/reg-check.js"></script>

</body>
</html>
