<%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/6
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Content Header (PageData header) -->
<section class="content-header">
    <h1>修改密码</h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
        <li class="active">修改密码</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <!-- Your PageData Content Here -->
    <div class="callout callout-warning">
        <h4>提示</h4>
        <p>请确认信息无误后操作, 操作不可逆！</p>
    </div>

    <div class="row">
        <div class="passwordbox col-md-10">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">信息</h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->
                <div>
                    <form role="form">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="exampleInputEmail1">邮箱</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入邮箱">
                            </div>

                            <div class="form-group">
                                <label for="password">密码</label>
                                <input type="password" class="form-control" id="password" placeholder="请输入新密码">
                            </div>

                            <div class="form-group">
                                <label for="confirmpassword">确认密码</label>
                                <input type="password" class="form-control" id="confirmpassword" placeholder="请再次输入新密码">
                            </div>
                        </div>
                        <!-- /.box-body -->

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</section>
<!-- /.content -->
