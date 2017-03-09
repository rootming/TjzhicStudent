window.onload = function() {
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

    $('#code').blur(function () {
        if($('#code').val() == "") {
            info = '请输入验证码';
            $('#message').text(info);
            $('#message').css('color', 'red');
            $('#message').fadeIn();
        }
        else {
            $('#message').fadeOut();
        }

    });
    



};