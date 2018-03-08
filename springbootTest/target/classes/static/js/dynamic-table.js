var Script = function () {

    // begin first table
    $('#sample_1').dataTable(
        {
            "sDom": "<'row'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6'p>>",
            "sPaginationType": "bootstrap",
            "oLanguage": {
                "sLengthMenu": "每页 _MENU_ 项",
                "sSearch": "搜索:",
                "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
                "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
                "sEmptyTable": "表中数据为空",
                "sZeroRecords": "没有匹配结果",
                "sProcessing": "处理中...",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sLoadingRecords": "载入中...",
                "oPaginate": {
                    "sPrevious": "上一页",
                    "sNext": "下一页"

                }
            },
            "iDisplayLength": 10,//每页的行数，每页默认数量:10
            "bAutoWidth": false, //自适应宽度
            "bFilter": true,//是否显示搜索框
            "bProcessing": false,                   // 是否显示取数据时的那个等待提示
            "bServerSide": true,                    //这个用来指明是通过服务端来取数据
            "sAjaxSource": "/tableDemoAjax",      //这个是请求的地址
            "fnServerData": retrieveData,            // 获取数据的处理函数
            "bSort": true, //是否支持排序功能
            //配置列要显示的数据
            "columns": [
                {"data": null},
                {"data": "userName"},
                {"data": "nickName"},
                {"data": "passWord"},
                {"data": ""}//操作按钮列
            ],

            //按钮列
            "columnDefs": [{
                "bSortable": false,
                targets: [0],
                defaultContent: ""
            },
                {
                    "bSortable": false,
                    "targets": [-1],//删除
                    "data": null,
                    "defaultContent": "<button id='editrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i>编辑</button>" +
                    "<button id='delrow' class='btn btn-primary' type='button'><i class='fa fa-trash-o'></i>删除</button>"
                }],
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }

        });

    // 3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
    function retrieveData(sSource, aoData, fnCallback) {
        $.ajax({
            url: sSource,                              //这个就是请求地址对应sAjaxSource
            data: {"aoData": JSON.stringify(aoData)},   //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数 ,分页,排序,查询等的值
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (result) {
                fnCallback(result);                     //把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
            },
            error: function (msg) {
            }
        });
    }

    jQuery('#sample_1 .group-checkable').change(function () {
        var set = jQuery(this).attr("data-set");
        var checked = jQuery(this).is(":checked");
        jQuery(set).each(function () {
            if (checked) {
                $(this).attr("checked", true);
            } else {
                $(this).attr("checked", false);
            }
        });
        jQuery.uniform.update(set);
    });

    jQuery('#sample_1_wrapper .dataTables_filter input').addClass("form-control"); // modify table search input
    jQuery('#sample_1_wrapper .dataTables_length select').addClass("form-control"); // modify table per page dropdown


}();