// 局部刷新页面


function load(addr) {
    $.ajax({
        type: "post",
        url: addr,
        beforeSend: function(XMLHttpRequest){
        },
        success: function(data){
            // alert(addr);
            $(".content-wrapper" ).load(addr, function() {
                console.log("reloaded page: " + addr);
            });
        },
        error: function(){
            //请求出错处理
            console.error("page not found: " + addr);
        }
    });

}

window.onload = function () {

        $("a[url]").click(function () {
            $("li.active").removeClass("active");
            $(this).parent().addClass("active");
            load($(this).attr("url"));
        });

};
