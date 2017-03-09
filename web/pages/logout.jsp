<%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/6
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>退出系统<small>退出登录状态</small></h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
        <li class="active">登出系统</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <div class="callout callout-info">
        <h4>提示</h4>

        <p>点击退出按钮, 将可以安全的退出系统</p>
    </div>
    <!-- Default box -->
        <div class="example-modal">
            <div class="modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span></button>
                            <h4 class="modal-title">退出系统</h4>
                        </div>
                        <div class="modal-body">
                            <p>此操作将清除会话</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" onclick="window.location.href='LogoutHandle'" class="btn btn-primary">退出</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
        </div>

</section>
<!-- /.content -->