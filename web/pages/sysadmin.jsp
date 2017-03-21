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
<!-- Content Header (PageData header) -->
<section class="content-header">
    <h1>管理员维护</h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
        <li class="active">管理员维护</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <!-- Your PageData Content Here -->
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
//                            out.print("<td><button type=\"button\" class=\"btn btn-block btn-warning\" data-toggle=\"modal\" data-target=\"#myModal\">清除</button></td>");
//                            out.print("<td><button type=\"button\" class=\"btn btn-block btn-danger\" data-toggle=\"modal\" data-target=\"#myModal\">删除</button></td>");
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
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">确认删除</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                此操作不可逆！
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary">确认</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            </div>
            <div class="modal modal-success" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="resetModalLabel">信息</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            密码已重置为<strong>123456789</strong>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline" data-dismiss="modal" onclick="$(this).modal('hide');">确认</button>
                        </div>
                    </div>
                </div>
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
        $(".btn.btn-block.btn-danger").click(function () {
            var td = $(this).parent().parent().children()[3];
            var email = $(td).text();
            console.log("Delete: " + email);
            $.ajax({
                type: "post",
                dataType: "json",
                url: "APIHandle?cmd=del_admin" + "&arg=" + email,
                success: function(data) {
                    console.log("APIHandle?cmd=del_admin" + "&arg=" + email);
                    console.log(data);
                    //var result = eval('(' + data + ')');
                    try {
                        if (data.success == 1) {
                            $(td).parent().hide();
                            $(".modal-body").html("管理员已删除");
                            $('#infoModal').modal('show');
                            console.log("API execute done");
                        }
                        else {
                            console.debug("API execute failed");
                        }
                    } catch (e) {
                        console.debug(e);

                    }

                },

                error: function() {
                    console.debug("APIHandle?cmd=del_admin" + "&" + email);
                    console.debug("Delete: del fail");
                }

            });
        });

        $(".btn.btn-block.btn-warning").click(function () {
            var td = $(this).parent().parent().children()[3];
            var email = $(td).text();
            console.log("Delete: " + email);
            $.ajax({
                type: "post",
                dataType: "json",
                url: "APIHandle?cmd=rst_passwd" + "&arg=" + email,
                success: function(data) {
                    console.log("APIHandle?cmd=rst_passwd" + "&arg=" + email);
                    console.log(data);
                    //var result = eval('(' + data + ')');

                    try {
                        if (data.success == 1) {
                            console.log("API execute done");
                            $(".modal-body").html("密码已重置为<strong>123456789</strong>");
                            $('#infoModal').modal('show');
                            //$('#myModal').modal('show');
                        }
                        else {
                            console.debug("API execute failed");
                        }
                    } catch (e) {
                        console.debug(e);

                    }

                },

                error: function() {
                    console.debug("APIHandle?cmd=rst_passwd" + "&" + email);
                    console.debug("Delete: del fail");
                }

            });
        });


        //function delAdmin(target) {
//            console.log($(target));
//            var td = $(target).parent().parent().children()[3];
//            var email = $(td).text();
//            console.log("Delete: " + email);
//            $.ajax({
//                type: "post",
//                dataType: "json",
//                url: "APIHandle?cmd=del_admin" + "&arg=" + email,
//                success: function(data) {
//                    console.log("APIHandle?cmd=del_admin" + "&arg=" + email);
//                    console.log(data);
//                    //var result = eval('(' + data + ')');
//
//                    try {
//                        if (data.success == 1) {
//                            $(td).parent().hide();
//                            console.log("API execute done");
//                        }
//                        else {
//                            console.debug("API execute failed");
//                        }
//                    } catch (e) {
//                        console.debug(e);
//
//                    }
//
//                },
//
//                error: function() {
//                    console.error("APIHandle?cmd=del_admin" + "&" + email);
//                    console.error("Delete: del fail")
//                }
//
//            });
//
//}

//        var modal= $('#myModal');
//        modal.on("show.bs.modal", function (e) {
//            var btn = $(e.relatedTarget);
//            var id = btn.da
//            delAdmin(id);
//
//        });
    </script>

</section>
<!-- /.content -->