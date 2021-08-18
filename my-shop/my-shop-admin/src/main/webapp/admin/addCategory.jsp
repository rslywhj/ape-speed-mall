<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="../template/header_common.jsp" %>
    <title>新增类别</title>

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
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>增加类别</h1>
                    </div>
                    <%--<div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">主页</a></li>
                            <li class="breadcrumb-item active">通用表单</li>
                        </ol>
                    </div>--%>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- 主体内容 -->
        <section class="content">

            <div class="card-body">
                <!-- left column -->

                <!-- general form elements -->
                <div class="card card-primary">
                    <div class="card-header">
                        <h3 class="card-title">新增类别</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- form start -->
                    <form role="form" method="post" action="add/category">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="exampleInputEmail1">一级类别</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入一级分类"name="first_name">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">二级类别</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入二级分类" name="second_name">
                            </div>
                        </div>
                        <!-- /.card-body -->

                        <div class="card-footer">
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                    </form>
                </div>

                <!-- /.card -->



                <!-- /.card-footer -->
                </form>

            </div>

        </section>

        <footer class="main-footer">
            <div class="float-right d-none d-sm-block">
                <b>版本</b> 3.0.5
            </div>
            <strong>Copyright &copy; 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> 保留所有
            权利。
        </footer>

        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- 控制侧边栏内容在这里 -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="./static/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="./static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- bs-custom-file-input -->
    <script src="./static/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
    <!-- AdminLTE App -->
    <script src="static/js/adminlte.min.js"></script>
    <!-- 用于演示 AdminLTE  -->
    <script src="static/js/demo.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            bsCustomFileInput.init();
        });
    </script>
</body>
</html>