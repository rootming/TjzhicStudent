<%@ page import="java.util.LinkedList" %>
<%@ page import="rootming.tjzhic.utils.ModelUtils" %>
<%@ page import="rootming.tjzhic.model.Group" %>
<%@ page import="java.lang.reflect.InvocationTargetException" %>
<%@ page import="rootming.tjzhic.model.Log" %><%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/6
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Content Header (PageData header) -->
<section class="content-header">
    <h1>登陆历史</h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
        <li class="active">登陆历史</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <!-- Your PageData Content Here -->
    <div class="box" ng-app="historyData-box" ng-controller="siteCtrl">
        <div class="box-header">
            <h3 class="box-title">系统登陆历史记录</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap"><div class="row"><div class="col-sm-6"></div><div class="col-sm-6"></div></div><div class="row"><div class="col-sm-12"><table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
                <thead>
                <tr role="row">
                    <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="">序号</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">用户名</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">用户组</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">登录时间</th>
                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="">登陆IP</th>
                </tr>
                </thead>
                <tbody>
                <%
                    LinkedList<Object> logs;
                    LinkedList<Object> groups;
                    try {
                        logs = ModelUtils.queryAllObject(Log.class);
                        groups = ModelUtils.queryAllObject(Group.class);

                        for(int i = 0; i < logs.size(); i++) {
                            Log log = (Log)logs.get(i);
                            out.print("<tr role=\"row\" class=\"odd\">");
                            out.print("<td>" + i + "</td>");
                            out.print("<td>" + log.getName() + "</td>");
                            for(int j = 0; j < groups.size(); j++) {
                                Group group = (Group)groups.get(j);
                                if(group.getGroupName().equals(log.getGroup())) {
                                    out.print("<td>" + group.getGroupInfo() + "</td>");
                                    break;
                                }
                            }
                            out.print("<td>" + log.getTime() + "</td>");
                            out.print("<td>" + log.getIp() + "</td>");
                            out.print("</tr>");
                        }
                    } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                %>
                <%--<tr role="row" class="odd">--%>
                    <%--<td></td>--%>
                    <%--<td></td>--%>
                    <%--<td></td>--%>
                    <%--<td></td>--%>
                    <%--<td></td>--%>
                <%--</tr>--%>

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
//        $.ajax({
//                type: "post",
//                dataType: "json",
//                url: "DataHandle?cmd=get_his",
//                success: function (data) {
//                    var tr = $(".odd");
//
//                    $.each(data, function (index, it) {
//                        var clonedTr = tr.clone();
//                        var _index = index;
//                        clonedTr.children("td").each(function(inner_index){
////                            for (var i = 0; i < data.length; i++) {
////                                var page = data[i];
////                                console.log(page.page);
////                                for (var j = 0; j < page.state.length; j++) {
////                                    var item = page.state[j];
////                                    console.log("ID:" + item.id);
////                                    console.log("Name:" + item.name);
////                                    console.log("Group:" + item.group);
////                                    console.log("Time:" + item.time);
////                                    console.log("IP:" + item.ip);
////                                }
////                            }
//                            switch(inner_index){
//                                case(0):
//                                    $(this).html(it.id);
//                                    break;
//                                case(1):
//                                    $(this).html(it.name);
//                                    break;
//                                case(2):
//                                    $(this).html(it.group);
//                                    break;
//                                case(3):
//                                    $(this).html(it.time);
//                                    break;
//                                case(4):
//                                    $(this).html(it.ip);
//                                    break;
//
//                            }
//                        });
//                    });
//                }
//            }
//        );
    </script>
</section>
<!-- /.content -->
