<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="../template/header_common.jsp" %>
    <title>新增商品</title>
    <script type="text/javascript">


    </script>
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
                        <h1>增加商品</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">主页</a></li>
                            <li class="breadcrumb-item active">通用表单</li>
                        </ol>
                    </div>
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
                        <h3 class="card-title">商品信息</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- form start -->
                    <form role="form" action="addProductServlet" method="post" enctype="multipart/form-data">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="exampleInputEmail1">商品名字</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入商品名字"name="product_name" >
                                <p id="name1" style="font-size: 2px; color: red; "></p>
                            </div>
                            <div class="col-md-8">
                                <label for="des">描述：</label><br>
                                <textarea class="form-control" placeholder="请填写描述" name="des" id="des"></textarea>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">价格</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入商品价格" name="price">
                                <p id="price1" style="font-size: 2px; color: red; "></p>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">库存</label>
                                <input type="text" class="form-control" id="count" placeholder="请输入商品库存" name="num">
                                <p id="num1" style="font-size: 2px; color: red;"></p>
                            </div>

                            <div class="form-group">
                                上传图片: <input type="file" id="file" name="file"/>
                                <div id="result" ></div>


                                <script type="text/javascript">
                                    function ProcessFile(e) {
                                        var file = document.getElementById('file').files[0];
                                        if (file) {
                                            var reader = new FileReader();
                                            reader.onload = function (event) {
                                                var txt = event.target.result;
                                                var img = document.createElement("img");
                                                img.src = txt;//将图片base64字符串赋值给img的src
                                                img.width = 200;
                                                document.getElementById("result").appendChild(img);
                                            };
                                        }
                                        reader.readAsDataURL(file);
                                    }
                                    function contentLoaded() {
                                        document.getElementById('file').addEventListener('change',
                                            ProcessFile, false);
                                    }
                                    window.addEventListener("DOMContentLoaded", contentLoaded, false);
                                </script>
                            </div>

                            <div class="form-group" data-select2-id="29">
                                <label>一级类别</label>
                                <select class="form-control select2 select2-hidden-accessible" name="first_id"    id="selector1" onchange="typeChange()">
                                </select>
                                <p id="first1" style="font-size: 2px; color: red; "></p>
                            </div>

                            <div class="form-group" data-select2-id="29">
                                <label>二级类别</label>
                                <select class="form-control select2 select2-hidden-accessible" name="second_id" id="selector2">
                                </select>
                                <p id="second1" style="font-size: 2px; color: red; "></p>
                            </div>

                            <!-- /.card-body -->
                            <div class="card-footer">
                                <input type="submit" class="btn btn-primary" id="btn"/>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </section>
    </div>
    <script type="text/javascript">
        $("#exampleInputEmail1").blur(function () {
            if (isEmpty($("#exampleInputEmail1").val())){
                $("#name1").html("商品名不可为空");
                return;
            }

            <%--if (${sessionScope.bl1}){--%>
            <%--    $("#ppp").html("该商品已经存在");--%>
            <%--    return;--%>
            <%--}--%>

        });

        $("#exampleInputPassword1").blur(function () {
            if (isEmpty($("#exampleInputPassword1").val())){
                $("#price1").html("商品价格不可为空");
                return;
            }
        });

        $("#count").blur(function () {
            if (isEmpty($("#count").val())){
                $("#num1").html("库存不可为空");
                return;
            }
        });

        $("#selector1").blur(function () {
            if (isEmpty($("#selector1").val())){
                $("#first1").html("必须选择一级类别");
                return;
            }
        });

        $("#selector2").blur(function () {
            if (isEmpty($("#selector2").val())){
                $("#second1").html("必须选择二级类别");
                return;
            }
        });



        /**
         * 判断字符串是否为空，
         *          如果为空返回true
         *          如果不为空返回false
         * @param str
         * @returns {boolean}
         */
        function isEmpty(str) {
            if (str==null || str.trim()==""){
                return true;
            }
            return false;
        }

    </script>
    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>版本</b> 3.0.5
        </div>
        <strong>Copyright &copy; 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> 保留所有
        权利。
    </footer>
    <link rel="stylesheet"
          href="./static/css/datatables.net-bs4/css/dataTables.bootstrap.min.css">
    <!-- DataTables -->
    <script src="./static/js/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="./static/js/datatables.net-bs4/js/dataTables.bootstrap.min.js"></script>



    <script type="text/javascript">
        $.ajax({
            // url可以直接指定远程的json文件，或是MVC的请求地址 /Controller/Action
            url: "get-category",
            type: 'post',
            dataType: "json",
            // 传给服务器的数据，可以添加我们自己的查询参数
            data: {op:"first"},
            success: function (result) {

                if (result.state == 0) {//表示后台查询到数据或者处理成功了
                    console.log(result);
                    var option = $("<option>").val("").text("请选择");
                    $("#selector1").append(option);
                    $.each(result.data,function (index,data) {
                        console.log(index);
                        var option = $("<option>").val(data.first_id).text(data.first_name);
                        $("#selector1").append(option)

                    });
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




            },
            error: function (e) {
                alert(e);
            }
        });


        function typeChange(){
            var a=$("#selector1").val();
            console.log(a);
            $.ajax({
                // url可以直接指定远程的json文件，或是MVC的请求地址 /Controller/Action
                url: "get-category",
                type: 'post',
                dataType: "json",
                // 传给服务器的数据，可以添加我们自己的查询参数
                data: {op:"second",first_id:a},
                success: function (result) {
                    if (result.state == 0) {//表示后台查询到数据或者处理成功了
                        console.log(result);
                        $("#selector2").empty();
                        var option = $("<option>").val("").text("请选择");
                        $("#selector2").append(option);
                        $.each(result.data,function (index,data) {
                            console.log(index);
                            var option = $("<option>").val(data.second_id).text(data.second_name);
                            $("#selector2").append(option)

                        });

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

                },
                error: function (e) {
                    alert(e);
                }
            })
        }

    </script>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- 控制侧边栏内容在这里 -->
    </aside>

    <!-- jQuery -->
    <script src="static/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- bs-custom-file-input -->
    <script src="static/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
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
