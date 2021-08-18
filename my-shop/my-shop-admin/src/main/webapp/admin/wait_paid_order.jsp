<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="../template/header_common.jsp" %>
    <title>待付款订单</title>

</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <!-- 导航栏 -->
    <%@ include file="../template/main_header.jsp" %>

    <!-- 主侧边栏容器 -->
    <%@ include file="../template/main_sidebar.jsp" %>

    <!-- Content Wrapper. 包含页面内容 -->
    <div class="content-wrapper">
        <!-- 内容标题（页面标题） -->
        <%-- <section class="content-header">
             <div class="container-fluid">
                 <div class="row mb-2">
                     <div class="col-sm-6">
                         <h1>项目</h1>
                     </div>
                     <div class="col-sm-6">
                         <ol class="breadcrumb float-sm-right">
                             <li class="breadcrumb-item"><a href="#">主页</a></li>
                             <li class="breadcrumb-item active">项目</li>
                         </ol>
                     </div>
                 </div>
             </div><!-- /.container-fluid -->
         </section>--%>

        <!-- 主体内容 -->
        <section class="content">

            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">待付款订单</h3>

                    <div class="card-tools">
                        <div class="input-group input-group-sm" style="width: 150px;">
                            <input type="text" name="table_search" class="form-control float-right" placeholder="搜索">

                            <div class="input-group-append">
                                <button type="button" id="btnSearch" class="btn btn-default"><i
                                        class="fas fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.card-header -->
                <div class="card-body p-0">
                    <table class="table table-striped projects" id="example1">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>收货人</th>
                            <th>用户留言</th>
                            <th>订单总金额</th>
                            <th>实收金额</th>
                            <th>配送方式</th>
                            <th>下单时间</th>
                            <th>订单状态</th>


                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <!-- /.card-body -->
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!--main-footer-->
    <%@include file="../template/main_footer.jsp" %>
</div>
<!-- ./wrapper -->

<!-- 用于演示 AdminLTE  -->
<%--<script src="static/js/demo.js"></script>--%>

<!-- DataTables -->
<link rel="stylesheet"
      href="./static/css/datatables.net-bs4/css/dataTables.bootstrap.min.css">
<!-- DataTables -->
<script src="./static/js/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="./static/js/datatables.net-bs4/js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript">
    const table = $("#example1").DataTable({
        // 是否允许检索
        searching: false,
        // 是否允许排序
        ordering: false,
        // 初期排序列
        //"order": [[0,'asc'],[1,'desc']],
        // 是否显示情报 就是"当前显示1/100记录"这个信息
        info: true,
        // 是否允许翻页，设成false，翻页按钮不显示
        paging: true,
        // 水平滚动条
        scrollX: false,
        // 垂直滚动条
        scrollY: false,
        // 件数选择功能 默认true
        lengthChange: true,
        // 件数选择下拉框内容
        lengthMenu: [10, 25, 50, 75],
        // 每页的初期件数 用户可以操作lengthMenu上的值覆盖
        pageLength: 10,
        //翻页按钮样式
        // numbers:数字
        // simple:前一页，后一页
        // simple_numbers:前一页，后一页，数字
        // full:第一页，前一页，后一页，最后页
        //full_numbers:第一页，前一页，后一页，最后页，数字
        //first_last_numbers:第一页，最后页，数字
        pagingType: "full_numbers",
        // 自动列宽
        autoWidth: true,
        // 是否表示 "processing" 加载中的信息，这个信息可以修改
        processing: true,
        // 每次创建是否销毁以前的DataTable,默认false
        destroy: false,
        //汉化
        language: {
            processing: "处理中......",
            // 当前页显示多少条
            lengthMenu: "显示 _MENU_ 条",
            // _START_（当前页的第一条的序号） ,_END_（当前页的最后一条的序号）,_TOTAL_（筛选后的总件数）,
            // _MAX_(总件数),_PAGE_(当前页号),_PAGES_（总页数）
            info: "显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            // 没有数据的显示（可选），如果没指定，会用zeroRecords的内容
            emptyTable: "没有数据",
            // 筛选后，没有数据的表示信息，注意emptyTable优先级更高
            zeroRecords: "没有数据",
            // 千分位的符号，只对显示有效，默认就是","  一般不要改写
            //"thousands": "'",
            // 小数点位的符号，对输入解析有影响，默认就是"." 一般不要改写
            //"decimal": "-",
            // 翻页按钮文字控制
            paginate: {
                first: "第一页",
                last: "最后一页",
                next: "下一页",
                previous: "前一页"
            }
        },
        // 默认是false
        // 如果设为true，将只渲染当前也的html，速度会很快，但是通过API就访问不到所有页的数据，有利有弊
        //"deferRender": false,
        // 服务器端处理方式
        serverSide: true,

        // ajax选项 可以直接简单指定成请求的文件
        //"ajax": "data.json",
        // 也可以用对象来配置，更加灵活
        ajax: {
            // url可以直接指定远程的json文件，或是MVC的请求地址 /Controller/Action
            url: "orderManagement/page1",
            type: 'POST',
            // 传给服务器的数据，可以添加我们自己的查询参数
            data: function (param) {
                const dataParam = {};
                //设置查询参数,服务端就可以接收
                //dataParam.username = $("#inputSearchUsername").val();
                dataParam.draw = param.draw;
                dataParam.start = param.start;
                dataParam.length = param.length;
                return dataParam;
            },
            //用于处理服务器端返回的数据。 dataSrc是DataTable特有的
            dataSrc: function (result) {
                if (result.state == 0) {
                    //处理成功
                    return result.data;
                } else if (result.state == -1) {
                    //登录过期，重新登陆
                    //弹出提示信息
                    alert(result.message);
                    //跳转login.jsp登录页面
                    window.location.href = "login.jsp";
                } else {
                    //处理失败
                    alert(result.message);
                }
            }
        },
        columns: [
            {data: 'oid', defaultContent: ""},
            {data: 'consignee', defaultContent: ""},
            {data: 'guest_book', defaultContent: ""},
            {data: 'total_amount', defaultContent: ""},
            {data: 'received_amount', defaultContent: ""},
            {data: 'distribution', defaultContent: ""},
            {data: 'order_data', defaultContent: ""},
            {data: 'state', defaultContent: ""},

        ]
    });
    $("#btnSearch").click(function () {
        table.ajax.reload();
    });

    //重置密码
    function resetPassword(oid) {
        //利用ajax技术请求后台根据id查询company信息
        $.ajax({
            url: "fukuan",
            data: {oid:oid},
            type: "POST",
            dataType: "json",
            success: function (result) {
                if (result.state == 0) {//表示后台查询到数据或者处理成功了
                    window.location.href = "admin/wait_paid_order.jsp";
                    //alert(result.message);
                } else if (result.state == -1) {
                    //弹出提示信息
                    alert(result.message);
                } else {
                    //处理失败
                    alert(result.message);
                }

            },
            error: function (e) {
                alert(e);
            }
        });
    }
</script>
</body>
</html>
