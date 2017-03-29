<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->

<%
    String username = (String)session.getAttribute("name");
    String email = (String)session.getAttribute("email");

    String logoFile = "";
    File file = new File(request.getRealPath("\\") + "/img/user/" + username + ".png");
    //System.out.println(file);
    if(file.exists()) {
        logoFile = logoFile + "/img/user/" + username + ".png";
    }
    else {
        logoFile = logoFile + "/img/user/default.png";
    }

    MenuUtils menuUtils = new MenuUtils();
    LinkedList<LinkedList<Menu>> menus = menuUtils.makeMenu((String)session.getAttribute("group"));
    String defaultPage;

    if(menus.size() > 0) {
       // System.out.println(menus.get(0).size());

        if (menus.get(0).size() > 1)
            defaultPage = menus.get(0).get(1).getMenuUrl();
        else
            defaultPage = menus.get(0).get(0).getMenuUrl();
    }
    else {
        defaultPage = "404.jsp";
    }

%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>天津理工大学高职专升本考试报名系统</title>
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
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.css">

    <!-- Pace style -->
    <link rel="stylesheet" href="plugins/pace/pace.min.css">

    <link rel="stylesheet" href="plugins/fullcalendar/fullcalendar.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="dist/js/html5shiv.min.js"></script>
    <script src="dist/js/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery 2.2.3 -->
    <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>

    <script src="plugins/angular/angular.min.js"></script>

    <script src="plugins/datepicker/moment.js"></script>
    <script src="plugins/datepicker/bootstrap-datepicker.js"></script>

</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="login.jsp" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>系统</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>console</b></span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="<%=logoFile%>" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs"><%=username%></span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="<%=logoFile%>" class="img-circle" alt="User Image">
                                <p>
                                    <%=email%>
                                </p>
                            </li>

                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="javascript:void(0);" class="btn btn-default btn-flat">个人信息</a>
                                </div>
                                <div class="pull-right">
                                    <a href="javascript:void(0);" url="/pages/logout.jsp" class="btn btn-default btn-flat">退出系统</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <%--<li>--%>
                        <%--<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>--%>
                    <%--</li>--%>
                </ul>
            </div>
        </nav>
    </header>

    <%@include file="pages/sidebar.jsp"%>
    <%@include file="pages/main.jsp"%>

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            天津理工大学中环信息学院
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2017 <a href="#">rootming</a>.</strong> All rights reserved.
    </footer>

    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- PACE -->
<script src="plugins/pace/pace.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>


<script>

    $(document).ajaxStart(function () {
        Pace.restart();
    });
    // 局部刷新页面
    function load(addr) {
        $.ajax({
            type: "post",
            url: addr,
            beforeSend: function(XMLHttpRequest){
            },
            success: function(data){
                // alert(addr);
                $(".content-wrapper" ).load(addr, function() {
                    console.log("reloaded page: " + addr);
                });
            },
            error: function(){
                //请求出错处理
                console.error("page not found: " + addr);
            }
        });

    }

    window.onload = function () {

        $("a[url]").click(function () {
            $("li.active").removeClass("active");
            $(this).parent().addClass("active");
            load($(this).attr("url"));
        });

    };
</script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when  using the
     fixed layout. -->
</body>
</html>
