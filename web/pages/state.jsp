<%@ page import="rootming.tjzhic.utils.ModelUtils" %>
<%@ page import="rootming.tjzhic.model.User" %>
<%@ page import="java.lang.reflect.InvocationTargetException" %>
<%@ page import="rootming.tjzhic.handle.LoginHandle" %><%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/6
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    int userCount = 0;
    int adminCount = 0;
    //ServletContext context = session.getServletContext();
    int onlineCount = LoginHandle.getActiveSessions();
    try {
        userCount = ModelUtils.queryObject(User.class, "user_group", "user").size();
        adminCount = ModelUtils.queryAllObject(User.class).size() - userCount;
    } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
    }

%>


    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>系统状态<small>简略信息</small></h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
            <li class="active">系统状态</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">

        <!-- Your Page Content Here -->

        <div class="row">
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-aqua">
                    <div class="inner">
                        <h3><%=userCount%></h3>

                        <p>注册人数</p>
                    </div>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-green">
                    <div class="inner">
                        <h3><%=adminCount%></h3>

                        <p>系统管理员数量</p>
                    </div>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-yellow">
                    <div class="inner">
                        <h3><%=onlineCount%></h3>

                        <p>在线人数</p>
                    </div>
                </div>
            </div>
            <!-- ./col -->

        </div>

    </section>
    <!-- /.content -->