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
    //    int userCount = 0;
//    int adminCount = 0;
//    //ServletContext context = session.getServletContext();
//    int onlineCount = LoginHandle.getActiveSessions();
//    try {
//        userCount = ModelUtils.queryObject(User.class, "user_group", "user").size();
//        adminCount = ModelUtils.queryAllObject(User.class).size() - userCount;
//    } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
//        e.printStackTrace();
//    }

%>


<!-- Content Header (PageData header) -->
<section class="content-header">
    <h1>系统状态
        <small>简略信息</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
        <li class="active">系统状态</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <!-- Your PageData Content Here -->

    <div class="row">
        <div class="col-lg-3 col-xs-6">
            <!-- small box -->
            <div class="small-box bg-aqua">
                <div class="inner">
                    <h3 id="user"></h3>
                    <p>注册人数</p>
                </div>
            </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
            <!-- small box -->
            <div class="small-box bg-green">
                <div class="inner">
                    <h3 id="admin"></h3>
                    <p>系统管理员数量</p>
                </div>
            </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
            <!-- small box -->
            <div class="small-box bg-yellow">
                <div class="inner">
                    <h3 id="online"></h3>
                    <p>在线人数</p>
                </div>
            </div>
        </div>
        <!-- ./col -->
    </div>

    <div class="box box-info">
        <div class="box-header">
            <h3 class="box-title">已定义阶段</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                <div class="row">
                    <div class="col-sm-6">

                    </div>
                    <div class="col-sm-6">

                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <table id="example2" class="table table-bordered table-hover dataTable" role="grid"
                               aria-describedby="example2_info">
                            <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                    aria-sort="ascending" aria-label="">编号
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                    aria-label="">阶段名称
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                    aria-label="">开始时间
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                    aria-label="">结束时间
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                    aria-label="">阶段说明
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                    aria-label="">操作
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr role="row" class="odd">
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <button type="button" class="btn btn-block btn-danger"></button>
                                </td>
                            </tr>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th rowspan="1" colspan="1">编号</th>
                                <th rowspan="1" colspan="1">阶段名称</th>
                                <th rowspan="1" colspan="1">开始时间</th>
                                <th rowspan="1" colspan="1">结束时间</th>
                                <th rowspan="1" colspan="1">阶段说明</th>
                                <th rowspan="1" colspan="1">操作</th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>

                </div>

            </div>

        </div>
        <div class="modal modal-success" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="resetModalLabel">信息</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="info-modal-box">
                        删除成功
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline" data-dismiss="modal"
                                onclick="$(this).modal('hide');">确认
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal modal-warning" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="errorModalLabel">错误</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="error-modal-box">
                        删除失败
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline" data-dismiss="modal"
                                onclick="$(this).modal('hide');">确认
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script>

        function buttonAdd() {
            $(".btn.btn-block.btn-danger").click(function () {
                var td = $(this).parent().parent().children()[0];
                var id = $(td).text();
                console.log("Delete: " + id);

                var obj = JSON.stringify({"cmd": "del_stage", "arg": id});

                $.ajax({
                    type: "post",
                    url: "APIHandle",
                    dataType: "json",
                    data: obj,
//                url: "APIHandle?cmd=del_admin" + "&arg=" + email,
                    success: function (data) {
                        console.log(data);
                        //var result = eval('(' + data + ')');
                        try {
                            if (data.success === 1) {
                                $(td).parent().hide();
                                $('#infoModal').modal('show');
                                console.log("API execute done");
                            }
                            else {
                                $('#errorModal').modal('show');
                                console.debug("API execute failed");
                            }
                        } catch (e) {
                            console.debug(e);

                        }

                    },

                    error: function () {
                        $('#errorModal').modal('show');
                    }

                });
            });
        }


        function updateCount() {
            var obj = JSON.stringify({"cmd": "get_state", "arg": ""});

            $.ajax({
                type: "post",
                url: "APIHandle",
                dataType: "json",
                data: obj,

                success: function (result) {
                    console.debug(result);
                    try {
                        //var obj = eval('(' + str + ')');
                        $("#user").text(result.userCount);
                        $("#admin").text(result.adminCount);
                        $("#online").text(result.onlineCount);
                    } catch (e) {
                        console.debug(e);
                    }
                }
            });
        }

        function getStageInformation() {

            var obj = JSON.stringify({"cmd": "get_stage", "arg": ""});

            $.ajax({
                type: "post",
                url: "APIHandle",
                dataType: "json",
                data: obj,
//                url: "APIHandle?cmd=del_admin" + "&arg=" + email,
                success: function (data) {
                    console.log(data);
                    //var result = eval('(' + data + ')');
                    try {
                        var tableDom = $('tbody');
                        var html;
//                            var list = data.list;
//
                        for (var i = 0, len = data.length; i < len; i++) {
                            html += '<tr role="row" class="odd">';
                            html += '<td>' + data[i].id + '</td>';
                            html += '<td>' + data[i].name + '</td>';
                            html += '<td>' + data[i].startTime + '</td>';
                            html += '<td>' + data[i].endTime + '</td>';
                            html += '<td>' + data[i].information + '</td>';
                            html += '<td><button type="button" class="btn btn-block btn-danger">删除</button></td>';
                            html += '</tr>';

                        }
                        tableDom.html(html);
                        buttonAdd();


                        console.log("API execute done");
                    } catch (e) {
                        console.debug(e);

                    }

                },

                error: function () {
                    $('#errorModal').modal('show');
                }

            });


        }


        updateCount();  // 第一次调用, 更新一下数据, 防止空白
        getStageInformation();

        $(function () {
            setInterval("updateCount()", 60000); //每隔60秒刷新
        });


    </script>
</section>
<!-- /.content -->
