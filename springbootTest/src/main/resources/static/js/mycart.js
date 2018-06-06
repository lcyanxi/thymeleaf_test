/**
 * Created by lcyanxi on 2018/5/30.
 */
//加入购物车
$('#add_cart').click(function () {
    var pid=$("#pid").html();
    // 查看是否登录
    if (pid==0) {
        window.wxc.xcConfirm("请先去登录！！", window.wxc.xcConfirm.typeEnum.warning, {
            onOk: function () {
                return false;
            }
        });
    }
    $.ajax({
        url: "/cart/addCart",
        type: "POST",
        async: false,
        data: {
            pid: pid,
            price:$("#item_price").html()
        },
        timeout: 30000,       //超时时间
        dataType: "json",     //返回的数据类型
        success: function (data) {
            window.wxc.xcConfirm(data.message, window.wxc.xcConfirm.typeEnum.success, {
                onOk: function () {
                }
            });
        },
        complete: function (XMLHttpRequest, status) {

            //发送失败
            if (status == "timeout") {
                $("#message").text("发送超时请重发");
            }
        }
    });
});
