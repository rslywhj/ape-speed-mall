<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="../template/header_common.jsp" %>
    <title>Ape-Speed后台管理系统</title>

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

        <section class="content">
            <div class="container-fluid">
                <!-- Small boxes (Stat box) -->
                <div class="row">

                    <div class="col-lg-2 col-6">
                        <!-- small box -->
                        <div class="small-box bg-red">
                            <div class="inner">
                                <img src="static/img/logo.png" class="img-size-64">
                                <div class="company c14_555">
                                    猿速商城<br>
                                    联系电话:400-8888-8888</div>
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-2 col-4">
                        <!-- small box -->
                        <div class="small-box bg-green">
                            <div class="inner">
                                <p>在售商品</p>
                                <h3>${sessionScope.productCount}</h3>

                            </div>
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>

                            <div class="inner">
                                <p>仓库商品</p>
                                <h3>${sessionScope.warehouseCount}</h3>


                            </div>
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-2 col-4">
                        <!-- small box -->
                        <div class="small-box bg-yellow">
                            <div class="inner">
                                <p>待发货</p>
                                <h3>${sessionScope.pendingCount}</h3>


                            </div>
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>


                            <div class="inner">
                                <p>已发货</p>
                                <h3>${sessionScope.shippedCount}</h3>


                            </div>
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>

                        </div>
                    </div>


                </div>
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
<link rel="stylesheet" href="./static/css/datatables.net-bs4/css/dataTables.bootstrap.min.css">
<!-- DataTables -->
<script src="./static/js/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="./static/js/datatables.net-bs4/js/dataTables.bootstrap.min.js"></script>

</body>
</html>