<%@ page import="rootming.tjzhic.utils.MenuUtils" %>
<%@ page import="rootming.tjzhic.model.Menu" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/4
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<%=logoFile%>" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%=username%></p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <%--<form action="#" method="get" class="sidebar-form">--%>
        <%--<div class="input-group">--%>
        <%--<input type="text" name="q" class="form-control" placeholder="Search...">--%>
        <%--<span class="input-group-btn">--%>
        <%--<button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>--%>
        <%--</button>--%>
        <%--</span>--%>
        <%--</div>--%>
        <%--</form>--%>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <!-- Optionally, you can add icons to the links -->
            <%
                if(menus.size() > 0) {
                    for (int i = 0; i < menus.size(); i++) {
                        if (menus.get(i).size() > 1) {
                            out.print(" <li class=\"treeview\">");
                            out.print("<a href=\"#\"><i class=\"fa fa-link\"></i> <span>" + menus.get(i).get(0).getMenuName() + "</span>");
                            out.print("<span class=\"pull-right-container\">");
                            out.print("<i class=\"fa fa-angle-left pull-right\"></i>");
                            out.print("</span>");
                            out.print("</a>");
                            out.print("<ul class=\"treeview-menu\">");

                            for (int j = 1; j < menus.get(i).size(); j++) {
                                out.print("<li><a href=\"javascript:void(0);\" url=\"" + menus.get(i).get(j).getMenuUrl() + "\">" + menus.get(i).get(j).getMenuName() + "</a></li>");
                            }
                            out.print("</ul>");
                        } else {
                            if (i == 0) {
                                out.print("<li class=\"active\"><a href=\"javascript:void(0);\" url=\"" + menus.get(0).get(0).getMenuUrl() + "\"><i class=\"fa fa-link\"></i> <span>" + menus.get(0).get(0).getMenuName() + "</span></a></li>");
                            } else {
                                out.print("<li><a href=\"javascript:void(0);\" url=\"" + menus.get(i).get(0).getMenuUrl() + "\"><i class=\"fa fa-link\"></i> <span>" + menus.get(i).get(0).getMenuName() + "</span></a></li>");
                            }
                        }
                    }
                }
            %>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>