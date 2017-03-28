<%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/27
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="content-header">
    <h1>增加管理员</h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>console</a></li>
        <li class="active">增加管理员</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">管理员信息</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form role="form">
            <div class="box-body">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
                </div>

                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" name="email" id="email" placeholder="请输入邮箱">
                </div>

                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" name="password" id="password"
                           placeholder="请输入密码">
                </div>

                <div class="form-group">
                    <label for="confirmPassword">确认密码</label>
                    <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
                           placeholder="请再次输入密码">
                </div>
                <div class="form-group">
                    <label>管理员类型</label>
                    <select class="form-control select2" id="group" name="group">
                        <option selected="selected" value="sysadmin">系统管理员</option>
                        <option value="eduadmin">教务管理员</option>
                        <option value="stuadmin">招生管理员</option>
                    </select>
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
                    管理员添加成功
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
                    管理员添加失败
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
            $(":text,:password").text('');
            $('#message').fadeOut();
        });

        var usernamePattern = /^\w{6,20}$/;
        var emailPattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        var passwordPattern = /^\w{6,20}$/;

        $('#username').blur(function () {
            if (!usernamePattern.test($('#username').val())) {
                info = '用户名由ASCII字母组成, 长度为6-20位';
                $('#message').text(info);
                $('#message').css('color', 'red');
                $('#message').fadeIn();
            }
            else {
                $('#message').fadeOut();
            }
        });

        $('#email').blur(function () {
            if (!emailPattern.test($('#email').val())) {
                info = 'email格式不合法';
                $('#message').text(info);
                $('#message').css('color', 'red');
                $('#message').fadeIn();
            }
            else {
                $('#message').fadeOut();
            }
        });

        $('#password').blur(function () {
            if (!passwordPattern.test($('#password').val())) {
                info = '密码由ASCII字母组成, 长度为6-20位';
                $('#message').text(info);
                $('#message').css('color', 'red');
                $('#message').fadeIn();
            }
            else {
                $('#message').fadeOut();
            }
        });

        $('#confirmpassword').blur(function () {
            if (!passwordPattern.test($('#confirmpassword').val())) {
                info = '密码由ASCII字母组成, 长度为6-20位';
                $('#message').text(info);
                $('#message').css('color', 'red');
                $('#message').fadeIn();

            }
            else {
                $('#message').fadeOut();
            }

            if ($('#confirmpassword').val() != $('#password').val()) {
                info = '密码不符合';
                $('#message').text(info);
                $('#message').css('color', 'red');
                $('#message').fadeIn();
            }
            else {
                $('#message').fadeOut();
            }
        });


        $("#submit").click(function () {
            argument = {};
            argument.username = $("#username").val();
            argument.email = $("#email").val();
            argument.password = $("#password").val();
            argument.confirmPassword = $("#confirmPassword").val();
            argument.group = $("#group").val();

            var argObj = JSON.stringify(argument);

            var obj = JSON.stringify({"cmd": "add_admin", "arg": argObj});

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
