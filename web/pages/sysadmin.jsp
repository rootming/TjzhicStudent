<%@ page import="rootming.tjzhic.model.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="rootming.tjzhic.utils.ModelUtils" %>
<%@ page import="java.lang.reflect.InvocationTargetException" %>
<%@ page import="rootming.tjzhic.model.Group" %><%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/6
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>管理员维护</h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
        <li class="active">管理员维护</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <!-- Your Page Content Here -->
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">已添加的管理员列表</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-6"></div><div class="col-sm-6"></div></div><div class="row"><div class="col-sm-12"><table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
                <thead>
                <tr role="row">
                    <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="">序号</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">管理员名</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">管理员用户组</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">管理员邮箱</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">密码清除</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">删除用户</th>
                </tr>
                </thead>
                <tbody>
                <%
                    LinkedList<Object> users;
                    LinkedList<Object> groups;
                    try {
                        users = ModelUtils.queryObjectLike(User.class, "user_group", "%admin");
                        groups = ModelUtils.queryObjectLike(Group.class, "group_name", "%admin");


                        for(int i = 0; i < users.size(); i++) {
                            User user = (User)users.get(i);
                            out.print("<tr role=\"row\" class=\"odd\">");
                            out.print("<td>" + i + "</td>");
                            out.print("<td>" + user.getName() + "</td>");
                            for(int j = 0; j < groups.size(); j++) {
                                Group group = (Group)groups.get(j);
                                if(group.getGroupName().equals(user.getGroup())) {
                                    out.print("<td>" + group.getGroupInfo() + "</td>");
                                    break;
                                }
                            }
                            out.print("<td>" + user.getEmail() + "</td>");
                            out.print("<td><button type=\"button\" class=\"btn btn-block btn-warning\">清除</button></td>");
                            out.print("<td><button type=\"button\" class=\"btn btn-block btn-danger\">删除</button></td>");
                            out.print("</tr>");
                        }
                    } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }

                %>

                </tbody>
                <tfoot>
                <tr><th rowspan="1" colspan="1">序号</th><th rowspan="1" colspan="1">管理员名</th><th rowspan="1" colspan="1">管理员用户组</th><th rowspan="1" colspan="1">管理员邮箱</th><th rowspan="1" colspan="1">清除密码</th></tr>
                </tfoot>
            </table>
            </div>
            </div>
                <%--<div class="row">--%>
                    <%--<div class="col-sm-5">--%>
                        <%--<div class="dataTables_info" id="example2_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div>--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-7">--%>
                        <%--<div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">--%>
                            <%--<ul class="pagination">--%>
                                <%--<li class="paginate_button previous disabled" id="example2_previous">--%>
                                    <%--<a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>--%>
                                <%--</li>--%>
                                <%--<li class="paginate_button active">--%>
                                    <%--<a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0">1</a></li>--%>
                                <%--<li class="paginate_button ">--%>
                                    <%--<a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0">2</a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            </div>
        </div>
        <!-- /.box-body -->
    </div>
    <script>
        window.onload = function () {
            $(".btn.btn-block.btn-danger").click(function () {
                var td = $(this).parent().parent().children()[3];
                var email = $(td).text();
                console.log("Delete: " + email);
                $ajax({
                    type: "post",
                    url: "APIHandle?cmd=del_admin" + "&" + email,
                    beforeSend: function(XMLHttpRequest){
                    },
                    success: function(data){
                        // alert(addr);
                        $(".content-wrapper" ).load(addr, function() {
                            console.log("API execute done");
                            $(this).parent().parent().hide();
                        });
                    },
                    error: function(){
                        //请求出错处理
                        console.error("API execute error");
                    }
                    });
                });
        };
    </script>

</section>
<!-- /.content -->