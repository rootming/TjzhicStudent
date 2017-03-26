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
                                <label for="email">邮箱</label>
                                <input type="email" class="form-control" name="email" id="email" placeholder="请输入邮箱">
                            </div>

                            <div class="form-group">
                                <label for="password">密码</label>
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="请输入新密码">
                            </div>

                            <div class="form-group">
                                <label for="confirmPassword">确认密码</label>
                                <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
                                       placeholder="请再次输入新密码">
                            </div>
                        </div>
                        <!-- /.box-body -->

                        <div class="box-footer">
                            <button id="submit" type="button" class="btn btn-primary">提交</button>
                        </div>

                        <p class="login-box-msg" id="message" style="color: red;"></p>

                    </form>
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
                                    密码修改成功
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
                                    密码修改失败
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
            </div>
        </div>
    </div>
    <script>

        var info = '';
        $('#reset').click(function () {
            $(":text,:password").text('');
            $('#message').fadeOut();
        });

        var emailPattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        var passwordPattern = /^\w{6,20}$/;


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
            argument.email = $("#email").val();
            argument.password = $("#password").val();
            argument.confirmPassword = $("#confirmPassword").val();

            var argObj = JSON.stringify(argument);

            var obj = JSON.stringify({"cmd": "mod_all_pass", "arg": argObj});

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
