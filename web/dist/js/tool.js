function ajaxClosure(cmd, data, func) {
    $.ajax({
        type: "post",
        url: "APIHandle",
        dataType: "json",
        data: {"cmd": cmd, "arg": data},
        success: func()
    });

}