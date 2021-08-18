<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="<%=request.getContextPath()%>/"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 告诉浏览器屏幕自适应 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet" href="static/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<%--<link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">--%>
<!-- overlayScrollbars -->
<link rel="stylesheet" href="static/css/adminlte.min.css">
<!-- 离线 Google 字体: Source Sans Pro -->
<%--<link href="/AdminLTE/AdminLTE-3.x/dist/css/google.css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">--%>
<!-- jQuery -->
<script src="static/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="static/js/adminlte.min.js"></script>

<script type="text/javascript">
    $(function () {
        //选择带有menu-open样式的dom去掉样式menu-open
        $(".nav-item").filter(".menu-open").removeClass("menu-open");
        //选择带有active样式的dom去掉样式active
        $(".nav-item a").filter(".active").removeClass("active");

        var a;
        //获取浏览器的访问location
        var location = window.location;

        $(".mt-2 a").each(function (i) {
            var href = $(this)[0].href;
            if (href == location.href) {
                a = $(this);
            }
        });

        if (a) {//a存在
            //a增加active样式
            a.addClass("active");
            //a的父元素父元素父元素增加active和menu-open
            a.parent().parent().parent().addClass("menu-open");
            //.menu-open 直接 子标签 a 添加激活样式
            $(".menu-open > a").addClass("active");
        }
    });

</script>