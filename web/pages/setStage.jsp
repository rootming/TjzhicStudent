<%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/6
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Content Header (PageData header) -->
<section class="content-header">
    <h1>阶段定义</h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
        <li class="active">阶段定义</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <!-- Your PageData Content Here -->
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">阶段添加</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form role="form">
            <div class="box-body">
                <div class="form-group">
                    <label for="stateID">阶段编号</label>
                    <input type="text" class="form-control" name="stateID" id="stateID" placeholder="编号">
                </div>

                <div class="form-group">
                    <label for="stateName">阶段名称</label>
                    <input type="text" class="form-control" name="stateName" id="stateName" placeholder="邮箱">
                </div>

                <div class="form-group">
                    <label for="startTime">开始时间</label>
                    <input type="datetime-local" class="form-control" name="startTime" id="startTime">
                </div>

                <div class="form-group">
                    <label for="endTime">结束时间</label>
                    <input type="datetime-local" class="form-control" name="endTime" id="endTime">
                </div>
                <div class="form-group">
                    <label for="stateInfo">阶段说明</label>
                    <input type="text" class="form-control" name="stateInfo" id="stateInfo">
                </div>
            </div>
            <!-- /.box-body -->


            <div class="box-footer">
                <button type="reset" class="btn btn-default">清除</button>
                <button id="submit" type="button" class="btn btn-info pull-right">添加</button>
            </div>
            <p class="login-box-msg" id="message" style="color: red;"></p>
            <!-- /.box-footer -->
        </form>
    </div>
    <div class="modal modal-success" id="infoModal" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="resetModalLabel">信息</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="info-modal-box">
                    添加成功
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline" data-dismiss="modal"
                            onclick="$(this).modal('hide');">确认
                    </button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal modal-warning" id="errorModal" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="errorModalLabel">错误</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="error-modal-box">
                    添加失败
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline" data-dismiss="modal"
                            onclick="$(this).modal('hide');">确认
                    </button>
                </div>
            </div>
        </div>
    </div>

    <script>

        var info = '';
        $('#reset').click(function () {
            $("input").text('');
            $('#message').fadeOut();
        });

        $("#submit").click(function () {
            var argument = {};
            argument.id = $("#stateID").val();
            argument.name = $("#stateName").val();
            argument.startTime = $("#startTime").val();
            argument.endTime = $("#endTime").val();
            argument.information = $("#stateInfo").val();

            var argObj = JSON.stringify(argument);

            var obj = JSON.stringify({"cmd": "add_stage", "arg": argObj});

            console.debug(obj);

            $.ajax({
                type: "post",
                url: "APIHandle",
                dataType: "json",
                data: obj,

                success: function (result) {
                    console.debug(result);
                    try {
                        if (result.success == 1) {
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
                    console.debug("API execute failed");
                }

            });

        })

    </script>

</section>
<!-- /.content -->
