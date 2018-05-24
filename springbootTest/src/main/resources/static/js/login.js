//添加后台管理员
$('#login').click(function () {
    $("#loginForm").ajaxSubmit({
        url : "/user/login",
        type : "post",
        dataType : 'json',
        success : function(data) {
            window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.info, {
                onOk: function () {
                    if (data.status == 1) {
                        location.reload();
                    }
                }
            });
        },
        error : function(data) {
            //发送失败
            if (status == "timeout") {
                $("#message").text("发送超时请重发");
            }
        }
    });
});